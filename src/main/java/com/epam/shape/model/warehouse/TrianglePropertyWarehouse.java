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

    public int findSize() {
        return trianglesProperty.size();
    }

    public TriangleProperty getProperty(Long id) {
        return trianglesProperty.get(id);
    }

    public void putProperty(Long id, TriangleProperty property) {
        trianglesProperty.put(id, property);
    }

    public void removeProperty(Long id) {
        trianglesProperty.remove(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TrianglePropertyWarehouse warehouse = (TrianglePropertyWarehouse) o;
        return trianglesProperty.equals(warehouse.trianglesProperty);
    }

    @Override
    public int hashCode() {
        int result = 31 + trianglesProperty.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Warehouse{");
        sb.append("trianglesProperty=").append(trianglesProperty);
        sb.append('}');
        return sb.toString();
    }
}
