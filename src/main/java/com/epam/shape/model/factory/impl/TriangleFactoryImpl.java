package com.epam.shape.model.factory.impl;

import com.epam.shape.model.entity.Point2D;
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
    public Optional<Triangle> createShape(List<Point2D> points) {
        if (points.size() != 3) {
            logger.log(Level.ERROR, "There are less or more than three points " + points + ".");
            return Optional.empty();
        }
        Point2D point1 = points.get(POINT1_INDEX);
        Point2D point2 = points.get(POINT2_INDEX);
        Point2D point3 = points.get(POINT3_INDEX);
        Optional<Triangle> triangle = Optional.of(new Triangle(point1, point2, point3));
        if (!TriangleValidator.isTriangleExist(point1, point2, point3)) {
            triangle = Optional.empty();
            logger.log(Level.ERROR, "Triangle doesn't exist, it will be not added to the list " + points + ".");
        }
        return triangle;
    }
}
