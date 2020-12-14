package com.epam.shape.model.service;

import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.entity.TriangleProperty;

public interface TrianglePropertyService {
    TriangleProperty calculateTriangleProperties(Triangle triangle);
}
