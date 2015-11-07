package com.pphi.hexagon;

import com.pphi.hexagon.Hexagon;

public class HexagonSpacing {

    public double getWidth(Hexagon hexagon) {
        double width = 0.0;
        switch(hexagon.getOrientation()) {
            case POINTY_TOP:
                width = Math.sqrt(3.0) / 2.0 * (hexagon.getSize() * 2.0);
                break;
            case FLAT_TOP:
                width = hexagon.getSize() * 2.0;
                break;
        }
        return width;
    }

    public double getHeight(Hexagon hexagon) {
        double height = 0.0;
        switch (hexagon.getOrientation()) {
            case POINTY_TOP:
                height = hexagon.getSize() * 2.0;
                break;
            case FLAT_TOP:
                height = Math.sqrt(3.0) / 2.0 * (hexagon.getSize() * 2.0);
                break;
        }
        return height;
    }
}
