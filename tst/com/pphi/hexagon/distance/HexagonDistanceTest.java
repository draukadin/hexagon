package com.pphi.hexagon.distance;

import static org.testng.Assert.assertEquals;

import com.pphi.hexagon.coordinates.HexagonAxialCoordinate;
import com.pphi.hexagon.coordinates.HexagonCoordinateConverter;
import com.pphi.hexagon.coordinates.HexagonCubeCoordinate;
import org.testng.annotations.Test;

public class HexagonDistanceTest {

    private HexagonCubeCoordinate origin = new HexagonCubeCoordinate(0, 0, 0);
    private HexagonCubeCoordinate destination1 = new HexagonCubeCoordinate(5, -5, 0);
    private HexagonCubeCoordinate destination2 = new HexagonCubeCoordinate(-5, 5, 0);
    private HexagonCubeCoordinate destination3 = new HexagonCubeCoordinate(0, 5, -5);
    private HexagonCubeCoordinate destination4 = new HexagonCubeCoordinate(0, -5, 5);
    private HexagonCubeCoordinate destination5 = new HexagonCubeCoordinate(2, 2, -4);
    private HexagonDistance distance = new HexagonDistance();

    @Test
    public void distanceTestOne() {
        assertEquals(distance.distance(origin, destination1), 5);
    }

    @Test
    public void distanceTestTwo() {
        assertEquals(distance.distance(origin, destination2), 5);
    }

    @Test
    public void distanceTestThree() {
        assertEquals(distance.distance(origin, destination3), 5);
    }

    @Test
    public void distanceTestFour() {
        assertEquals(distance.distance(origin, destination4), 5);
    }

    @Test
    public void distanceTestFive() {
        assertEquals(distance.distance(origin, destination5), 4);
    }

    @Test
    public void distanceTestSix() {
        assertEquals(distance.distance(destination1, destination2), 10);
    }

    @Test
    public void cubeCoordinateDistanceTest() {
        HexagonCubeCoordinate destination = new HexagonCubeCoordinate(3, -5, 2);
        HexagonDistance distance = new HexagonDistance();
        assertEquals(distance.distance(origin, destination), 5);
    }

    @Test
    public void axialCoordinateDistanceTest() {
        HexagonCoordinateConverter converter = new HexagonCoordinateConverter();
        HexagonCubeCoordinate origin = new HexagonCubeCoordinate(0, 0, 0);
        HexagonCubeCoordinate destination = new HexagonCubeCoordinate(3, -5, 2);
        HexagonAxialCoordinate originAxial = converter.getAxialCoordinate(origin);
        HexagonAxialCoordinate destinationAxial = converter.getAxialCoordinate(destination);
        HexagonDistance distance = new HexagonDistance();
        assertEquals(distance.distance(originAxial, destinationAxial), 5);
    }
}
