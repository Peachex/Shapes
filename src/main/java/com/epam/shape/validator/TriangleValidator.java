package com.epam.shape.validator;

import com.epam.shape.model.entity.CustomPoint;
import com.epam.shape.model.service.TriangleService;
import com.epam.shape.model.service.impl.TriangleServiceImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TriangleValidator {
    private final static String pointsFormat = "(-?\\d{1,5}(\\.\\d{0,5})?;?){6}";

    public static boolean arePointsValid(String points) {
        Pattern pointRegex = Pattern.compile(pointsFormat);
        Matcher matcher = pointRegex.matcher(points);
        boolean result = matcher.matches();
        return result;
    }

    public static boolean isTriangleExist(CustomPoint point1, CustomPoint point2, CustomPoint point3) {
        TriangleService service = new TriangleServiceImpl();
        double side1 = service.findDistanceBetweenPoints(point1, point2);
        double side2 = service.findDistanceBetweenPoints(point2, point3);
        double side3 = service.findDistanceBetweenPoints(point1, point3);
        boolean result = false;
        if (side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2) {
            result = true;
        }
        return result;
    }
}
