package com.epam.shape.factory;

import com.epam.shape.model.entity.Point2D;
import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.factory.ShapeFactory;
import com.epam.shape.model.factory.impl.TriangleFactoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleFactoryTest {
    private ShapeFactory factory = new TriangleFactoryImpl();
    private List<Point2D> points = new ArrayList<>();

    @BeforeTest
    public void pointsInit() {
        points.add(new Point2D(0, 0));
        points.add(new Point2D(10, 0));
        points.add(new Point2D(0, 10));
    }

    @Test
    public void createInstanceTest() {
        Optional<Triangle> expected = Optional.of(new Triangle(points.get(0), points.get(1), points.get(2)));
        Optional actual = factory.createShape(points);
        assertEquals(actual, expected);
    }
}
