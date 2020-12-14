package com.epam.shape.model.observer;

import com.epam.shape.model.entity.Triangle;

import java.util.EventObject;

public class TriangleEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public TriangleEvent(Triangle source) {
        super(source);
    }

    @Override
    public Triangle getSource() {
        return (Triangle) super.getSource();
    }
}
