package com.epam.shape.model.warehouse;

import com.epam.shape.model.entity.TriangleProperty;

import java.util.HashMap;
import java.util.Map;

public class TrianglePropertyWarehouse {
    private final static TrianglePropertyWarehouse warehouse = new TrianglePropertyWarehouse();

    private Map<Long, TriangleProperty> trianglesProperties;

    private TrianglePropertyWarehouse() {
        trianglesProperties = new HashMap<>();
    }

    public static TrianglePropertyWarehouse getWarehouse() {
        return warehouse;
    }

    public int size() {
        return trianglesProperties.size();
    }

    public TriangleProperty get(Long id) {
        return trianglesProperties.get(id);
    }

    public void put(Long id, TriangleProperty property) {
        trianglesProperties.put(id, property);
    }

    public void remove(Long id) {
        trianglesProperties.remove(id);
    }


    public void clearWarehouse() {
        this.trianglesProperties = new HashMap<>();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Warehouse{");
        sb.append("trianglesProperty=").append(trianglesProperties);
        sb.append('}');
        return sb.toString();
    }
}
