package com.pphi.hexagon;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HexagonSpacingTest {

    private Hexagon pointy;
    private Hexagon flat;
    private HexagonSpacing spacing;
    private static final double EPSILON = 0.00000000001;

    @BeforeTest
    public void testSetup() {
        pointy = new Hexagon(0.0, 0.0, 100, Orientation.POINTY_TOP);
        flat = new Hexagon(0.0, 0.0, 100, Orientation.FLAT_TOP);
        spacing = new HexagonSpacing();
    }

    @Test
    public void pointyTopWidthTest() {
        assertEquals(spacing.getWidth(pointy), 173.2050807568877, EPSILON);
    }

    @Test
    public void flatTopWidthTest() {
        assertEquals(spacing.getWidth(flat), 200.0, EPSILON);
    }

    @Test
    public void pointyTopHeightTest() {
        assertEquals(spacing.getHeight(pointy), 200.0, EPSILON);
    }

    @Test
    public void flatTopHeightTest() {
        assertEquals(spacing.getHeight(flat), 173.2050807568877, EPSILON);
    }
}
