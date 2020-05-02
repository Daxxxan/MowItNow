package com.mowitnow.ground;

import com.mowitnow.ground.Cell;

public class Field {
    Cell topRightCell;
    Cell bottomLeftCell;

    public Field(Cell topRightCell) {
        this.topRightCell = topRightCell;
        this.bottomLeftCell = new Cell(0, 0);
    }

    public boolean canIGoNorth(int y) { return topRightCell.getY() != y; }

    public boolean canIGoWest(int x) {
        return bottomLeftCell.getX() != x;
    }

    public boolean canIGoSouth(int y) {
        return bottomLeftCell.getY() != y;
    }

    public boolean canIGoEast(int x) {
        return topRightCell.getX() != x;
    }
}
