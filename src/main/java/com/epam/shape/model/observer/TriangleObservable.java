package com.epam.shape.model.observer;

public interface TriangleObservable {
    void attach(TriangleObserver observer);
    void detach(TriangleObserver observer);
    void notifyObservers();
}
