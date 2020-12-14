package com.epam.shape.model.repository.specification;

import com.epam.shape.model.entity.Triangle;

public interface Specification {
    boolean specify(Triangle triangle);
}
