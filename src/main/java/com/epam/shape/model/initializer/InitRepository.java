package com.epam.shape.model.initializer;

import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.factory.ShapeFactory;
import com.epam.shape.model.factory.impl.TriangleFactoryImpl;
import com.epam.shape.model.repository.TriangleRepository;
import com.epam.shape.parser.PointParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InitRepository {
    public void initializeTriangleRepository(List<String> lines) {
        PointParser parser = new PointParser();
        ShapeFactory<Triangle> factory = new TriangleFactoryImpl();
        List<Triangle> triangles = new ArrayList<>();
        for (String line : lines) {
            Optional<Triangle> triangle = factory.createShape(parser.parsePoints(line));
            triangle.ifPresent(triangles::add);
        }
        TriangleRepository.getRepository().addAll(triangles);
    }
}
