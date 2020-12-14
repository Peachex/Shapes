package com.epam.shape.model.factory;

import com.epam.shape.model.entity.CustomPoint;
import com.epam.shape.model.entity.Shape2D;

import java.util.Optional;

public abstract class ShapeFactory<T extends Shape2D> {
    public abstract Optional<T> createInstance(CustomPoint... points);
}
