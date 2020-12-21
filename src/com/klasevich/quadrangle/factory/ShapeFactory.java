package com.klasevich.quadrangle.factory;

import com.klasevich.quadrangle.entity.AbstractShape;

import java.util.List;
import java.util.Optional;

public abstract class ShapeFactory<T extends AbstractShape> {
    public abstract Optional<T> createShape(List<Double> numbers);
}
