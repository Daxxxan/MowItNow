package com.mowitnow.ground;

import com.mowitnow.ground.Cell;

public class Field {
    Cell topRightCell;
    Cell bottomLeftCell;

    public Field(Cell topRightCell) {
        this.topRightCell = topRightCell;
        this.bottomLeftCell = new Cell(0, 0);
    }
}
