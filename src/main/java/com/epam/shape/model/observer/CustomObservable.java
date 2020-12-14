package com.epam.shape.model.observer;

public interface CustomObservable {
    void attach(CustomObserver observer);
    void detach(CustomObserver observer);
    void notifyObservers();
}
