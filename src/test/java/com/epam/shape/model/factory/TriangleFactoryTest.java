package com.epam.shape.model.factory;

import com.epam.shape.model.entity.Point2D;
import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.factory.impl.TriangleFactoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleFactoryTest {
    private ShapeFactory factory = new TriangleFactoryImpl();
    private List<Point2D> points = new ArrayList<>();

    @DataProvider
    public Object[][] trianglesPointsData() {
        return new Object[][]{
                {points.get(0), points.get(1), points.get(2), Optional.of(new Triangle(points.get(0), points.get(1), points.get(2)))},
                {points.get(0), points.get(2), points.get(4), Optional.of(new Triangle(points.get(0), points.get(2), points.get(4)))},
                {points.get(0), points.get(3), points.get(4), Optional.empty()}
        };
    }

    @BeforeClass
    public void pointsInit() {
        points.add(new Point2D(0, 0));
        points.add(new Point2D(10, 0));
        points.add(new Point2D(0, 10));
        points.add(new Point2D(1, 1));
        points.add(new Point2D(2, 2));
    }

    @Test(dataProvider = "trianglesPointsData")
    public void createInstanceTest(Point2D point1, Point2D point2, Point2D point3, Optional<Triangle> expected) {
        List<Point2D> points = new ArrayList<>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        Optional actual = factory.createShape(points);
        assertEquals(actual, expected);
    }
}
