package com.pphi.hexagon.distance;

import static java.lang.Math.abs;
import static java.lang.Math.max;

import com.pphi.hexagon.coordinates.HexagonAxialCoordinate;
import com.pphi.hexagon.coordinates.HexagonCoordinateConverter;
import com.pphi.hexagon.coordinates.HexagonCubeCoordinate;

public class HexagonDistance {

    public int distance(HexagonCubeCoordinate point1, HexagonCubeCoordinate point2) {
        int first = max(abs((point1.getX() - point2.getX())), abs((point1.getY() - point2.getY())));
        return max(first, abs((point1.getZ() - point2.getZ())));
    }

    public int distance(HexagonAxialCoordinate a, HexagonAxialCoordinate b) {
        HexagonCoordinateConverter hexagonCoordinateConverter = new HexagonCoordinateConverter();
        HexagonCubeCoordinate point1 = hexagonCoordinateConverter.getCubeCoordinate(a);
        HexagonCubeCoordinate point2 = hexagonCoordinateConverter.getCubeCoordinate(b);
        return distance(point1, point2);
    }
}
