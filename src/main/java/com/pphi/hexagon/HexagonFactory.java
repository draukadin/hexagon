package com.pphi.hexagon;

import java.awt.geom.Point2D;

import com.pphi.hexagon.coordinates.HexagonAxialCoordinate;
import com.pphi.hexagon.coordinates.HexagonCoordinateConverter;
import com.pphi.hexagon.coordinates.HexagonCubeCoordinate;

public final class HexagonFactory {

    private static HexagonCoordinateConverter coordinateConverter = new HexagonCoordinateConverter();

    private HexagonFactory() {
    }

    public static Hexagon create(HexagonCubeCoordinate coordinate, int size, Orientation orientation) {
        Point2D point2D = coordinateConverter.getPixelCoordinate(coordinate, size, orientation);
        return new Hexagon(point2D, size, orientation);
    }

    public static Hexagon create(HexagonAxialCoordinate coordinate, int size, Orientation orientation) {
        Point2D point2D = coordinateConverter.getPixelCoordinate(coordinate, size, orientation);
        return new Hexagon(point2D, size, orientation);
    }
}
