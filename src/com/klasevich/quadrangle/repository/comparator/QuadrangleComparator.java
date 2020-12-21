package com.klasevich.quadrangle.repository.comparator;

import com.klasevich.quadrangle.entity.Quadrangle;
import com.klasevich.quadrangle.entity.QuadrangleProperty;
import com.klasevich.quadrangle.warehouse.QuadranglePropertyWarehouse;

import java.util.Comparator;

public enum QuadrangleComparator implements Comparator<Quadrangle> {
    ID {
        @Override
        public int compare(Quadrangle o1, Quadrangle o2) {
            return Integer.compare(o1.getShapeId(), o2.getShapeId());
        }
    },
    AREA {
        @Override
        public int compare(Quadrangle o1, Quadrangle o2) {
           QuadranglePropertyWarehouse quadranglePropertyWarehouse = QuadranglePropertyWarehouse.getInstance();
           int id1 = o1.getShapeId();
           int id2 = o2.getShapeId();
           double area1 = quadranglePropertyWarehouse.getQuadrangleProperty(id1).getArea();
           double area2 = quadranglePropertyWarehouse.getQuadrangleProperty(id2).getArea();
            return Double.compare(area1, area2);
        }
    },
    PERIMETER {
        @Override
        public int compare(Quadrangle o1, Quadrangle o2) {
            QuadranglePropertyWarehouse quadranglePropertyWarehouse = QuadranglePropertyWarehouse.getInstance();
            int id1 = o1.getShapeId();
            int id2 = o2.getShapeId();
            double perimeter1 = quadranglePropertyWarehouse.getQuadrangleProperty(id1).getPerimeter();
            double perimeter2 = quadranglePropertyWarehouse.getQuadrangleProperty(id2).getPerimeter();
            return Double.compare(perimeter1,perimeter2);
        }
    }
}

