package com.epam.shape.model.warehouse;

import com.epam.shape.model.entity.TriangleProperty;

import java.util.HashMap;
import java.util.Map;

public class TrianglePropertyWarehouse {
    private final static TrianglePropertyWarehouse warehouse = new TrianglePropertyWarehouse();

    private Map<Long, TriangleProperty> trianglesProperty;

    private TrianglePropertyWarehouse() {
        trianglesProperty = new HashMap<>();
    }

    public static TrianglePropertyWarehouse getWarehouse() {
        return warehouse;
    }

    public int size() {
        return trianglesProperty.size();
    }

    public TriangleProperty get(Long id) {
        return trianglesProperty.get(id);
    }

    public void put(Long id, TriangleProperty property) {
        trianglesProperty.put(id, property);
    }

    public void remove(Long id) {
        trianglesProperty.remove(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Warehouse{");
        sb.append("trianglesProperty=").append(trianglesProperty);
        sb.append('}');
        return sb.toString();
    }
}
