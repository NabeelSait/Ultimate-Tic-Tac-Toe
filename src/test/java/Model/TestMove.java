package Model;

import org.junit.*;
import static org.junit.Assert.*;

public class TestMove {

    @Test
    public void testConstructor() {
        Move move = new Move(4, 5);
        assertEquals(move.getBoard(), 4);
        assertEquals(move.getPosition(), 5);
    }
}
