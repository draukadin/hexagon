package com.pphi.hexagon.coordinates;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.pphi.hexagon.util.CoordinateUtil;

public class HexagonCubeCoordinate {
    private int x;
    private int y;
    private int z;

    public HexagonCubeCoordinate(int x, int y, int z) {
        int sum = x + y + z;
        checkArgument(sum == 0, "The sum of the coordinates must equal zero.  Found: "
                + " x = " + x
                + " y = " + y
                + " z = " + z
                + " Sum = " + sum);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public HexagonCubeCoordinate(double x, double y, double z){
        double roundedX = Math.round(x);
        double roundedY = Math.round(y);
        double roundedZ = Math.round(z);

        double diffX = Math.abs(roundedX - x);
        double diffY = Math.abs(roundedY - y);
        double diffZ = Math.abs(roundedZ - z);

        if (diffX > diffY && diffX > diffZ) {
            roundedX = CoordinateUtil.solveForX((int) roundedY, (int) roundedZ);
        }
        else if (diffY > diffZ) {
            roundedY = CoordinateUtil.solveForY((int) roundedX, (int) roundedZ);
        }
        else {
            roundedZ = CoordinateUtil.solveForZ((int) roundedX, (int) roundedY);
        }

        this.x = (int) roundedX;
        this.y = (int) roundedY;
        this.z = (int) roundedZ;
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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("x", x)
                .add("y", y)
                .add("z", z)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y, z);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final HexagonCubeCoordinate other = (HexagonCubeCoordinate) obj;
        return Objects.equal(this.x, other.x)
                && Objects.equal(this.y, other.y)
                && Objects.equal(this.z, other.z);
    }
}
