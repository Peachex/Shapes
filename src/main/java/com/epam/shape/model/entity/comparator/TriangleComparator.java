package com.epam.shape.model.entity.comparator;

import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.warehouse.TrianglePropertyWarehouse;

import java.util.Comparator;

public enum TriangleComparator implements Comparator<Triangle> {
    SQUARE {
        @Override
        public int compare(Triangle triangle1, Triangle triangle2) {
            return Double.compare(TrianglePropertyWarehouse.getWarehouse().getProperty(triangle1.getShapeId()).getSquare(),
                    TrianglePropertyWarehouse.getWarehouse().getProperty(triangle2.getShapeId()).getSquare());
        }
    },
    PERIMETER {
        @Override
        public int compare(Triangle triangle1, Triangle triangle2) {
            return Double.compare(TrianglePropertyWarehouse.getWarehouse().getProperty(triangle1.getShapeId()).getPerimeter(),
                    TrianglePropertyWarehouse.getWarehouse().getProperty(triangle2.getShapeId()).getPerimeter());
        }
    },
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
    }
}
