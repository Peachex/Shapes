package com.epam.shape.model.repository.specification.impl;

import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.entity.TriangleProperty;
import com.epam.shape.model.entity.TriangleType;
import com.epam.shape.model.repository.specification.Specification;
import com.epam.shape.model.warehouse.TrianglePropertyWarehouse;

public class TypeSpecification implements Specification {
    private TriangleType type;

    public TypeSpecification(TriangleType triangleType) {
        this.type = triangleType;
    }

    @Override
    public boolean specify(Triangle triangle) {
        TriangleProperty property = TrianglePropertyWarehouse.getWarehouse().get(triangle.getShapeId());
        return (property.contains(type));
    }
}
