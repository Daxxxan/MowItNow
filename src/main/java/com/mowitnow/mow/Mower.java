package com.mowitnow.mow;

import com.mowitnow.enums.Direction;
import com.mowitnow.enums.Move;
import com.mowitnow.ground.Cell;
import com.mowitnow.ground.Field;

import java.util.ArrayList;
import java.util.Objects;

public class Mower {
    private Cell position;
    ArrayList<Move> mowerMoves;
    Direction direction;

    public Mower() {}

    public Mower(Cell position, ArrayList<Move> mowerMoves, Direction direction) {
        this.position = position;
        this.mowerMoves = mowerMoves;
        this.direction = direction;
    }

    public Cell getPosition() {
        return position;
    }

    public void setPosition(Cell position) {
        this.position = position;
    }

    public ArrayList<Move> getMoves() {
        return mowerMoves;
    }

    public void setMowerMoves(ArrayList<Move> mowerMoves) {
        this.mowerMoves = mowerMoves;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void moveForward(Field field) {
        if(getDirection().equals(Direction.N)) {
            goNorth(field);
        } else if(getDirection().equals(Direction.W)) {
            goWest(field);
        } else if(getDirection().equals(Direction.S)) {
            goSouth(field);
        } else {
            goEast(field);
        }
    }

    public void goNorth(Field field) {
        if(field.canIGoNorth(getPosition().getY())) {
            getPosition().setY(getPosition().getY() + 1);
        }
    }

    public void goWest(Field field) {
        if(field.canIGoWest(getPosition().getX())) {
            getPosition().setX(getPosition().getX() - 1);
        }
    }


    public void goSouth(Field field) {
        if(field.canIGoSouth(getPosition().getY())) {
            getPosition().setY(getPosition().getY() - 1);
        }
    }

    public void goEast(Field field) {
        if(field.canIGoEast(getPosition().getX())) {
            getPosition().setX(getPosition().getX() + 1);
        }
    }

    public String toString() {
        return "X: " + getPosition().getX()
                + ", Y: " + getPosition().getY()
                + ", Direction: " + getDirection().name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return Objects.equals(position, mower.position) &&
                Objects.equals(mowerMoves, mower.mowerMoves) &&
                direction == mower.direction;
    }
}
