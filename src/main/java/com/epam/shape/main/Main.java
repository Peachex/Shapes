package com.epam.shape.main;

import com.epam.shape.model.entity.CustomPoint;
import com.epam.shape.model.factory.ShapeFactory;
import com.epam.shape.model.factory.impl.TriangleFactoryImpl;
import com.epam.shape.model.filler.TriangleRepositoryFiller;
import com.epam.shape.model.repository.TriangleRepository;
import com.epam.shape.model.warehouse.TrianglePropertyWarehouse;

public class Main {
    public static void main(String[] args) {
        String path = "data\\triangles.txt";
        TriangleRepositoryFiller filler = new TriangleRepositoryFiller(path);
        filler.fillTriangleRepository();
        TriangleRepository repository = TriangleRepository.getRepository();
        TrianglePropertyWarehouse warehouse = TrianglePropertyWarehouse.getWarehouse();
        int count = 0;
        while (count < repository.findSize()) {
            System.out.println(repository.getTriangle(count));
            System.out.println(warehouse.getProperty(repository.getTriangle(count++).getShapeId()));
        }
        ShapeFactory factory = new TriangleFactoryImpl();
        factory.createInstance(new CustomPoint(12,3));
    }
}
