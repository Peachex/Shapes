package com.epam.shape.model.repository.specification.impl;

import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.repository.specification.Specification;

public class IdSpecification implements Specification {
    long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Triangle triangle) {
        return (triangle.getShapeId() == id);
    }
}
