package com.epam.shape.factory;

import com.epam.shape.model.entity.CustomPoint;
import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.factory.ShapeFactory;
import com.epam.shape.model.factory.impl.TriangleFactoryImpl;

import java.util.Optional;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleFactoryTest {
    private ShapeFactory factory = new TriangleFactoryImpl();

    @Test
    public void createInstanceTest() {
        CustomPoint point1 = new CustomPoint(0, 0);
        CustomPoint point2 = new CustomPoint(10, 0);
        CustomPoint point3 = new CustomPoint(0, 10);
        Optional<Triangle> expected = Optional.of(new Triangle(point1, point2, point3));
        Optional<Triangle> actual = factory.createInstance(point1, point2, point3);
        assertEquals(actual, expected);
    }
}
