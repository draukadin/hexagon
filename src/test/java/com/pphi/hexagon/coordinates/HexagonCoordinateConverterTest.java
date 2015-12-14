package com.pphi.hexagon.coordinates;

import static com.google.common.collect.Maps.newHashMap;
import static com.pphi.hexagon.Orientation.POINTY_TOP;
import static org.testng.Assert.assertEquals;

import java.awt.geom.Point2D;
import java.util.Map;

import org.testng.annotations.Test;

public class HexagonCoordinateConverterTest {

    private HexagonAxialCoordinate originAxial = new HexagonAxialCoordinate(0, 0);
    private HexagonCubeCoordinate hexagonCubeCoordinate1 = new HexagonCubeCoordinate(0 ,1, -1);
    private HexagonAxialCoordinate hexagonAxialCoordinate1 = new HexagonAxialCoordinate(0, -1);
    private HexagonCubeCoordinate hexagonCubeCoordinate2 = new HexagonCubeCoordinate(1 ,0, -1);
    private HexagonAxialCoordinate hexagonAxialCoordinate2 = new HexagonAxialCoordinate(1, -1);

    private HexagonCubeCoordinate hexagonCubeCoordinate3 = new HexagonCubeCoordinate(0 ,-1, 1);
    private HexagonAxialCoordinate hexagonAxialCoordinate3 = new HexagonAxialCoordinate(0, 1);
    private HexagonCubeCoordinate hexagonCubeCoordinate4= new HexagonCubeCoordinate(-1 , 1, 0);
    private HexagonAxialCoordinate hexagonAxialCoordinate4 = new HexagonAxialCoordinate(-1, 0);
    private HexagonAxialCoordinate hexagonAxialCoordinate5 = new HexagonAxialCoordinate(1, 0);

    private HexagonCoordinateConverter hexagonCoordinateConverter = new HexagonCoordinateConverter();

    @Test
    public void convertCubeToAxial() {
        assertEquals(hexagonCoordinateConverter.getAxialCoordinate(hexagonCubeCoordinate1), hexagonAxialCoordinate1);
        assertEquals(hexagonCoordinateConverter.getAxialCoordinate(hexagonCubeCoordinate2), hexagonAxialCoordinate2);
        assertEquals(hexagonCoordinateConverter.getAxialCoordinate(hexagonCubeCoordinate3), hexagonAxialCoordinate3);
        assertEquals(hexagonCoordinateConverter.getAxialCoordinate(hexagonCubeCoordinate4), hexagonAxialCoordinate4);
    }

    @Test
    public void convertAxialToCube() {
        assertEquals(hexagonCoordinateConverter.getCubeCoordinate(hexagonAxialCoordinate1), hexagonCubeCoordinate1);
        assertEquals(hexagonCoordinateConverter.getCubeCoordinate(hexagonAxialCoordinate2), hexagonCubeCoordinate2);
        assertEquals(hexagonCoordinateConverter.getCubeCoordinate(hexagonAxialCoordinate3), hexagonCubeCoordinate3);
        assertEquals(hexagonCoordinateConverter.getCubeCoordinate(hexagonAxialCoordinate4), hexagonCubeCoordinate4);
    }

    @Test
    public void convertPointToCube() {
        Point2D point1 = new Point2D.Double(-11.0, -12.0);
        Point2D point2 = new Point2D.Double(11.0, -11.0);
        Point2D point3 = new Point2D.Double(11.0, 11.0);
        Point2D point4 = new Point2D.Double(-11.0, 0.0);

        assertEquals(hexagonCoordinateConverter.getCubeCoordinate(point1, 10, POINTY_TOP), hexagonCubeCoordinate1);
        assertEquals(hexagonCoordinateConverter.getCubeCoordinate(point2, 10, POINTY_TOP), hexagonCubeCoordinate2);
        assertEquals(hexagonCoordinateConverter.getCubeCoordinate(point3, 10, POINTY_TOP), hexagonCubeCoordinate3);
        assertEquals(hexagonCoordinateConverter.getCubeCoordinate(point4, 10, POINTY_TOP), hexagonCubeCoordinate4);
    }

    @Test
    public void convertCubeToPoint() {
        Point2D point1 = new Point2D.Double(0.0, 0.0);
        Point2D point2 = new Point2D.Double(-8.660254037844386, -15.0);
        Point2D point3 = new Point2D.Double(8.660254037844386, -15.0);
        Point2D point4 = new Point2D.Double(8.660254037844386, 15.0);
        Point2D point5 = new Point2D.Double(-17.32050807568877, 0.0);
        Point2D point6 = new Point2D.Double(17.32050807568877, 0.0);
        assertEquals(hexagonCoordinateConverter.getPixelCoordinate(originAxial, 10, POINTY_TOP), point1);
        assertEquals(hexagonCoordinateConverter.getPixelCoordinate(hexagonAxialCoordinate1, 10, POINTY_TOP), point2);
        assertEquals(hexagonCoordinateConverter.getPixelCoordinate(hexagonAxialCoordinate2, 10, POINTY_TOP), point3);
        assertEquals(hexagonCoordinateConverter.getPixelCoordinate(hexagonAxialCoordinate3, 10, POINTY_TOP), point4);
        assertEquals(hexagonCoordinateConverter.getPixelCoordinate(hexagonAxialCoordinate4, 10, POINTY_TOP), point5);
        assertEquals(hexagonCoordinateConverter.getPixelCoordinate(hexagonAxialCoordinate5, 10, POINTY_TOP), point6);
    }

    @Test
    public void convertCubeToOddR() {
        Map<HexagonCubeCoordinate, HexagonAxialCoordinate> coordinateMap = newHashMap();
        coordinateMap.put(new HexagonCubeCoordinate(), new HexagonAxialCoordinate(0, 0));
        coordinateMap.put(new HexagonCubeCoordinate(1, -1, 0), new HexagonAxialCoordinate(1, 0));
        coordinateMap.put(new HexagonCubeCoordinate(2, -2, 0), new HexagonAxialCoordinate(2, 0));
        coordinateMap.put(new HexagonCubeCoordinate(0, -1, 1), new HexagonAxialCoordinate(0, 1));
        coordinateMap.put(new HexagonCubeCoordinate(1, -2, 1), new HexagonAxialCoordinate(1, 1));
        coordinateMap.put(new HexagonCubeCoordinate(-1, -1, 2), new HexagonAxialCoordinate(0, 2));
        coordinateMap.put(new HexagonCubeCoordinate(0, -2, 2), new HexagonAxialCoordinate(1, 2));
        coordinateMap.put(new HexagonCubeCoordinate(1, -3, 2), new HexagonAxialCoordinate(2, 2));
        coordinateMap.put(new HexagonCubeCoordinate(-1, -2, 3), new HexagonAxialCoordinate(0, 3));
        coordinateMap.put(new HexagonCubeCoordinate(0, -3, 3), new HexagonAxialCoordinate(1, 3));
        coordinateMap.put(new HexagonCubeCoordinate(-2, -2, 4), new HexagonAxialCoordinate(0, 4));
        coordinateMap.put(new HexagonCubeCoordinate(-1, -3, 4), new HexagonAxialCoordinate(1, 4));
        coordinateMap.put(new HexagonCubeCoordinate(0, -4, 4), new HexagonAxialCoordinate(2, 4));
        HexagonCoordinateConverter converter = new HexagonCoordinateConverter();
        for (Map.Entry<HexagonCubeCoordinate, HexagonAxialCoordinate> entry : coordinateMap.entrySet()) {
            assertEquals(converter.convertOddR(entry.getKey()), entry.getValue());
        }
    }
}
