package com.epam.shape.model.service;

import com.epam.shape.model.entity.CustomPoint;
import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.entity.TriangleType;

import java.util.List;

public interface TriangleService {

    double findSquare(Triangle triangle);

    double findPerimeter(Triangle triangle);

    List<TriangleType> findTriangleType(Triangle triangle);

    double findDistanceBetweenPoints(CustomPoint point1, CustomPoint point2);
}
