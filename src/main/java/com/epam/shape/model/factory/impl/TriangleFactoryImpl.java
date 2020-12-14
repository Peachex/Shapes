package com.epam.shape.model.factory.impl;

import com.epam.shape.model.entity.CustomPoint;
import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.factory.ShapeFactory;
import com.epam.shape.validator.TriangleValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class TriangleFactoryImpl extends ShapeFactory<Triangle> {
    private final static Logger logger = LogManager.getLogger();
    private final static int POINT1_INDEX = 0;
    private final static int POINT2_INDEX = 1;
    private final static int POINT3_INDEX = 2;
    private final static String TRIANGLE_EXIST_ERROR = "Triangle doesn't exist, it will be not added to the list.";
    private final static String POINTS_AMOUNT_ERROR = "There are less or more than three points.";

    @Override
    public Optional<Triangle> createInstance(CustomPoint... points) {
        if (points.length != 3) {
            logger.log(Level.INFO, POINTS_AMOUNT_ERROR);
            return Optional.empty();
        }
        CustomPoint point1 = new CustomPoint(points[POINT1_INDEX].getX(), points[POINT1_INDEX].getY());
        CustomPoint point2 = new CustomPoint(points[POINT2_INDEX].getX(), points[POINT2_INDEX].getY());
        CustomPoint point3 = new CustomPoint(points[POINT3_INDEX].getX(), points[POINT3_INDEX].getY());
        Optional<Triangle> triangle = Optional.of(new Triangle(point1, point2, point3));
        if (!TriangleValidator.isTriangleExist(point1, point2, point3)) {
            triangle = Optional.empty();
            logger.log(Level.INFO, TRIANGLE_EXIST_ERROR);
        }
        return triangle;
    }
}
