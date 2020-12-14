package com.epam.shape.model.repository;

import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.entity.TriangleProperty;
import com.epam.shape.model.service.TrianglePropertyService;
import com.epam.shape.model.service.impl.TrianglePropertyServiceImpl;
import com.epam.shape.model.repository.specification.Specification;
import com.epam.shape.model.warehouse.TrianglePropertyWarehouse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepository {
    private final static TriangleRepository repository = new TriangleRepository();
    private List<Triangle> triangles;

    private TriangleRepository() {
        triangles = new ArrayList<>();
    }

    public static TriangleRepository getRepository() {
        return repository;
    }

    public int findSize() {
        return this.triangles.size();
    }

    public void add(Triangle triangle) {
        this.triangles.add(triangle);
        TrianglePropertyService service = new TrianglePropertyServiceImpl();
        TriangleProperty property = service.calculateTriangleProperties(triangle);
        TrianglePropertyWarehouse.getWarehouse().putProperty(triangle.getShapeId(), property);
    }

    public void addAll(List<Triangle> triangles) {
        this.triangles.addAll(triangles);
        for (Triangle triangle : triangles) {
            TrianglePropertyService service = new TrianglePropertyServiceImpl();
            TriangleProperty property = service.calculateTriangleProperties(triangle);
            TrianglePropertyWarehouse.getWarehouse().putProperty(triangle.getShapeId(), property);
        }
    }

    public Triangle getTriangle(int index) {
        return this.triangles.get(index);
    }

    public void remove(Triangle triangle) {
        TrianglePropertyWarehouse.getWarehouse().removeProperty(triangle.getShapeId());
        this.triangles.remove(triangle);
    }

    public void removeAll(List<Triangle> triangles) {
        for (Triangle triangle : triangles) {
            TrianglePropertyWarehouse.getWarehouse().removeProperty(triangle.getShapeId());
        }
        this.triangles.removeAll(triangles);
    }

    public List<Triangle> query(Specification specification) {
        List<Triangle> result = triangles.stream().filter(triangle -> specification.specify(triangle)).collect(Collectors.toList());
        return result;
    }

    public List<Triangle> sort(Comparator<Triangle> comparator) {
        List<Triangle> sortedTriangles = new ArrayList<>(triangles);
        sortedTriangles.sort(comparator);
        return sortedTriangles;
    }
}
