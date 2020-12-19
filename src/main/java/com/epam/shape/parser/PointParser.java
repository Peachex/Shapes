package com.epam.shape.parser;

import com.epam.shape.model.entity.Point2D;
import com.epam.shape.validator.TriangleValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PointParser {
    private final static Logger logger = LogManager.getLogger();
    private final static String SPLIT_POINTS_REGEX = ";";
    private final static int POINTS_AMOUNT = 6;

    public List<Point2D> parsePoints(String line) {
        List<Point2D> result = new ArrayList<>();
        if (TriangleValidator.arePointsValid(line)) {
            String[] points = line.split(SPLIT_POINTS_REGEX);
            try {
                int count = 0;
                while (count < POINTS_AMOUNT) {
                    double x = Double.parseDouble(points[count++]);
                    double y = Double.parseDouble(points[count++]);
                    result.add(new Point2D(x, y));
                }
            } catch (NumberFormatException e) {
                logger.log(Level.ERROR, e);
            }
        } else {
            logger.log(Level.ERROR, "Invalid point");
        }
        return result;
    }
}
