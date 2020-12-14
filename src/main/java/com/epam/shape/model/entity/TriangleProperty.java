package com.epam.shape.model.entity;

import java.util.List;

public class TriangleProperty {
    private double square;
    private double perimeter;
    private List<TriangleType> types;

    public TriangleProperty(double square, double perimeter, List<TriangleType> triangleTypes) {
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

    public TriangleType getType(int index) {
        return types.get(index);
    }

    public void addType(TriangleType triangleType) {
        types.add(triangleType);
    }

    public void setType(int index, TriangleType triangleType) {
        types.set(index, triangleType);
    }

    public int findPropertiesAmount() {
        return types.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return false;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TriangleProperty that = (TriangleProperty) o;
        return this.square == that.square && this.perimeter == that.perimeter && this.types.equals(that.types);
    }

    @Override
    public int hashCode() {
        int result = 31 + Double.hashCode(this.square);
        result = 31 * result + Double.hashCode(this.perimeter) + this.types.hashCode();
        return result;
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
