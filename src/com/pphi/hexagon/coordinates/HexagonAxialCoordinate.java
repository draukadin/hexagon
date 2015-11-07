package com.pphi.hexagon.coordinates;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class HexagonAxialCoordinate {

    int q;
    int r;

    public HexagonAxialCoordinate(int q, int r) {
        this.q = q;
        this.r = r;
    }

    public int getQ() {
        return q;
    }

    public int getR() {
        return r;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("q", q)
                .add("r", r)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HexagonAxialCoordinate that = (HexagonAxialCoordinate) o;

        return Objects.equal(this.q, that.q) &&
                Objects.equal(this.r, that.r);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(q, r);
    }
}
