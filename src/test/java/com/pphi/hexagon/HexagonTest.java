package com.pphi.hexagon;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Math.PI;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.geom.Point2D;
import java.util.List;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HexagonTest {

    private List<Double> expectedAnglesPointTop;
    private List<Double> expectedAnglesFlatTop;
    private Hexagon pointy;
    private Hexagon flat;
    private static final double EPSILON = 0.00000000001;

    @BeforeTest
    public void testSetup() {
        expectedAnglesPointTop = newArrayList();
        expectedAnglesFlatTop = newArrayList();
        expectedAnglesPointTop.add(PI / 6);
        expectedAnglesPointTop.add(PI / 2);
        expectedAnglesPointTop.add(5 * PI / 6);
        expectedAnglesPointTop.add(7 * PI / 6);
        expectedAnglesPointTop.add(3 * PI / 2);
        expectedAnglesPointTop.add(11 * PI / 6);
        expectedAnglesFlatTop.add(0.0);
        expectedAnglesFlatTop.add(PI / 3);
        expectedAnglesFlatTop.add(2 * PI / 3);
        expectedAnglesFlatTop.add(PI);
        expectedAnglesFlatTop.add(4 * PI / 3);
        expectedAnglesFlatTop.add(5 * PI / 3);
        pointy = new Hexagon(0.0, 0.0, 10, Orientation.POINTY_TOP);
        flat = new Hexagon(0.0, 0.0, 10, Orientation.FLAT_TOP);
    }

    @Test
    public void hexagonCenterTest() {
        //Arrange
        Point2D expected = new Point2D.Double(0.0, 0.0);
        Point2D actual = pointy.getCenter();

        //Assert
        assertEquals(actual, expected);
    }

    @Test
    public void pointyTopHexagonAngleTest() {
        for (int i = 0; i < 6; i++) {
            assertEquals(pointy.pointyTop(i), expectedAnglesPointTop.get(i), EPSILON);
        }
    }

    @Test
    public void flatTopHexagonAngleTest() {
        for (int i = 0; i < 6; i++) {
            assertEquals(flat.flatTop(i), expectedAnglesFlatTop.get(i), EPSILON);
        }
    }

    @Test
    public void calculateAnglePointTopTest() {
        for (int i = 0; i < 6; i++) {
            assertEquals(pointy.calculateAngle(Orientation.POINTY_TOP, i), expectedAnglesPointTop.get(i), EPSILON);
        }
    }

    @Test
    public void calculateAngleFlatTopTest() {
        for (int i = 0; i < 6; i++) {
            assertEquals(flat.calculateAngle(Orientation.FLAT_TOP, i), expectedAnglesFlatTop.get(i), EPSILON);
        }
    }

    @Test
    public void pointyTopWidthTest() {
        assertEquals(pointy.getWidth(), 17.32050807568877, EPSILON);
    }

    @Test
    public void flatTopWidthTest() {
        assertEquals(flat.getWidth(), 20.0, EPSILON);
    }

    @Test
    public void pointyTopHeightTest() {
        assertEquals(pointy.getHeight(), 20.0, EPSILON);
    }

    @Test
    public void flatTopHeightTest() {
        assertEquals(flat.getHeight(), 17.32050807568877, EPSILON);
    }

    @Test
    public void getVertices() {
        float[] vertices = pointy.getVertices();
        assertTrue(vertices.length == 12, "A hexagon must have 6 X-Coords and 6 Y-Coords");

        int x = 0;
        int y = 1;
        for (int i = 0; i < 6; i++) {
            assertEquals((int) vertices[x], pointy.xpoints[i]);
            assertEquals((int) vertices[y], pointy.ypoints[i]);
            x += 2;
            y += 2;
        }
    }
}
