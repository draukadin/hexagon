package com.pphi.hexagon.neighbors;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FlapTopCubeNeighborsTest {

    @Test
    public void testMoveNorth() throws Exception {
        //Arrange
        FlapTopCubeNeighbors north = FlapTopCubeNeighbors.N;

        //Assert
        assertEquals(north.getX(), 0);
        assertEquals(north.getY(), 1);
        assertEquals(north.getZ(), -1);
    }

    @Test
    public void testMoveNorthEast() throws Exception {
        //Arrange
        FlapTopCubeNeighbors northEast = FlapTopCubeNeighbors.NE;

        //Assert
        assertEquals(northEast.getX(), 1);
        assertEquals(northEast.getY(), 0);
        assertEquals(northEast.getZ(), -1);
    }

    @Test
    public void testMoveSouthEast() throws Exception {
        //Arrange
        FlapTopCubeNeighbors southEast = FlapTopCubeNeighbors.SE;

        //Assert
        assertEquals(southEast.getX(), 1);
        assertEquals(southEast.getY(), -1);
        assertEquals(southEast.getZ(), 0);
    }

    @Test
    public void testMoveSouth() throws Exception {
        //Arrange
        FlapTopCubeNeighbors south = FlapTopCubeNeighbors.S;

        //Assert
        assertEquals(south.getX(), 0);
        assertEquals(south.getY(), -1);
        assertEquals(south.getZ(), 1);
    }

    @Test
    public void testMoveSouthWest() throws Exception {
        //Arrange
        FlapTopCubeNeighbors southWest = FlapTopCubeNeighbors.SW;

        //Assert
        assertEquals(southWest.getX(), -1);
        assertEquals(southWest.getY(), 0);
        assertEquals(southWest.getZ(), 1);
    }

    @Test
    public void testMoveNorthWest() throws Exception {
        //Arrange
        FlapTopCubeNeighbors northWest = FlapTopCubeNeighbors.NW;

        //Assert
        assertEquals(northWest.getX(), -1);
        assertEquals(northWest.getY(), 1);
        assertEquals(northWest.getZ(), 0);
    }
}
