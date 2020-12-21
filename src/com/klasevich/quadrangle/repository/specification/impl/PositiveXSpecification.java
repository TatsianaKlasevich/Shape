package com.klasevich.quadrangle.repository.specification.impl;

import com.klasevich.quadrangle.entity.Point2D;
import com.klasevich.quadrangle.entity.Quadrangle;
import com.klasevich.quadrangle.repository.specification.Specification;

import java.util.List;

public class PositiveXSpecification implements Specification<Quadrangle> {
    private static final int NUMBER_OF_POINTS = 4;

    @Override
    public boolean specify(Quadrangle quadrangle) {
        boolean result = true;
        List<Point2D> points = quadrangle.getPoints();
        for (int i = 0; i < points.size(); i++) {
            result = points.get(i).getX() > 0;
        }
        return result;
    }
}

