package com.epam.shape.model.factory;

import com.epam.shape.model.entity.CustomPoint;
import com.epam.shape.model.entity.Shape2D;

import java.util.List;
import java.util.Optional;

public interface ShapeFactory<T extends Shape2D> {
    Optional<T> createShape(List<CustomPoint> points);
}
