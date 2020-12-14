package com.epam.shape.model.observer.impl;

import com.epam.shape.model.entity.Triangle;
import com.epam.shape.model.entity.TriangleProperty;
import com.epam.shape.model.entity.TriangleType;
import com.epam.shape.model.observer.CustomObserver;
import com.epam.shape.model.observer.TriangleEvent;
import com.epam.shape.model.repository.TriangleRepository;
import com.epam.shape.model.service.TriangleService;
import com.epam.shape.model.service.impl.TriangleServiceImpl;
import com.epam.shape.model.warehouse.TrianglePropertyWarehouse;
import com.epam.shape.validator.TriangleValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TriangleObserverImpl implements CustomObserver {
    private final static Logger logger = LogManager.getLogger();
    private final static String TRIANGLE_NOT_EXISTS_MESSAGE = "Triangle doesn't exist, it will be deleted from the list.";

    @Override
    public void parameterChanged(TriangleEvent event) {
        Triangle triangle = event.getSource();
        if (TriangleValidator.isTriangleExist(triangle.getPoint1(), triangle.getPoint2(), triangle.getPoint3())) {
            TriangleService service = new TriangleServiceImpl();
            double square = service.findSquare(triangle);
            double perimeter = service.findPerimeter(triangle);
            List<TriangleType> types = service.findTriangleType(triangle);
            TriangleProperty property = new TriangleProperty(square, perimeter, types);
            TrianglePropertyWarehouse.getWarehouse().putProperty(triangle.getShapeId(), property);
        } else {
            TrianglePropertyWarehouse.getWarehouse().removeProperty(triangle.getShapeId());
            TriangleRepository.getRepository().remove(triangle);
            logger.log(Level.INFO, TRIANGLE_NOT_EXISTS_MESSAGE);
        }
    }
}
