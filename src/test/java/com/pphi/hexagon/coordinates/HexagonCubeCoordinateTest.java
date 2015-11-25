package com.pphi.hexagon.coordinates;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class HexagonCubeCoordinateTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void invalidCoordTest() {
        new HexagonCubeCoordinate(1, 1, 1);
    }

    @Test
    public void originCubeCoordinateTest() {
        assertEquals(new HexagonCubeCoordinate(), new HexagonCubeCoordinate(0, 0, 0));
    }

    @Test
    public void coordinateRoundingTest1() {
        HexagonCubeCoordinate actual = new HexagonCubeCoordinate(3.3, -1.5, -1.4);
        HexagonCubeCoordinate expected = new HexagonCubeCoordinate(3, -2, -1);
        assertEquals(actual, expected);
    }

    @Test
    public void coordinateRoundingTest2() {
        HexagonCubeCoordinate actual = new HexagonCubeCoordinate(3.3, -1.9, -1.9);
        HexagonCubeCoordinate expected = new HexagonCubeCoordinate(4, -2, -2);
        assertEquals(actual, expected);
    }

    @Test
    public void coordinateRoundingTest3() {
        HexagonCubeCoordinate actual = new HexagonCubeCoordinate(3.9, -1.9, -1.1);
        HexagonCubeCoordinate expected = new HexagonCubeCoordinate(4, -2, -2);
        assertEquals(actual, expected);
    }
}
