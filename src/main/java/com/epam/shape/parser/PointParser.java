package com.epam.shape.parser;

import com.epam.shape.exception.ReaderException;
import com.epam.shape.model.entity.CustomPoint;
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

    public List<CustomPoint> parsePoints(String line) {
        List<CustomPoint> result = new ArrayList<>();
        if (TriangleValidator.arePointsValid(line)) {
            String[] points = line.split(SPLIT_POINTS_REGEX);
            try {
                int count = 0;
                while (count < POINTS_AMOUNT) {
                    double x = Double.parseDouble(points[count++]);
                    double y = Double.parseDouble(points[count++]);
                    result.add(new CustomPoint(x, y));
                }
            } catch (NumberFormatException e) {
                logger.log(Level.ERROR, e);
            }
        } else {
            logger.log(Level.INFO, "Invalid point");
        }
        return result;
    }
}
