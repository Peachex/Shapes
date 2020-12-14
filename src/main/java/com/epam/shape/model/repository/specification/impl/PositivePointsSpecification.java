package com.epam.shape.model.repository.specification.impl;

import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.repository.specification.Specification;

public class PositivePointsSpecification implements Specification {

    @Override
    public boolean specify(Triangle triangle) {
        boolean result = false;
        if (triangle.getPoint1().getX() > 0 && triangle.getPoint1().getY() > 0 && triangle.getPoint2().getX() > 0 &&
                triangle.getPoint2().getY() > 0 && triangle.getPoint3().getX() > 0 && triangle.getPoint3().getY() > 0) {
            result = true;
        }
        return result;
    }
}
