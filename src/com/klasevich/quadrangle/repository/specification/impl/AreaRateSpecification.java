package com.klasevich.quadrangle.repository.specification.impl;

import com.klasevich.quadrangle.entity.Quadrangle;
import com.klasevich.quadrangle.repository.specification.Specification;
import com.klasevich.quadrangle.warehouse.QuadranglePropertyWarehouse;

public class AreaRateSpecification implements Specification<Quadrangle> {
    private double minArea;
    private double maxArea;

    public AreaRateSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specify(Quadrangle quadrangle) {
        int id = quadrangle.getShapeId();
        QuadranglePropertyWarehouse warehouse = QuadranglePropertyWarehouse.getInstance();
        double area = warehouse.getQuadrangleProperty(id).getArea();
        return (area < maxArea && area > minArea);
    }
}
