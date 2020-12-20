package com.epam.shape.model.observer;

import com.epam.shape.exception.ReaderException;
import com.epam.shape.model.entity.Point2D;
import com.epam.shape.model.initializer.InitRepository;
import com.epam.shape.model.observer.impl.TriangleObserverImpl;
import com.epam.shape.model.repository.TriangleRepository;
import com.epam.shape.model.warehouse.TrianglePropertyWarehouse;
import com.epam.shape.reader.TriangleReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TriangleObserverImplTest {
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
    public void parameterChangedTest1() {
        double expected = 50;
        repository.get(0).attach(new TriangleObserverImpl());
        repository.get(0).setPoint1(new Point2D(0, 0));
        repository.get(0).setPoint2(new Point2D(0, 10));
        repository.get(0).setPoint3(new Point2D(10, 0));
        double actual = warehouse.get(repository.get(0).getShapeId()).getSquare();
        assertEquals(actual, expected);
    }

    @Test
    public void parameterChangedTest2() {
        double expected = 50;
        repository.get(3).setPoint1(new Point2D(0, 0));
        repository.get(3).setPoint2(new Point2D(10, 56));
        repository.get(3).setPoint3(new Point2D(-23, 47));
        double actual = warehouse.get(repository.get(3).getShapeId()).getSquare();
        assertEquals(actual, expected);
    }
}
