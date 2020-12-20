package com.epam.shape.validator;

import com.epam.shape.model.entity.Point2D;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TriangleValidatorTest {
    private List<Point2D> points;
    private List<String> lines;

    @DataProvider
    public Object[][] pointsValidData() {
        return new Object[][]{
                {lines.get(0), true},
                {lines.get(1), true},
                {lines.get(2), true},
                {lines.get(3), true},
                {lines.get(4), true},
                {lines.get(5), false},
                {lines.get(6), false},
                {lines.get(7), true},
                {lines.get(8), true},
                {lines.get(9), true},
                {lines.get(10), true},
                {lines.get(11), true},
                {lines.get(12), true},
        };
    }

    @DataProvider
    public Object[][] trianglesExistData() {
        return new Object[][]{
                {points.get(0), points.get(1), points.get(2), false},
                {points.get(1), points.get(2), points.get(3), true},
                {points.get(2), points.get(3), points.get(4), true},
                {points.get(4), points.get(2), points.get(1), true},
                {points.get(3), points.get(1), points.get(4), true},
        };
    }

    @BeforeClass
    public void setPoints() {
        points = new ArrayList<>();
        points.add(new Point2D(0, 0));
        points.add(new Point2D(1, 1));
        points.add(new Point2D(2, 2));
        points.add(new Point2D(1, 3));
        points.add(new Point2D(10, 2));
    }

    @BeforeClass
    public void setLines() {
        lines = new ArrayList<>();
        lines.add("1.2;1.3;0;10;1;2");
        lines.add("6.2;2.3;3;144;11;22");
        lines.add("6.2;2.3;3;144;11;22");
        lines.add("110;44.3;-0.24;-10;32;53");
        lines.add("0;0;0;10;10;0");
        lines.add("1da;2;3;4;5;6");
        lines.add("1;2;3;4;5");
        lines.add("-10;0;0;10;0;0");
        lines.add("25;25;15;15;10;10");
        lines.add("5;0;1;1;10;-2");
        lines.add("-1.23;-1.;0;-10;-1;-2");
        lines.add("-6.2;2.3;-3;144;11;-22");
        lines.add("0;0;2;2;2;0");
    }

    @Test(dataProvider = "pointsValidData")
    public void arePointsValidTest(String points, boolean expected) {
        boolean actual = TriangleValidator.arePointsValid(points);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "trianglesExistData")
    public void isTriangleExistTest(Point2D point1, Point2D point2, Point2D point3, boolean expected) {
        boolean actual = TriangleValidator.isTriangleExist(point1, point2, point3);
        assertEquals(actual, expected);
    }
}
