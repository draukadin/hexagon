package com.pphi.hexagon.neighbors;

import com.pphi.hexagon.coordinates.HexagonCubeCoordinate;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public enum PointyTopCubeNeighbors {

    SW(-1, 0, 1),
    NW(0, 1, -1),
    SE(0, -1, 1),
    NE(1, 0, -1),
    E(1, -1, 0),
    W(-1, 1, 0);

    private int x;
    private int y;
    private int z;

    PointyTopCubeNeighbors(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static List<HexagonCubeCoordinate> getNeighbors(HexagonCubeCoordinate start) {
        List<HexagonCubeCoordinate> neighbors = newArrayList();
        int xStart = start.getX();
        int yStart = start.getY();
        int zStart = start.getZ();
        for (PointyTopCubeNeighbors ptcn : PointyTopCubeNeighbors.values()) {
            neighbors.add(new HexagonCubeCoordinate((xStart + ptcn.getX()),
                    (yStart + ptcn.getY()), (zStart + ptcn.getZ())));
        }
        return neighbors;
    }

    public static HexagonCubeCoordinate getNeighbor(HexagonCubeCoordinate start, PointyTopCubeNeighbors direction) {
        int xStart = start.getX();
        int yStart = start.getY();
        int zStart = start.getZ();
        return new HexagonCubeCoordinate((
                xStart + direction.getX()),
                (yStart + direction.getY()),
                (zStart + direction.getZ()));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
