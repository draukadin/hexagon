package com.pphi.hexagon.util;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CoordinateUtilTest {

    private int x;
    private int y;
    private int z;

    @BeforeMethod
    public void setUp() throws Exception {
        x = 10;
        y = 5;
        z = -15;
    }

    @Test
    public void testSolveForY() throws Exception {
        assertEquals(CoordinateUtil.solveForY(x, z), y);
    }

    @Test
    public void testSolveForZ() throws Exception {
        assertEquals(CoordinateUtil.solveForZ(x , y), z);
    }

    @Test
    public void testSolveForX() throws Exception {
        assertEquals(CoordinateUtil.solveForX(y, z), x);
    }
}
