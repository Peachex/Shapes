package com.epam.shape.model.entity;

import com.epam.shape.model.observer.TriangleObservable;
import com.epam.shape.model.observer.TriangleObserver;
import com.epam.shape.model.observer.TriangleEvent;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Shape2D implements TriangleObservable {
    private CustomPoint point1;
    private CustomPoint point2;
    private CustomPoint point3;
    private List<TriangleObserver> observers;

    public Triangle(CustomPoint point1, CustomPoint point2, CustomPoint point3) {
        super();
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        observers = new ArrayList<>();
    }

    public CustomPoint getPoint1() {
        return this.point1;
    }

    public void setPoint1(CustomPoint point1) {
        this.point1 = point1;
        notifyObservers();
    }

    public CustomPoint getPoint2() {
        return this.point2;
    }

    public void setPoint2(CustomPoint point2) {
        this.point2 = point2;
        notifyObservers();
    }

    public CustomPoint getPoint3() {
        return this.point3;
    }

    public void setPoint3(CustomPoint point3) {
        this.point3 = point3;
        notifyObservers();
    }

    @Override
    public void attach(TriangleObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(TriangleObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        TriangleEvent event = new TriangleEvent(this);
        for (TriangleObserver observer : observers) {
            observer.parameterChanged(event);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != this.getClass()) {
            return false;
        }
        Triangle that = (Triangle) o;
        return (that.point1.getX() == this.point1.getX() && that.point1.getY() == this.point1.getY() &&
                that.point2.getX() == this.point2.getX() && that.point2.getY() == this.point2.getY() &&
                that.point3.getX() == this.point3.getX() && that.point3.getY() == this.point3.getY());

    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (this.point1 != null ? point1.hashCode() : 0);
        result = 31 * result + (this.point2 != null ? point2.hashCode() : 0);
        result = 31 * result + (this.point3 != null ? point3.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\nid = ").append(getShapeId());
        sb.append("\npoint1: ").append(point1);
        sb.append("\npoint2: ").append(point2);
        sb.append("\npoint3: ").append(point3);
        return sb.toString();
    }
}
