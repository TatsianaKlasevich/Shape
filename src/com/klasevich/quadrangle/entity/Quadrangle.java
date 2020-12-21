package com.klasevich.quadrangle.entity;

import com.klasevich.quadrangle.observer.Observable;
import com.klasevich.quadrangle.observer.Observer;
import com.klasevich.quadrangle.observer.QuadrangleEvent;

import java.util.Collections;
import java.util.List;

public class Quadrangle extends AbstractShape implements Observable {
    private List<Point2D> points;
    private List<Observer> observers;

    public Quadrangle() {
    }

    public Quadrangle(List<Point2D> points) {
        super();
        this.points = points;
    }

    public Quadrangle(int id, List<Point2D> points) {
        super(id);
        this.points = points;
    }

    public Quadrangle(List<Point2D> points, List<Observer> observers) {
        super();
        this.points = points;
        this.observers = observers;
    }

    @Override
    public void attach(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }


    @Override
    public void notifyObservers() {
        QuadrangleEvent event = new QuadrangleEvent(this);
        observers.forEach(o -> o.parameterChanged(event));
    }


    public List<Point2D> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public Point2D getPoints(int index) {
        return points.get(index);
    }

    public void setPoints(List<Point2D> points) {
        this.points = points;
        notifyObservers();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Quadrangle{");
        sb.append("points=").append(points);
        sb.append('}');
        return sb.toString();
    }
}
