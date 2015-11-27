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
    private float[] vertices;
    private short[] triangles;

    public Point2D getCenter() {
        return center;
    }

    /**
     * lib gdx uses the lower left corner of the image to start drawing the image
     * @return the x coordinate offset from the center by half the size of the shape
     */
    public float getLowerLeftX() {
        return (float) (center.getX() - (size / 2f));
    }

    /**
     * lib gdx uses the lower left corner of the image to start drawing the image
     * so we need to offset from the center by half of the size
     * @return the y coordinate offset from the center by half the size of the shape
     */
    public float getLowerLeftY() {
        return (float) (center.getY() + (size / 2f));
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

    private Hexagon() {
        //Define the vertex coordinates that create a triangle within the hexagon
        triangles = new short[]{//        1
                0, 1, 2,        //        /\
                0, 2, 5,        //     2/____\ 0
                2, 3, 5,        //      |\   |
                3, 4, 5};       //      |  \ |
    }                           //      |___\|
                                //      3\  /5
                                //        \/
                                //         4

    public Hexagon(double x, double y, int radius, Orientation orientation) {
        this(new Point2D.Double(x, y), radius, orientation);
    }

    public Hexagon(float x, float y, int radius, Orientation orientation) {
        this (new Point2D.Float(x, y), radius, orientation);
    }

    public Hexagon(Point2D center, int size, Orientation orientation) {
        this();
        this.center = center;
        this.size = size;
        this.orientation = orientation;
        vertices = new float[EDGES * 2];
        int xIndex = 0;
        int yIndex = 1;
        for (int i = 0; i < EDGES; i++) {
            double angle = calculateAngle(orientation, i);
            Point2D vertex = calculateVertex(center, angle, size);
            int x = (int) round(vertex.getX());
            int y = (int) round(vertex.getY());
            addPoint(x, y);
            vertices[xIndex] = x;
            vertices[yIndex] = y;
            xIndex += 2;
            yIndex += 2;
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

    /**
     * The x and y coordinates in a single array.  x coordinates are in the even index locations, and the their
     * corresponding y coordinate is in the next odd index.  This format is compatible with the libGDX library.
     * @return the coordinates of all 6 vertices for this Hexagon
     */
    public float[] getVertices() {
        return vertices;
    }

    /**
     * The hexagon defined by four triangles
     * @return
     */
    public short[] getTriangles() {
        return triangles;
    }
}
