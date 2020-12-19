/*
package com.epam.shape.model.filler;

import com.epam.shape.exception.ReaderException;
import com.epam.shape.model.entity.CustomPoint;
import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.entity.TriangleProperty;
import com.epam.shape.model.factory.ShapeFactory;
import com.epam.shape.model.factory.impl.TriangleFactoryImpl;
import com.epam.shape.model.repository.TriangleRepository;
import com.epam.shape.model.service.TrianglePropertyService;
import com.epam.shape.model.service.impl.TrianglePropertyServiceImpl;
import com.epam.shape.model.warehouse.TrianglePropertyWarehouse;
import com.epam.shape.parser.PointParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TriangleRepositoryFiller {
    private String path;

    public TriangleRepositoryFiller(String path) {
        this.path = path;
    }

    public void fillTriangleRepository() throws ReaderException {
        PointParser parser = new PointParser();
        ShapeFactory<Triangle> factory = new TriangleFactoryImpl();
        List<CustomPoint> points = parser.parsePoints(path);
        List<Triangle> triangles = new ArrayList<>();
        int count = 0;
        while (count < points.size()) {
            Optional<Triangle> triangle = factory.createInstance(points.get(count++), points.get(count++), points.get(count++));
            if (triangle.isPresent()) {
                triangles.add(triangle.get());
            }
        }
        TriangleRepository repository = TriangleRepository.getRepository();
        repository.addAll(triangles);
        TrianglePropertyService service = new TrianglePropertyServiceImpl();
        count = 0;
        while (count < repository.findSize()) {
            TriangleProperty property = service.calculateTriangleProperties(repository.getTriangle(count));
            TrianglePropertyWarehouse.getWarehouse().putProperty(repository.getTriangle(count++).getShapeId(), property);
        }
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
*/
