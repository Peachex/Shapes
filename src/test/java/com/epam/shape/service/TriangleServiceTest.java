package com.epam.shape.service;

import com.epam.shape.model.entity.Point2D;
import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.entity.TriangleType;
import com.epam.shape.model.service.TriangleService;
import com.epam.shape.model.service.impl.TriangleServiceImpl;

import java.util.EnumSet;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleServiceTest {
    private TriangleService service = new TriangleServiceImpl();
    private Triangle triangle;

    @BeforeMethod
    public void triangleInit() {
        triangle = new Triangle(new Point2D(0, 0), new Point2D(0, 10), new Point2D(10, 0));
    }

    @Test
    public void findSquare() {
        double expected = 50;
        double actual = service.findSquare(triangle);
        assertEquals(actual, expected);
    }

    @Test
    public void findPerimeter() {
        double expected = 20 + Math.sqrt(200);
        double actual = service.findPerimeter(triangle);
        assertEquals(actual, expected);
    }

    @Test
    public void findTriangleType() {
        EnumSet<TriangleType> expected = EnumSet.noneOf(TriangleType.class);
        expected.add(TriangleType.RECTANGULAR);
        expected.add(TriangleType.ISOSCELES);
        EnumSet<TriangleType> actual = service.findTriangleType(triangle);
        assertEquals(actual, expected);
    }

    @Test
    public void findDistanceBetweenPoints() {
        double expected = Math.sqrt(8);
        double actual = service.findDistanceBetweenPoints(new Point2D(1, 2), new Point2D(3, 4));
        assertEquals(actual, expected);
    }
}
