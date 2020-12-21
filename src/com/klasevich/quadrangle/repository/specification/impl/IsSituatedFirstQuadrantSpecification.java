package com.klasevich.quadrangle.repository.specification.impl;

import com.klasevich.quadrangle.entity.Point2D;
import com.klasevich.quadrangle.entity.Quadrangle;
import com.klasevich.quadrangle.repository.specification.Specification;

import java.util.List;

public class IsSituatedFirstQuadrantSpecification implements Specification<Quadrangle> {
    @Override
    public boolean specify(Quadrangle quadrangle) {
        boolean result = false;
        List<Point2D> points = quadrangle.getPoints();
        for (Point2D point : points) {
            if (point.getX() > 0 && point.getY() > 0) {
                result = true;
            }
        }
        return result;
    }
}
