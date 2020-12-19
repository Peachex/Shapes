package com.epam.shape.model.entity;

import java.util.EnumSet;

public class TriangleProperty {
    private double square;
    private double perimeter;
    private EnumSet<TriangleType> types;

    public TriangleProperty(double square, double perimeter, EnumSet<TriangleType> triangleTypes) {
        this.square = square;
        this.perimeter = perimeter;
        this.types = triangleTypes;
    }

    public double getSquare() {
        return this.square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getPerimeter() {
        return this.perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public boolean contains(TriangleType triangleType) {
        return types.contains(triangleType);
    }

    public void addType(TriangleType triangleType) {
        types.add(triangleType);
    }

    public void removeType(TriangleType triangleType) {
        types.remove(triangleType);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TriangleProperty{");
        sb.append("square=").append(square);
        sb.append(", perimeter=").append(perimeter);
        sb.append(", types=").append(types);
        sb.append('}');
        return sb.toString();
    }
}
