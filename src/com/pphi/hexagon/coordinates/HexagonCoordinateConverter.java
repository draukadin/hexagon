package com.pphi.hexagon.coordinates;

import java.awt.geom.Point2D;

import com.pphi.hexagon.Orientation;
import com.pphi.hexagon.util.CoordinateUtil;

public class HexagonCoordinateConverter {

    private static final int DIVISOR = 2;
    private static final double TWO = 2.0;
    private static final double THREE = 3.0;
    private static final double SQRT_THREE = Math.sqrt(THREE);

    public HexagonAxialCoordinate getAxialCoordinate(HexagonCubeCoordinate cubeCoordinate) {
        return new HexagonAxialCoordinate(cubeCoordinate.getX(), cubeCoordinate.getZ());
    }

    public HexagonCubeCoordinate getCubeCoordinate(HexagonAxialCoordinate axialCoordinate) {
        int y = - axialCoordinate.getQ() - axialCoordinate.getR();
        return new HexagonCubeCoordinate(axialCoordinate.getQ(), y, axialCoordinate.getR());
    }

    public HexagonCubeCoordinate getCubeCoordinate(Point2D point, int size, Orientation orientation) {
        int q, r;
        double x = point.getX();
        double y = point.getY();
        switch (orientation) {
            case POINTY_TOP:
                q = (int) (Math.round(((x * (SQRT_THREE / THREE)) - (y / THREE)) / size));
                r = (int) Math.round((y * TWO / THREE) / size);
                break;
            case FLAT_TOP:
                q = (int) (x * TWO / THREE / size);
                r = (int) ((-x / THREE + SQRT_THREE / THREE * y) / size);
                break;
            default:
                throw new IllegalArgumentException("Invalid Orientation: " + orientation);
        }
        int solvedY = CoordinateUtil.solveForY(q, r);
        return new HexagonCubeCoordinate(q, solvedY, r);
    }

    public Point2D getPixelCoordinate(HexagonAxialCoordinate axialCoordinate, int size, Orientation orientation) {
        double x;
        double y;
        switch (orientation) {
            case POINTY_TOP:
                x = size * Math.sqrt(THREE) * (axialCoordinate.getQ() + (axialCoordinate.getR() / 2.0));
                y = size * (THREE / TWO) * axialCoordinate.getR();
                break;
            case FLAT_TOP:
                x = size * THREE / TWO * axialCoordinate.getQ();
                y = size * SQRT_THREE * (axialCoordinate.getR() + axialCoordinate.getQ() / 2.0);
                break;
            default:
                throw new IllegalArgumentException("Invalid Orientation " + orientation);
        }
        return new Point2D.Double(x, y);
    }

    public HexagonAxialCoordinate convertEvenQ(HexagonCubeCoordinate cubeCoordinate) {
        int q = cubeCoordinate.getX();
        int r = cubeCoordinate.getZ() + (q + (q & 1)) / DIVISOR;
        return new HexagonAxialCoordinate(q, r);
    }

    public HexagonCubeCoordinate convertFromEvenQ(HexagonAxialCoordinate axialCoordinate) {
        int x = axialCoordinate.getQ();
        int z = axialCoordinate.getR() - (x + (x & 1)) / DIVISOR;
        int y = -x - z;
        return new HexagonCubeCoordinate(x, y, z);
    }

    public HexagonAxialCoordinate convertOddQ(HexagonCubeCoordinate cubeCoordinate) {
        int q = cubeCoordinate.getX();
        int r = cubeCoordinate.getZ() + (q - (q & 1)) / DIVISOR;
        return new HexagonAxialCoordinate(q, r);
    }

    public HexagonCubeCoordinate convertFromOddQ(HexagonAxialCoordinate axialCoordinate) {
        int x = axialCoordinate.getQ();
        int z = axialCoordinate.getR() - (x - (x & 1)) / 2;
        int y = -x - z;
        return new HexagonCubeCoordinate(x, y, z);
    }

    public HexagonAxialCoordinate convertEvenR(HexagonCubeCoordinate cubeCoordinate) {
        int r = cubeCoordinate.getZ();
        int q = cubeCoordinate.getX() + (r + (r & 1)) / DIVISOR;
        return new HexagonAxialCoordinate(q, r);
    }

    public HexagonCubeCoordinate convertFromEvenR(HexagonAxialCoordinate axialCoordinate) {
        int z = axialCoordinate.getR();
        int x = axialCoordinate.getQ() - (z + (z & 1)) / DIVISOR;
        int y = -x - z;
        return new HexagonCubeCoordinate(x, y, z);
    }

    public HexagonAxialCoordinate convertOddR(HexagonCubeCoordinate cubeCoordinate) {
        int r = cubeCoordinate.getZ();
        int q = cubeCoordinate.getX() + (r - (r & 1)) / DIVISOR;
        return new HexagonAxialCoordinate(q, r);
    }

    public HexagonCubeCoordinate convertFromOddR(HexagonAxialCoordinate axialCoordinate) {
        int z = axialCoordinate.getR();
        int x = axialCoordinate.getQ() - (z - (z & 1)) / DIVISOR;
        int y = -x - z;
        return new HexagonCubeCoordinate(x, y, z);
    }
}
