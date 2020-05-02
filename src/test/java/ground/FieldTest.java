package ground;

import com.mowitnow.ground.Cell;
import com.mowitnow.ground.Field;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FieldTest {
    private Field field;

    @Before
    public void setUp() {
        Cell cell = new Cell(5, 5);
        field = new Field(cell);
    }

    @Test
    public void iShouldGoNorthTest() {
        assertTrue(field.canIGoNorth(2));
    }

    @Test
    public void iShouldNotGoNorthTest() {
        assertFalse(field.canIGoNorth(5));
    }

    @Test
    public void iShouldGoWestTest() {
        assertTrue(field.canIGoWest(2));
    }

    @Test
    public void iShouldNotGoWestTest() {
        assertFalse(field.canIGoWest(0));
    }

    @Test
    public void iShouldGoSouthTest() {
        assertTrue(field.canIGoSouth(2));
    }

    @Test
    public void iShouldNotGoSouthTest() {
        assertFalse(field.canIGoSouth(0));
    }

    @Test
    public void iShouldGoEastTest() {
        assertTrue(field.canIGoEast(2));
    }

    @Test
    public void iShouldNotGoEastTest() {
        assertFalse(field.canIGoEast(5));
    }
}
