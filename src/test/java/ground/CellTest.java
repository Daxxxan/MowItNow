package ground;

import com.mowitnow.ground.Cell;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CellTest {
    private Cell cell;

    @Before
    public void setUp() {
        cell = new Cell(4, 8);
    }

    @Test
    public void getXTest() {
        assertEquals(cell.getX(), 4);
    }

    @Test
    public void getYTest() {
        assertEquals(cell.getY(), 8);
    }

    @Test
    public void setXTest() {
        cell.setX(1);
        assertEquals(cell.getX(), 1);
    }

    @Test
    public void setYTest() {
        cell.setY(3);
        assertEquals(cell.getY(), 3);
    }
}
