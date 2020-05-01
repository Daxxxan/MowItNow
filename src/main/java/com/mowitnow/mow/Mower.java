package com.mowitnow.mow;

import com.mowitnow.enums.Directions;
import com.mowitnow.enums.Moves;
import com.mowitnow.ground.Cell;

import java.util.ArrayList;

public class Mower {
    private Cell initialPosition;
    ArrayList<Moves> mowerMoves;
    Directions direction;

    public Mower() {}

    public Cell getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(Cell initialPosition) {
        this.initialPosition = initialPosition;
    }

    public ArrayList<Moves> getMowerMoves() {
        return mowerMoves;
    }

    public void setMowerMoves(ArrayList<Moves> mowerMoves) {
        this.mowerMoves = mowerMoves;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }
}
