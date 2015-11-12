package com.pphi.hexagon;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.round;
import static java.lang.Math.sin;

import java.awt.Polygon;
import java.awt.geom.Point2D;

public class Hexagon extends Polygon {

    private static final int EDGES = 6;
    private Point2D center;
    private int size;
    private Orientation orientation;
    private HexagonSpacing spacing;

    public Point2D getCenter() {
        return center;
    }

    public int getSize() {
        return size;
    }

    public double getWidth() {
        return spacing.getWidth(this);
    }

    public double getHeight() {
        return spacing.getHeight(this);
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Hexagon(double x, double y, int radius, Orientation orientation) {
        this(new Point2D.Double(x, y), radius, orientation);
    }

    public Hexagon(Point2D center, int size, Orientation orientation) {
        this.center = center;
        this.size = size;
        this.orientation = orientation;
        for (int i = 0; i < EDGES; i++) {
            double angle = calculateAngle(orientation, i);
            Point2D vertex = calculateVertex(center, angle, size);
            int x = (int) round(vertex.getX());
            int y = (int) round(vertex.getY());
            addPoint(x, y);
        }
        spacing = new HexagonSpacing();
    }

    double calculateAngle(Orientation orientation, int i) {
        double angle = 0;
        switch (orientation) {
            case FLAT_TOP:
                angle = flatTop(i);
                break;
            case POINTY_TOP:
                angle = pointyTop(i);
                break;
        }
        return angle;
    }

    double pointyTop(int i) {
        return ((2 * PI) / EDGES) * (i + 0.5);
    }

    double flatTop(int i) {
        return ((2 * PI) / EDGES) * (i);
    }

    Point2D calculateVertex(Point2D center, double angle, int radius) {
        double x = center.getX() + radius * cos(angle);
        double y = center.getY() + radius * sin(angle);
        return new Point2D.Double(x, y);
    }
}
