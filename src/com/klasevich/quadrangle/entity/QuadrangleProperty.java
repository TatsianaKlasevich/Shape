package com.klasevich.quadrangle.entity;

public class QuadrangleProperty {
    private double perimeter;
    private double area;

    public QuadrangleProperty() {
    }

    public QuadrangleProperty(double perimeter, double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuadrangleRecorder{");
        sb.append("perimeter=").append(perimeter);
        sb.append(", square=").append(area);
        sb.append('}');
        return sb.toString();
    }
}
