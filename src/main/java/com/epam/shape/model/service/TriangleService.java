package com.epam.shape.model.service;

import com.epam.shape.model.entity.Point2D;
import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.entity.TriangleType;

import java.util.EnumSet;

public interface TriangleService {

    double findSquare(Triangle triangle);

    double findPerimeter(Triangle triangle);

    EnumSet<TriangleType> findTriangleType(Triangle triangle);

    double findDistanceBetweenPoints(Point2D point1, Point2D point2);
}
