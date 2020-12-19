package com.epam.shape.main;

import com.epam.shape.exception.ReaderException;
import com.epam.shape.model.entity.CustomPoint;
import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.factory.ShapeFactory;
import com.epam.shape.model.factory.impl.TriangleFactoryImpl;

import com.epam.shape.parser.PointParser;
import com.epam.shape.reader.TriangleReader;

import java.util.List;

public class Main {
    public static void main(String[] args) throws ReaderException {
        String path = "data\\triangles.txt";
        TriangleReader reader = new TriangleReader();
        List<String> lines;
        lines = reader.readDataFromFile(path);

        PointParser parser = new PointParser();
        List<CustomPoint> points = parser.parsePoints(lines.get(0));

        System.out.println(lines);
        System.out.println(points);

        ShapeFactory<Triangle> factory = new TriangleFactoryImpl();
        Triangle triangle = factory.createShape(points).get();
        System.out.println(triangle);

    }
}
