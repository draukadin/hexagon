package com.pphi.hexagon.neighbors;

public enum FlapTopCubeNeighbors {
    N(0, 1, -1),
    NE(1, 0, -1),
    SE(1, -1, 0),
    S(0, -1, 1),
    SW(-1, 0, 1),
    NW(-1, 1, 0);

    private int x;
    private int y;
    private int z;

    FlapTopCubeNeighbors(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
