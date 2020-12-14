package com.epam.shape.util;

public class ShapeIdGenerator {
    private static long id = 0;

    public static long getIncreasedId() {
        return id++;
    }
}
