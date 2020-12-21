package com.klasevich.quadrangle.entity;

import com.klasevich.quadrangle.util.generator.QuadrangleIdGenerator;

public abstract class AbstractShape {
    protected int ShapeId = QuadrangleIdGenerator.getCurrentId();

    public AbstractShape() {
    }

    public AbstractShape(int shapeId) {
        ShapeId = shapeId;
    }

    public int getShapeId() {
        return ShapeId;
    }

    public void setShapeId(int shapeId) {
        ShapeId = shapeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractShape that = (AbstractShape) o;
        return getShapeId() == that.getShapeId();
    }

    @Override
    public int hashCode() {
        return 31 * getShapeId();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractShape{");
        sb.append("ShapeId=").append(ShapeId);
        sb.append('}');
        return sb.toString();
    }
}
