package mow;

import com.mowitnow.enums.Direction;
import com.mowitnow.enums.Move;
import com.mowitnow.ground.Cell;
import com.mowitnow.ground.Field;
import com.mowitnow.mow.Mower;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MowerTest {
    private Cell position;
    private ArrayList<Move> mowerMoves;
    private Direction direction;
    private Field field;
    private Mower mower;

    @Before
    public void setUp() {
        position = new Cell(2, 2);
        mowerMoves = new ArrayList<>(Arrays.asList(Move.A, Move.D, Move.A, Move.G, Move.G, Move.A, Move.D, Move.A));
        direction = Direction.N;
        field = new Field(new Cell(5, 5));
        mower = new Mower(position, mowerMoves, direction);
    }

    @Test
    public void shouldGoOnX2Y4AndTheDirectionShouldBeNorth() {
        mower.moveForward(field);
        mower.setDirection(mower.getDirection().getNextDirection(mower.getDirection().getId()));
        mower.moveForward(field);
        mower.setDirection(mower.getDirection().getPreviousDirection(mower.getDirection().getId()));
        mower.setDirection(mower.getDirection().getPreviousDirection(mower.getDirection().getId()));
        mower.moveForward(field);
        mower.setDirection(mower.getDirection().getNextDirection(mower.getDirection().getId()));
        mower.moveForward(field);
        assertEquals(mower.getPosition().getX(), 2);
        assertEquals(mower.getPosition().getY(), 4);
        assertEquals(mower.getDirection(), Direction.N);
    }

    @Test
    public void shouldMoveNorthTest() {
        mower.goNorth(field);
        assertEquals(mower.getPosition().getX(), 2);
        assertEquals(mower.getPosition().getY(), 3);
        assertEquals(mower.getDirection(), Direction.N);
    }

    @Test
    public void shouldTurnRightAndDirectionShouldBeEastTest() {
        mower.setDirection(mower.getDirection().getNextDirection(mower.getDirection().getId()));
        assertEquals(mower.getPosition().getX(), 2);
        assertEquals(mower.getPosition().getY(), 2);
        assertEquals(mower.getDirection(), Direction.E);
    }

    @Test
    public void shouldTurnRightAndGoEastTest() {
        mower.setDirection(mower.getDirection().getNextDirection(mower.getDirection().getId()));
        mower.goEast(field);
        assertEquals(mower.getPosition().getX(), 3);
        assertEquals(mower.getPosition().getY(), 2);
        assertEquals(mower.getDirection(), Direction.E);
    }

    @Test
    public void shouldTurnLeftAndDirectionShouldBeWest() {
        mower.setDirection(mower.getDirection().getPreviousDirection(mower.getDirection().getId()));
        assertEquals(mower.getPosition().getX(), 2);
        assertEquals(mower.getPosition().getY(), 2);
        assertEquals(mower.getDirection(), Direction.W);
    }

    @Test
    public void shouldTurnLeftAndGoWestTest() {
        mower.setDirection(mower.getDirection().getPreviousDirection(mower.getDirection().getId()));
        mower.goWest(field);
        assertEquals(mower.getPosition().getX(), 1);
        assertEquals(mower.getPosition().getY(), 2);
        assertEquals(mower.getDirection(), Direction.W);
    }

    @Test
    public void shouldTurnBackAndDirectionShouldBeSouthTest() {
        mower.setDirection(mower.getDirection().getNextDirection(mower.getDirection().getId()));
        mower.setDirection(mower.getDirection().getNextDirection(mower.getDirection().getId()));
        assertEquals(mower.getPosition().getX(), 2);
        assertEquals(mower.getPosition().getY(), 2);
        assertEquals(mower.getDirection(), Direction.S);
    }

    @Test
    public void shouldTurnBackAndGoSouthTest() {
        mower.setDirection(mower.getDirection().getNextDirection(mower.getDirection().getId()));
        mower.setDirection(mower.getDirection().getNextDirection(mower.getDirection().getId()));
        mower.goSouth(field);
        assertEquals(mower.getPosition().getX(), 2);
        assertEquals(mower.getPosition().getY(), 1);
        assertEquals(mower.getDirection(), Direction.S);
    }
}
