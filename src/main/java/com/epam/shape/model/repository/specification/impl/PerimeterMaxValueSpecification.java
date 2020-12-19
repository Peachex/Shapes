package com.epam.shape.model.repository.specification.impl;

import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.repository.specification.Specification;
import com.epam.shape.model.warehouse.TrianglePropertyWarehouse;

public class PerimeterMaxValueSpecification implements Specification {
    private double maxValue;

    public PerimeterMaxValueSpecification(double maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public boolean specify(Triangle triangle) {
        boolean result = false;
        double perimeter = TrianglePropertyWarehouse.getWarehouse().get(triangle.getShapeId()).getPerimeter();
        return (perimeter > maxValue);
    }
}
