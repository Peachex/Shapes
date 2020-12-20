package com.epam.shape.model.entity.comparator;

import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.entity.TriangleProperty;
import com.epam.shape.model.warehouse.TrianglePropertyWarehouse;

import java.util.Comparator;

public enum TriangleComparator implements Comparator<Triangle> {
    FIRST_POINT_X_COORDINATE {
        @Override
        public int compare(Triangle triangle1, Triangle triangle2) {
            return Double.compare(triangle1.getPoint1().getX(), triangle2.getPoint1().getX());
        }
    },
    SECOND_POINT_Y_COORDINATE {
        @Override
        public int compare(Triangle triangle1, Triangle triangle2) {
            return Double.compare(triangle1.getPoint2().getY(), triangle2.getPoint2().getY());
        }
    },

    SQUARE {
        @Override
        public int compare(Triangle triangle1, Triangle triangle2) {
            return Double.compare(findProperty(triangle1).getSquare(), findProperty(triangle2).getSquare());
        }
    },

    PERIMETER {
        @Override
        public int compare(Triangle triangle1, Triangle triangle2) {
            return Double.compare(findProperty(triangle1).getPerimeter(), findProperty(triangle2).getPerimeter());
        }
    };

    public TriangleProperty findProperty(Triangle triangle) {
        TriangleProperty property = TrianglePropertyWarehouse.getWarehouse().get(triangle.getShapeId());
        return property;
    }
}
