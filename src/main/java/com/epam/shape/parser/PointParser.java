package com.epam.shape.parser;

import com.epam.shape.model.entity.CustomPoint;
import com.epam.shape.model.reader.TriangleReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.shape.validator.TriangleValidator.isPointValid;

import java.util.ArrayList;
import java.util.List;

public class PointParser {
    private final static Logger logger = LogManager.getLogger();
    private final static String SPLIT_POINTS_REGEX = ";";
    private final static int VALUES_AMOUNT = 6;

    public List<CustomPoint> parsePoints(String path) {
        TriangleReader reader = new TriangleReader();
        List<String> lines = reader.readDataFromFile(path);
        List<CustomPoint> result = new ArrayList<>();
        for (String line : lines) {
            String[] points = line.split(SPLIT_POINTS_REGEX);
            if (points.length == VALUES_AMOUNT) {
                boolean validCondition = true;
                for (String str : points) {
                    if (!isPointValid(str)) {
                        validCondition = false;
                    }
                }
                if (validCondition) {
                    try {
                        int count = 0;
                        while (count < points.length) {
                            double x = Double.parseDouble(points[count++]);
                            double y = Double.parseDouble(points[count++]);
                            result.add(new CustomPoint(x, y));
                        }
                    } catch (NumberFormatException e) {
                        logger.log(Level.ERROR, e);
                    }
                }
            } else {
                logger.log(Level.INFO, "Invalid point");
            }
        }
        return result;
    }
}
