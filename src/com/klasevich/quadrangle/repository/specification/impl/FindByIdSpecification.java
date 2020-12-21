package com.klasevich.quadrangle.repository.specification.impl;

import com.klasevich.quadrangle.entity.Quadrangle;
import com.klasevich.quadrangle.repository.specification.Specification;

public class FindByIdSpecification implements Specification<Quadrangle> {
    private int id;

    public FindByIdSpecification(int maxPerimeter) {
        this.id = id;
    }

    @Override
    public boolean specify(Quadrangle quadrangle) {
        boolean result = false;
        if (quadrangle.getShapeId() == id) {
            result = true;
        }
        return result;
    }
}
