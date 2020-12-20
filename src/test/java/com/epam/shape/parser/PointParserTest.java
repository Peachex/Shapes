package com.epam.shape.parser;

import com.epam.shape.model.entity.Point2D;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class PointParserTest {
    private List<String> lines;
    private List<Point2D> points;

    @DataProvider
    public Object[][] linesData() {
        return new Object[][]{
                {lines.get(0), points.get(0), points.get(1), points.get(2)},
                {lines.get(1), points.get(3), points.get(4), points.get(5)},
                {lines.get(2), points.get(6), points.get(7), points.get(8)},
                {lines.get(3), points.get(9), points.get(10), points.get(11)},
                {lines.get(4), points.get(12), points.get(13), points.get(14)},
                {lines.get(5), points.get(15), points.get(16), points.get(17)},
                {lines.get(6), points.get(18), points.get(19), points.get(20)},
                {lines.get(7), points.get(21), points.get(22), points.get(23)},
                {lines.get(8), points.get(24), points.get(25), points.get(26)},
        };
    }

    @BeforeClass
    public void setLines() {
        lines = new ArrayList<>();
        lines.add("1.2;1.3;0;10;1;2");
        lines.add("6.2;2.3;3;144;11;22");
        lines.add("110;44.3;-0.24;-10;32;53");
        lines.add("0;0;0;10;10;0");
        lines.add("-10;0;0;10;0;0");
        lines.add("5;0;1;1;10;-2");
        lines.add("-1.2;-1.3;0;-10;-1;-2");
        lines.add("-6.2;2.3;-3;144;11;-22");
        lines.add("0;0;2;2;2;0");
    }

    @BeforeClass
    public void setPoints() {
        points = new ArrayList<>();
        points.add(new Point2D(1.2, 1.3));
        points.add(new Point2D(0, 10));
        points.add(new Point2D(1, 2));
        points.add(new Point2D(6.2, 2.3));
        points.add(new Point2D(3, 144));
        points.add(new Point2D(11, 22));
        points.add(new Point2D(110, 44.3));
        points.add(new Point2D(-0.24, -10));
        points.add(new Point2D(32, 53));
        points.add(new Point2D(0, 0));
        points.add(new Point2D(0, 10));
        points.add(new Point2D(10, 0));
        points.add(new Point2D(-10, 0));
        points.add(new Point2D(0, 10));
        points.add(new Point2D(0, 0));
        points.add(new Point2D(5, 0));
        points.add(new Point2D(1, 1));
        points.add(new Point2D(10, -2));
        points.add(new Point2D(-1.2, -1.3));
        points.add(new Point2D(0, -10));
        points.add(new Point2D(-1, -2));
        points.add(new Point2D(-6.2, 2.3));
        points.add(new Point2D(-3, 144));
        points.add(new Point2D(11, -22));
        points.add(new Point2D(0, 0));
        points.add(new Point2D(2, 2));
        points.add(new Point2D(2, 0));
    }

    @Test(dataProvider = "linesData")
    public void parsePointsTest(String line, Point2D point1, Point2D point2, Point2D point3) {
        List<Point2D> expected = new ArrayList<>();
        expected.add(point1);
        expected.add(point2);
        expected.add(point3);
        PointParser parser = new PointParser();
        List<Point2D> actual = parser.parsePoints(line);
        assertEquals(actual, expected);
    }
}
