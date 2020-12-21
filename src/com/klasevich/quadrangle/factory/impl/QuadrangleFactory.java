package com.klasevich.quadrangle.factory.impl;

import com.klasevich.quadrangle.entity.Point2D;
import com.klasevich.quadrangle.entity.Quadrangle;
import com.klasevich.quadrangle.factory.ShapeFactory;
import com.klasevich.quadrangle.validator.QuadrangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuadrangleFactory extends ShapeFactory<Quadrangle> {
    Logger logger = LogManager.getLogger();
    private static final int NUMBER_OF_COORDINATES = 8;

    @Override
    public Optional<Quadrangle> createShape(List<Double> numbers) {
        List<Point2D> points = new ArrayList<>();
        if (numbers.size() != NUMBER_OF_COORDINATES) {
            logger.error("The number of coordinates is incorrect");
            return Optional.empty();
        }

        for (int j = 0; j < numbers.size(); j += 2) {
            double x = numbers.get(j);
            double y = numbers.get(j + 1);
            points.add(new Point2D(x, y));
        }
        Optional<Quadrangle> result = Optional.of(new Quadrangle(points));

        if (!QuadrangleValidator.isQuadrangle(points)) {
            result = Optional.empty();
        }
        return result;
    }
}
