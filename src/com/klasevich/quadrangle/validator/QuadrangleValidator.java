package com.klasevich.quadrangle.validator;

import com.klasevich.quadrangle.entity.Point2D;

import java.util.List;

public class QuadrangleValidator {
    private static final byte FIRST_COORDINATES = 0;
    private static final byte SECOND_COORDINATES = 1;
    private static final byte THIRD_COORDINATES = 2;
    private static final byte FOURTH_COORDINATES = 3;

    public static boolean isQuadrangle(List<Point2D> points) {
        Point2D a = points.get(FIRST_COORDINATES);
        Point2D b = points.get(SECOND_COORDINATES);
        Point2D c = points.get(THIRD_COORDINATES);
        Point2D d = points.get(FOURTH_COORDINATES);

        if (isPointsOnLine(a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY()) ||
                isPointsOnLine(b.getX(), b.getY(), c.getX(), c.getY(), d.getX(), d.getY()) ||
                isPointsOnLine(a.getX(), a.getY(), c.getX(), c.getY(), d.getX(), d.getY()) ||
                isPointsOnLine(a.getX(), a.getY(), b.getX(), b.getY(), d.getX(), d.getY())) {
            return false;
        }
        return true;
    }

    private static boolean isPointsOnLine(double x1, double y1, double x2, double y2, double x3, double y3) {
        if ((y2 - y1) / (x2 - x1) == (y3 - y2) / (x3 - x2)) {
            return true;
        }
        return false;
    }
}
