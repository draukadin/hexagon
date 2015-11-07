package com.pphi.hexagon.coordinates;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HexagonAxialCoordinateTest {

    private HexagonAxialCoordinate coordinate;

    @BeforeClass
    public void setup() {
        coordinate = new HexagonAxialCoordinate(10, 2);
    }

    @Test
    public void axialCoordinateTest() {
        //Assert
        assertEquals(coordinate.getQ(), 10);
        assertEquals(coordinate.getR(), 2);

        System.out.println(coordinate.hashCode());
    }

    @Test
    public void toStringTest() throws Exception {
        //Arrange
        String expected = "HexagonAxialCoordinate{q=10, r=2}";

        //Assert
        assertEquals(coordinate.toString(), expected);
    }

    @Test
    public void hashCodeTest() throws Exception {
        //Arrange
        int expected = 1273;

        //Assert
        assertEquals(coordinate.hashCode(), expected);
    }
}
