package com.epam.shape.model.repository;

import com.epam.shape.exception.ReaderException;
import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.entity.TriangleType;
import com.epam.shape.model.entity.comparator.TriangleComparator;
import com.epam.shape.model.initializer.InitRepository;
import com.epam.shape.model.repository.specification.Specification;
import com.epam.shape.model.repository.specification.impl.IdSpecification;
import com.epam.shape.model.repository.specification.impl.PerimeterMaxValueSpecification;
import com.epam.shape.model.repository.specification.impl.PositivePointsSpecification;
import com.epam.shape.model.repository.specification.impl.SquareIntervalSpecification;
import com.epam.shape.model.repository.specification.impl.TypeSpecification;
import com.epam.shape.model.warehouse.TrianglePropertyWarehouse;
import com.epam.shape.reader.TriangleReader;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleRepositoryTest {
    private TriangleRepository repository = TriangleRepository.getRepository();
    private TrianglePropertyWarehouse warehouse = TrianglePropertyWarehouse.getWarehouse();

    @BeforeMethod
    public void initializeRepositoryAndWarehouse() throws ReaderException {
        warehouse.clearWarehouse();
        repository.clearRepository();
        InitRepository initializer = new InitRepository();
        TriangleReader reader = new TriangleReader();
        List<String> lines = reader.readDataFromFile("data\\triangles.txt");
        initializer.initializeTriangleRepository(lines);
    }

    @Test
    public void queryTest1() {
        List<Triangle> expected = new ArrayList<>();
        expected.add(repository.get(3));
        Specification idSpecification = new IdSpecification(repository.get(3).getShapeId());
        List<Triangle> actual = repository.query(idSpecification);
        assertEquals(actual, expected);
    }

    @Test
    public void queryTest2() {
        List<Triangle> expected = new ArrayList<>();
        expected.add(repository.get(1));
        expected.add(repository.get(2));
        expected.add(repository.get(7));
        Specification perimeterSpecification = new PerimeterMaxValueSpecification(150);
        List<Triangle> actual = repository.query(perimeterSpecification);
        assertEquals(actual, expected);
    }

    @Test
    public void queryTest3() {
        List<Triangle> expected = new ArrayList<>();
        expected.add(repository.get(1));
        Specification positivePointsSpecification = new PositivePointsSpecification();
        List<Triangle> actual = repository.query(positivePointsSpecification);
        assertEquals(actual, expected);
    }

    @Test
    public void queryTest4() {
        List<Triangle> expected = new ArrayList<>();
        expected.add(repository.get(1));
        expected.add(repository.get(3));
        expected.add(repository.get(4));
        Specification squareSpecification = new SquareIntervalSpecification(40, 500);
        List<Triangle> actual = repository.query(squareSpecification);
        assertEquals(actual, expected);
    }

    @Test
    public void queryTest5() {
        List<Triangle> expected = new ArrayList<>();
        expected.add(repository.get(3));
        expected.add(repository.get(4));
        expected.add(repository.get(8));
        Specification typeSpecification = new TypeSpecification(TriangleType.ISOSCELES);
        List<Triangle> actual = repository.query(typeSpecification);
        assertEquals(actual, expected);
    }

    @Test
    public void sortTest1() {
        List<Triangle> expected = new ArrayList<>();
        expected.add(repository.get(4));
        expected.add(repository.get(7));
        expected.add(repository.get(6));
        expected.add(repository.get(3));
        expected.add(repository.get(8));
        expected.add(repository.get(0));
        expected.add(repository.get(5));
        expected.add(repository.get(1));
        expected.add(repository.get(2));
        List<Triangle> actual = repository.sort(TriangleComparator.FIRST_POINT_X_COORDINATE);
        assertEquals(actual, expected);
    }

    @Test
    public void sortTest2() {
        List<Triangle> expected = new ArrayList<>();
        expected.add(repository.get(1));
        expected.add(repository.get(7));
        expected.add(repository.get(0));
        expected.add(repository.get(3));
        expected.add(repository.get(4));
        expected.add(repository.get(8));
        expected.add(repository.get(5));
        expected.add(repository.get(2));
        expected.add(repository.get(6));
        List<Triangle> actual = repository.sort(TriangleComparator.SECOND_POINT_Y_COORDINATE.reversed());
        assertEquals(actual, expected);
    }

    @Test
    public void sortTest3() {
        List<Triangle> expected = new ArrayList<>();
        expected.add(repository.get(0));
        expected.add(repository.get(6));
        expected.add(repository.get(5));
        expected.add(repository.get(8));
        expected.add(repository.get(3));
        expected.add(repository.get(4));
        expected.add(repository.get(1));
        expected.add(repository.get(7));
        expected.add(repository.get(2));
        List<Triangle> actual = repository.sort(TriangleComparator.SQUARE);
        assertEquals(actual, expected);
    }

    @Test
    public void sortTest4() {
        List<Triangle> expected = new ArrayList<>();
        expected.add(repository.get(7));
        expected.add(repository.get(1));
        expected.add(repository.get(2));
        expected.add(repository.get(3));
        expected.add(repository.get(4));
        expected.add(repository.get(5));
        expected.add(repository.get(0));
        expected.add(repository.get(6));
        expected.add(repository.get(8));
        List<Triangle> actual = repository.sort(TriangleComparator.PERIMETER.reversed());
        assertEquals(actual, expected);
    }
}
