package com.epam.shape.model.entity;

import com.epam.shape.util.ShapeIdGenerator;


public abstract class Shape2D {
    private final long shapeId;

    public Shape2D() {
        shapeId = ShapeIdGenerator.getIncreasedId();
    }

    public long getShapeId() {
        return this.shapeId;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o == null || getClass() != o.getClass();
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Shape{");
        sb.append("shapeId=").append(shapeId);
        sb.append('}');
        return sb.toString();
    }
}
