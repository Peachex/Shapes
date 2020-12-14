package com.epam.shape.model.repository.specification.impl;

import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.repository.specification.Specification;
import com.epam.shape.model.warehouse.TrianglePropertyWarehouse;

public class SquareIntervalSpecification implements Specification {
    private double minValue;
    private double maxValue;

    public SquareIntervalSpecification(double minValue, double maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public boolean specify(Triangle triangle) {
        double square = TrianglePropertyWarehouse.getWarehouse().getProperty(triangle.getShapeId()).getSquare();
        return (square >= minValue && square <= maxValue);
    }
}
