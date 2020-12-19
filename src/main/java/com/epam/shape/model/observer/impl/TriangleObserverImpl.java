package com.epam.shape.model.observer.impl;

import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.entity.TriangleProperty;
import com.epam.shape.model.entity.TriangleType;
import com.epam.shape.model.observer.TriangleObserver;
import com.epam.shape.model.observer.TriangleEvent;
import com.epam.shape.model.service.TriangleService;
import com.epam.shape.model.service.impl.TriangleServiceImpl;
import com.epam.shape.model.warehouse.TrianglePropertyWarehouse;

import java.util.EnumSet;

public class TriangleObserverImpl implements TriangleObserver {
    @Override
    public void parameterChanged(TriangleEvent event) {
        Triangle triangle = event.getSource();
        TriangleService service = new TriangleServiceImpl();
        double square = service.findSquare(triangle);
        double perimeter = service.findPerimeter(triangle);
        EnumSet<TriangleType> types = service.findTriangleType(triangle);
        TriangleProperty property = new TriangleProperty(square, perimeter, types);
        TrianglePropertyWarehouse.getWarehouse().put(triangle.getShapeId(), property);
    }
}
