package com.mowitnow.enums;

public enum Direction {
    N(0),
    E(1),
    S(2),
    W(3);

    private int id;

    Direction(int i) {
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    public Direction getDirectionById(int id) {
        for(Direction direction : Direction.values()) {
            if(direction.getId() == id) {
                return direction;
            }
        }
        return null;
    }

    public Direction getNextDirection(int id) {
        if(exist(id + 1)) {
            return getDirectionById(id + 1);
        }
        return getDirectionById(0);
    }

    public Direction getPreviousDirection(int id) {
        if(exist(id - 1)) {
            return getDirectionById(id - 1);
        }
        return getDirectionById(3);
    }

    public boolean exist(int id) {
        for(Direction direction : Direction.values()) {
            if(direction.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
