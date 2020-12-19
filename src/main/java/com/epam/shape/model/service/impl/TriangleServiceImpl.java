package com.epam.shape.model.service.impl;

import com.epam.shape.model.entity.Point2D;
import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.entity.TriangleType;
import com.epam.shape.model.service.TriangleService;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class TriangleServiceImpl implements TriangleService {
    private static final int SIDE1_INDEX = 0;
    private static final int SIDE2_INDEX = 1;
    private static final int SIDE3_INDEX = 2;

    @Override
    public double findSquare(Triangle triangle) {
        double semiPerimeter = findPerimeter(triangle) / 2;
        List<Double> sides = findSides(triangle);
        double result = Math.sqrt(semiPerimeter * (semiPerimeter - sides.get(SIDE1_INDEX)) * (semiPerimeter - sides.get(SIDE2_INDEX)) *
                (semiPerimeter - sides.get(SIDE3_INDEX)));
        return result;
    }

    @Override
    public double findPerimeter(Triangle triangle) {
        List<Double> sides = findSides(triangle);
        double result = 0;
        for (Double side : sides) {
            result += side;
        }
        return result;
    }

    @Override
    public EnumSet<TriangleType> findTriangleType(Triangle triangle) {
        List<Double> sides = findSides(triangle);
        double sideWithMinLength1 = Double.min(sides.get(SIDE1_INDEX), sides.get(SIDE2_INDEX));
        double sideWithMinLength2 = Double.max(sides.get(SIDE1_INDEX), sides.get(SIDE2_INDEX));
        sideWithMinLength2 = Double.min(sideWithMinLength2, sides.get(SIDE3_INDEX));
        double sideWithMaxLength = findSideWithMaxLength(sides);

        EnumSet<TriangleType> result = EnumSet.noneOf(TriangleType.class);

        if (Math.hypot(sideWithMinLength1, sideWithMinLength2) == sideWithMaxLength) {
            result.add(TriangleType.RECTANGULAR);
        } else {
            if (Math.hypot(sideWithMinLength1, sideWithMinLength2) > sideWithMaxLength) {
                result.add(TriangleType.ACUTE);
            } else {
                result.add(TriangleType.OBTUSE);
            }
        }
        if (sideWithMinLength1 == sideWithMinLength2 && sideWithMinLength2 == sideWithMaxLength &&
                sideWithMinLength1 == sideWithMaxLength) {
            result.add(TriangleType.EQUILATERAL);
        } else {
            if (sideWithMinLength1 == sideWithMinLength2 || sideWithMinLength2 == sideWithMaxLength ||
                    sideWithMinLength1 == sideWithMaxLength) {
                result.add(TriangleType.ISOSCELES);
            }
        }
        return result;
    }

    @Override
    public double findDistanceBetweenPoints(Point2D point1, Point2D point2) {
        double result = Math.hypot(point2.getX() - point1.getX(), point2.getY() - point1.getY());
        return result;
    }

    private double findSideWithMaxLength(List<Double> sides) {
        double result = Double.max(sides.get(SIDE1_INDEX), sides.get(SIDE2_INDEX));
        result = Double.max(result, sides.get(SIDE3_INDEX));
        return result;
    }

    private List<Double> findSides(Triangle triangle) {
        List<Double> sides = new ArrayList<>();
        double side1 = findDistanceBetweenPoints(triangle.getPoint1(), triangle.getPoint2());
        double side2 = findDistanceBetweenPoints(triangle.getPoint2(), triangle.getPoint3());
        double side3 = findDistanceBetweenPoints(triangle.getPoint1(), triangle.getPoint3());
        sides.add(side1);
        sides.add(side2);
        sides.add(side3);
        return sides;
    }
}
