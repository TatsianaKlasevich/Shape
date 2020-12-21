package com.klasevich.quadrangle.repository.specification.impl;

import com.klasevich.quadrangle.entity.Quadrangle;
import com.klasevich.quadrangle.repository.specification.Specification;
import com.klasevich.quadrangle.warehouse.QuadranglePropertyWarehouse;

public class PerimeterRateSpecification implements Specification<Quadrangle> {
    private int minPerimeter;
    private int maxPerimeter;

    public PerimeterRateSpecification(int minPerimeter, int maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean specify(Quadrangle quadrangle) {
        int id = quadrangle.getShapeId();
        QuadranglePropertyWarehouse warehouse = QuadranglePropertyWarehouse.getInstance();
        double perimeter = warehouse.getQuadrangleProperty(id).getPerimeter();
        return (perimeter < maxPerimeter && perimeter > minPerimeter);
    }
}
