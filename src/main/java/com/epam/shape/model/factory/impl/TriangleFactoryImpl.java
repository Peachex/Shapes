package com.epam.shape.model.factory.impl;

import com.epam.shape.model.entity.CustomPoint;
import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.factory.ShapeFactory;
import com.epam.shape.validator.TriangleValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class TriangleFactoryImpl implements ShapeFactory<Triangle> {
    private final static Logger logger = LogManager.getLogger();
    private final static int POINT1_INDEX = 0;
    private final static int POINT2_INDEX = 1;
    private final static int POINT3_INDEX = 2;

    @Override
    public Optional<Triangle> createShape(List<CustomPoint> points) {
        if (points.size() != 3) {
            logger.log(Level.INFO, "There are less or more than three points.");
            return Optional.empty();
        }
        CustomPoint point1 = points.get(POINT1_INDEX);// new CustomPoint(points[POINT1_INDEX].getX(), points[POINT1_INDEX].getY());
        CustomPoint point2 = points.get(POINT2_INDEX);// new CustomPoint(points[POINT2_INDEX].getX(), points[POINT2_INDEX].getY());
        CustomPoint point3 = points.get(POINT3_INDEX);// new CustomPoint(points[POINT3_INDEX].getX(), points[POINT3_INDEX].getY());
        Optional<Triangle> triangle = Optional.of(new Triangle(point1, point2, point3));
        if (!TriangleValidator.isTriangleExist(point1, point2, point3)) {
            triangle = Optional.empty();
            logger.log(Level.INFO, "Triangle doesn't exist, it will be not added to the list.");
        }
        return triangle;
    }
}
