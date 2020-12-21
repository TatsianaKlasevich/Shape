package com.klasevich.quadrangle.repository.specification.impl;

import com.klasevich.quadrangle.entity.Point2D;
import com.klasevich.quadrangle.entity.Quadrangle;
import com.klasevich.quadrangle.repository.specification.Specification;

import java.util.List;

public class CoordinateRangeSpecification implements Specification<Quadrangle> {
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;

    public CoordinateRangeSpecification(double minX, double maxX, double minY, double maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    @Override
    public boolean specify(Quadrangle quadrangle) {
        boolean result = false;
        List<Point2D> points = quadrangle.getPoints();
        for (Point2D point : points) {
            if (point.getX() >= minX && point.getX() <= maxX && point.getY() >= minY && point.getY() <= maxY) {
                result = true;
            }
        }
        return result;
    }
}
