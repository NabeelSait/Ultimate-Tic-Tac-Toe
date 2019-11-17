package Model;

import org.junit.*;
import static org.junit.Assert.*;
import java.io.File;

public class TestReplayer {
    @Test
    public void testConstructor() {
        File replayFile = new File("./src/test/java/Model/test_replays/replay1.txt");
        Replayer replayer = new Replayer(replayFile);
        assertEquals(replayer.getTotalMoves(), 4);
    }

    @Test
    public void testHasNext() {
        File replayFile = new File("./src/test/java/Model/test_replays/replay1.txt");
        Replayer replayer = new Replayer(replayFile);

        assertTrue(replayer.hasNextMove());
    }

    @Test
    public void testHasPrev() {
        File replayFile = new File("./src/test/java/Model/test_replays/replay1.txt");
        Replayer replayer = new Replayer(replayFile);

        replayer.nextMove();
        assertTrue(replayer.hasPrevMove());
    }

    @Test
    public void testNextMove() {
        File replayFile = new File("./src/test/java/Model/test_replays/replay1.txt");
        Replayer replayer = new Replayer(replayFile);

        Move nextMove = replayer.nextMove();
        assertEquals(nextMove.getBoard(), 0);
        assertEquals(nextMove.getPosition(), 0);
        assertTrue(replayer.hasNextMove());
        assertTrue(replayer.hasPrevMove());
    }

    @Test
    public void testPrevMove() {
        File replayFile = new File("./src/test/java/Model/test_replays/replay1.txt");
        Replayer replayer = new Replayer(replayFile);

        replayer.nextMove();
        Move nextMove = replayer.previousMove();
        assertEquals(nextMove.getBoard(), 0);
        assertEquals(nextMove.getPosition(), 0);
        assertTrue(replayer.hasNextMove());
        assertFalse(replayer.hasPrevMove());
    }

}
