package com.epam.shape.model.service.impl;

import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.entity.TriangleProperty;
import com.epam.shape.model.entity.TriangleType;
import com.epam.shape.model.service.TrianglePropertyService;
import com.epam.shape.model.service.TriangleService;

import java.util.EnumSet;

public class TrianglePropertyServiceImpl implements TrianglePropertyService {
    @Override
    public TriangleProperty calculateTriangleProperties(Triangle triangle) {
        TriangleService service = new TriangleServiceImpl();
        double square = service.findSquare(triangle);
        double perimeter = service.findPerimeter(triangle);
        EnumSet<TriangleType> types = service.findTriangleType(triangle);
        TriangleProperty property = new TriangleProperty(square, perimeter, types);
        return property;
    }
}
