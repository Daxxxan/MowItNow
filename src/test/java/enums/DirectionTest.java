package enums;

import com.mowitnow.enums.Direction;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {
    @Test
    public void getNorthDirectionByIdTest() {
        assertEquals(Direction.N.getDirectionById(0), Direction.N);
    }

    @Test
    public void getEastDirectionByIdTest() {
        assertEquals(Direction.E.getDirectionById(1), Direction.E);
    }

    @Test
    public void getSouthDirectionByIdTest() {
        assertEquals(Direction.S.getDirectionById(2), Direction.S);
    }

    @Test
    public void getWestDirectionByIdTest() {
        assertEquals(Direction.W.getDirectionById(3), Direction.W);
    }

    @Test
    public void getDirectionAfterNorthTest() {
        assertEquals(Direction.N.getNextDirection(0), Direction.E);
    }

    @Test
    public void getDirectionAfterEastTest() {
        assertEquals(Direction.E.getNextDirection(1), Direction.S);
    }

    @Test
    public void getDirectionAfterSouthTest() {
        assertEquals(Direction.S.getNextDirection(2), Direction.W);
    }

    @Test
    public void getDirectionAfterWestTest() {
        assertEquals(Direction.W.getNextDirection(3), Direction.N);
    }

    @Test
    public void getDirectionBeforeNorthTest() {
        assertEquals(Direction.N.getPreviousDirection(0), Direction.W);
    }

    @Test
    public void getDirectionBeforeEastTest() {
        assertEquals(Direction.E.getPreviousDirection(1), Direction.N);
    }

    @Test
    public void getDirectionBeforeSouthTest() {
        assertEquals(Direction.S.getPreviousDirection(2), Direction.E);
    }

    @Test
    public void getDirectionBeforeWestTest() {
        assertEquals(Direction.W.getPreviousDirection(3), Direction.S);
    }

    @Test
    public void directionExist() {
        assertTrue(Direction.N.exist(1));
    }

    @Test
    public void directionDoesntExist() {
        assertFalse(Direction.N.exist(4));
    }
}
