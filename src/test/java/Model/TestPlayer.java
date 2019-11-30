package Model;

import org.junit.*;
import static org.junit.Assert.*;

public class TestPlayer {
    @Test
    public void testHumanPlayerConstructor() {
        HumanPlayer player = new HumanPlayer("X", 1);
        assertEquals(player.getShape(), "X");
        assertNotEquals(player.getShape(), "O");

        assertEquals(player.get_id(), 1);
        assertNotEquals(player.get_id(), 2);
    }

    @Test
    public void testComputerPlayerConstructor() {
        ComputerPlayer player = new ComputerPlayer("X", 1);
        assertEquals(player.getShape(), "X");
        assertNotEquals(player.getShape(), "O");

        assertEquals(player.get_id(), 1);
        assertNotEquals(player.get_id(), 2);
    }
}
