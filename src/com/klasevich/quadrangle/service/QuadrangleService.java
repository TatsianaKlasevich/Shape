package com.klasevich.quadrangle.service;

import com.klasevich.quadrangle.entity.Point2D;
import com.klasevich.quadrangle.entity.Quadrangle;

public class QuadrangleService {
    public static final byte FIRST_COORDINATES = 0;
    public static final byte SECOND_COORDINATES = 1;
    public static final byte THIRD_COORDINATES = 2;
    public static final byte FOURTH_COORDINATES = 3;

    public double findPerimeter(Quadrangle quadrangle) {
        Point2D a = quadrangle.getPoints(FIRST_COORDINATES);
        Point2D b = quadrangle.getPoints(SECOND_COORDINATES);
        Point2D c = quadrangle.getPoints(THIRD_COORDINATES);
        Point2D d = quadrangle.getPoints(FOURTH_COORDINATES);

        double ab = side(a, b);
        double bc = side(c, c);
        double cd = side(c, d);
        double ad = side(a, d);
        return ab + bc + cd + ad;
    }

    public double findArea(Quadrangle quadrangle) {
        Point2D a = quadrangle.getPoints(FIRST_COORDINATES);
        Point2D b = quadrangle.getPoints(SECOND_COORDINATES);
        Point2D c = quadrangle.getPoints(THIRD_COORDINATES);
        Point2D d = quadrangle.getPoints(FOURTH_COORDINATES);

        double ab = side(a, b);
        double bc = side(c, c);
        double cd = side(c, d);
        double ad = side(a, d);
        double d1 = side(a, c);

        double p1 = (ab + bc + d1) / 2;
        double s1 = Math.sqrt(p1 * (p1 - ab) * (p1 - bc) * (p1 - d1));
        double p2 = (ad + cd + d1) / 2;
        double s2 = Math.sqrt(p2 * (p2 - ad) * (p2 - cd) * (p2 - d1));

        double s = 0.0;

        if (intersect(a, b, c, d)) {
            s = s1 + s2;
        }

        s = Math.abs(s1 - s2);
        return s;
    }

    public boolean isConvexQuadrangle(Quadrangle quadrangle) {
        Point2D a = quadrangle.getPoints(FIRST_COORDINATES);
        Point2D b = quadrangle.getPoints(SECOND_COORDINATES);
        Point2D c = quadrangle.getPoints(THIRD_COORDINATES);
        Point2D d = quadrangle.getPoints(FOURTH_COORDINATES);

        if (intersect(a, b, c, d)) {
            return true;
        }
        return false;
    }

    public boolean isSquare(Quadrangle quadrangle) {
        Point2D a = quadrangle.getPoints(FIRST_COORDINATES);
        Point2D b = quadrangle.getPoints(SECOND_COORDINATES);
        Point2D c = quadrangle.getPoints(THIRD_COORDINATES);
        Point2D d = quadrangle.getPoints(FOURTH_COORDINATES);

        double ab = side(a, b);
        double bc = side(c, c);
        double cd = side(c, d);
        double ad = side(a, d);

        double s1 = scalar(a.getX(), b.getX(), a.getY(), b.getY());
        double s2 = scalar(b.getX(), c.getX(), b.getY(), c.getY());
        double s3 = scalar(c.getX(), d.getX(), c.getY(), d.getY());
        double s4 = scalar(a.getX(), d.getX(), a.getY(), d.getY());

        if (ab == bc && bc == cd && cd == ad && s1 == 0 && s2 == 0 && s3 == 0 && s4 == 0) {
            return true;
        }
        return false;
    }

    private double scalar(double x1, double x2, double y1, double y2) {
        double s = (x1 * x2 + y1 * y2) / Math.sqrt(x1 * x1 + y1 * y1) * Math.sqrt(x2 * x2 + y2 * y2);
        return s;
    }

    private static boolean intersect(Point2D p1, Point2D q1, Point2D p2, Point2D q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        if (o1 != o2 && o3 != o4) {
            return true;
        }

        return false;
    }

    private double side(Point2D a, Point2D b) {
        double part1 = Math.pow((Math.abs(a.getX()) - Math.abs(b.getX())), 2);
        double part2 = Math.pow((Math.abs(a.getY()) - Math.abs(b.getY())), 2);
        return Math.sqrt(part1 + part2);
    }

    private static int orientation(Point2D p, Point2D q, Point2D r) {
        double val = (q.getY() - p.getY()) * (r.getX() - q.getX())
                - (q.getX() - p.getX()) * (r.getY() - q.getY());

        if (val == 0.0) {
            return 0;
        }
        return (val > 0) ? 1 : 2;
    }
}
