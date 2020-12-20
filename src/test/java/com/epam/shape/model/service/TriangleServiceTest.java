package com.epam.shape.model.service;

import com.epam.shape.model.entity.Point2D;
import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.entity.TriangleType;
import com.epam.shape.model.service.impl.TriangleServiceImpl;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleServiceTest {
    private TriangleService service = new TriangleServiceImpl();
    private List<Triangle> triangles;

    @DataProvider
    public Object[][] trianglesSquareData() {
        return new Object[][]{
                {triangles.get(0), 50d},
                {triangles.get(1), 50d},
                {triangles.get(2), 12d},
        };
    }

    @DataProvider
    public Object[][] trianglesPerimeterData() {
        return new Object[][]{
                {triangles.get(0), (10 * Math.sqrt(2) + 20)},
                {triangles.get(1), (10 * Math.sqrt(2) + 20)},
                {triangles.get(2), 16d},
        };
    }

    @DataProvider
    public Object[][] trianglesTypeData() {
        EnumSet<TriangleType> types1 = EnumSet.noneOf(TriangleType.class);
        types1.add(TriangleType.RECTANGULAR);
        types1.add(TriangleType.ISOSCELES);
        EnumSet<TriangleType> types2 = EnumSet.noneOf(TriangleType.class);
        types2.add(TriangleType.ACUTE);
        types2.add(TriangleType.ISOSCELES);
        return new Object[][]{
                {triangles.get(0), types1},
                {triangles.get(1), types1},
                {triangles.get(2), types2},
        };
    }

    @DataProvider
    public Object[][] trianglesSideLengthData() {
        return new Object[][]{
                {triangles.get(0).getPoint1(), triangles.get(0).getPoint2(), 10d},
                {triangles.get(1).getPoint1(), triangles.get(0).getPoint2(), 10d},
                {triangles.get(2).getPoint1(), triangles.get(2).getPoint2(), 5d}
        };
    }

    @BeforeClass
    public void setTriangles() {
        triangles = new ArrayList<>();
        triangles.add(new Triangle(new Point2D(0, 0), new Point2D(0, 10), new Point2D(10, 0)));
        triangles.add(new Triangle(new Point2D(0, 0), new Point2D(0, -10), new Point2D(-10, 0)));
        triangles.add(new Triangle(new Point2D(3, 2), new Point2D(6, 6), new Point2D(9, 2)));
    }

    @Test(dataProvider = "trianglesSquareData")
    public void findSquareTest(Triangle triangle, double expected) {
        double actual = service.findSquare(triangle);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "trianglesPerimeterData")
    public void findPerimeterTest(Triangle triangle, double expected) {
        double actual = service.findPerimeter(triangle);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "trianglesTypeData")
    public void findTriangleTypeTest(Triangle triangle, EnumSet<TriangleType> expected) {
        EnumSet<TriangleType> actual = service.findTriangleType(triangle);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "trianglesSideLengthData")
    public void findDistanceBetweenPoints(Point2D point1, Point2D point2, double expected) {
        double actual = service.findDistanceBetweenPoints(point1, point2);
        assertEquals(actual, expected);
    }
}
