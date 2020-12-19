package com.epam.shape.model.entity.comparator;

import com.epam.shape.model.entity.TriangleProperty;

import java.util.Comparator;

public enum TrianglePropertyComparator implements Comparator<TriangleProperty> {
    SQUARE {
        @Override
        public int compare(TriangleProperty property1, TriangleProperty property2) {
            return Double.compare(property1.getSquare(), property2.getSquare());
        }
    },
    PERIMETER {
        @Override
        public int compare(TriangleProperty property1, TriangleProperty property2) {
            return Double.compare(property1.getPerimeter(), property2.getPerimeter());
        }
    }
}
