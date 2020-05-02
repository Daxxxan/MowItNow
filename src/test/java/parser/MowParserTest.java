package parser;

import com.mowitnow.enums.Direction;
import com.mowitnow.enums.Move;
import com.mowitnow.exception.InvalidFileContentException;
import com.mowitnow.exception.InvalidMowerInstructions;
import com.mowitnow.ground.Cell;
import com.mowitnow.mow.Mower;
import com.mowitnow.parser.MowParser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MowParserTest {
    private MowParser mowParser;
    private List<String> mowerInstructions;
    private List<String> secondMowerInstructions;
    private Mower firstMower;
    private Mower secondMower;

    @Before
    public void setUp() {
        mowParser = new MowParser();

        mowerInstructions = new ArrayList<>();
        mowerInstructions.add("5 5");
        mowerInstructions.add("1 2 N");
        mowerInstructions.add("GAGAGAGAA");
        mowerInstructions.add("3 3 E");
        mowerInstructions.add("AADAADADDA");

        secondMowerInstructions = new ArrayList<>();
        secondMowerInstructions.add("5 5");

        firstMower = new Mower();
        secondMower = new Mower();

        firstMower.setPosition(new Cell(1, 2));
        firstMower.setDirection(Direction.N);
        firstMower.setMowerMoves(new ArrayList<Move>(Arrays.asList(Move.G, Move.A, Move.G, Move.A, Move.G, Move.A, Move.G, Move.A, Move.A)));

        secondMower.setPosition(new Cell(3, 3));
        secondMower.setDirection(Direction.E);
        secondMower.setMowerMoves(new ArrayList<Move>(Arrays.asList(Move.A, Move.A, Move.D, Move.A, Move.A, Move.D, Move.A, Move.D, Move.D, Move.A)));
    }

    @Test
    public void shouldReturnTopRightCellTest() throws InvalidFileContentException {
        Cell cell = new Cell(5, 5);
        assertEquals(mowParser.getTopRightCell(mowerInstructions), cell);
    }

    @Test
    public void shouldThrowInvalidFileContentExceptionTest() {
        mowerInstructions.set(0, "55");
        Exception exception = assertThrows(InvalidFileContentException.class, () -> mowParser.getTopRightCell(mowerInstructions));

        assertTrue("The initial position is not valid.".contains(exception.getMessage()));
    }

    @Test
    public void shouldReturnTwoMowersTest() throws InvalidMowerInstructions {
        assertEquals(mowParser.getMowers(mowerInstructions).get(0), firstMower);
        assertEquals(mowParser.getMowers(mowerInstructions).get(1), secondMower);
    }

    @Test
    public void shouldThrowInvalidMowerInstructionsNoMowerInstructionsTest() {
        Exception exception = assertThrows(InvalidMowerInstructions.class, () -> mowParser.getMowers(secondMowerInstructions));

        assertTrue("No mower instructions".contains(exception.getMessage()));
    }

    @Test
    public void shouldThrowInvalidMowerInstructionsInvalidInitialPositionTest() {
        mowerInstructions.set(1, "E");
        Exception exception = assertThrows(InvalidMowerInstructions.class, () -> mowParser.getMowers(mowerInstructions));

        assertTrue("Invalid initial mower position".contains(exception.getMessage()));
    }

    @Test
    public void shouldThrowInvalidMowerInstructionsInvalidInitialDirectionTest() {
        mowerInstructions.set(1, "1 2 R");
        Exception exception = assertThrows(InvalidMowerInstructions.class, () -> mowParser.getMowers(mowerInstructions));

        assertTrue("Invalid initial direction".contains(exception.getMessage()));
    }

    @Test
    public void shouldThrowInvalidMowerInstructionsInvalidMovesTest() {
        mowerInstructions.set(2, "ADDAGATAA");
        Exception exception = assertThrows(InvalidMowerInstructions.class, () -> mowParser.getMowers(mowerInstructions));

        assertTrue("Invalid moves".contains(exception.getMessage()));
    }
}
