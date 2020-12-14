package com.epam.shape.model.entity;

public class CustomPoint {
    private double x;
    private double y;

    public CustomPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomPoint point = (CustomPoint) o;
        return (Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Double.hashCode(this.x);
        result = 31 * result + Double.hashCode(this.y);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("x = ").append(x);
        sb.append(", y = ").append(y);
        return sb.toString();
    }
}
