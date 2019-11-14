package src.test.java.Model;

import Model.ComputerPlayer;
import Model.HumanPlayer;
import org.junit.*;
import static org.junit.Assert.*;

public class TestPlayer {
    @Test
    public void testHumanPlayerConstructor() {
        HumanPlayer player = new HumanPlayer('x', 1);
        assertEquals(player.getType(), 'x');
        assertNotEquals(player.getType(), 'o');

        assertEquals(player.getNumber(), 1);
        assertNotEquals(player.getNumber(), 2);
    }

    @Test
    public void testComputerPlayerConstructor() {
        ComputerPlayer player = new ComputerPlayer('x', 1);
        assertEquals(player.getType(), 'x');
        assertNotEquals(player.getType(), 'o');

        assertEquals(player.getNumber(), 1);
        assertNotEquals(player.getNumber(), 2);
    }

    @Test
    public void testHumanPlayerName() {
        HumanPlayer player = new HumanPlayer('x', 1);
        player.setName("Mike");
        assertEquals(player.getName(), "Mike");
        assertNotEquals(player.getName(), "Kim");
    }
}
