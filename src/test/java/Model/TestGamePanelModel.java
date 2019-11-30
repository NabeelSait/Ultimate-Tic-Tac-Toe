package Model;

import org.junit.*;
import static org.junit.Assert.*;

public class TestGamePanelModel {

    @Test
    public void testConstructor() {
        GamePanelModel model = new GamePanelModel();
        assertTrue(model.isOpen());
    }

    @Test
    public void testFillSquare() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(0, player);
        assertEquals(model.getSquare(0), player.getShape());
        assertEquals(model.getSquare(1), "");
    }

    @Test
    public void testWinConditionVertical1() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(0, player);
        model.fillSquare(3, player);
        assertNotEquals(player, model.getWinner());

        model.fillSquare(6, player);
        assertEquals(player, model.getWinner());
    }

    @Test
    public void testWinConditionVertical2() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(1, player);
        model.fillSquare(4, player);
        assertNotEquals(player, model.getWinner());

        model.fillSquare(7, player);
        assertEquals(player, model.getWinner());
    }

    @Test
    public void testWinConditionVertical3() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(2, player);
        model.fillSquare(5, player);
        assertNotEquals(player, model.getWinner());
        
        model.fillSquare(8, player);
        assertEquals(player, model.getWinner());
    }

    @Test
    public void testWinConditionHorizontal1() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(0, player);
        model.fillSquare(1, player);
        assertNotEquals(player, model.getWinner());
 
        model.fillSquare(2, player);
        assertEquals(player, model.getWinner());
    }

    @Test
    public void testWinConditionHorizontal2() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(3, player);
        model.fillSquare(4, player);
        assertNotEquals(player, model.getWinner());

        model.fillSquare(5, player);
        assertEquals(player, model.getWinner());
    }

    @Test
    public void testWinConditionHorizontal3() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(6, player);
        model.fillSquare(7, player);
        assertNotEquals(player, model.getWinner());
 
        model.fillSquare(8, player);
        assertEquals(player, model.getWinner());
    }

    @Test
    public void testWinConditionDiagnonal1() { //top left - bottom right
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(0, player);
        model.fillSquare(4, player);
        assertNotEquals(player, model.getWinner());
    
        model.fillSquare(8, player);
        assertEquals(player, model.getWinner());
    }

    @Test
    public void testWinConditionDiagnonal2() { //top right - bottom left
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(2, player);
        model.fillSquare(4, player);
        assertNotEquals(player, model.getWinner());
        
        model.fillSquare(6, player);
        assertEquals(player, model.getWinner());
    }

    @Test
    public void checkTie() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        for (int i = 0; i<9; i++)
        {
           model.fillSquare(i, player);
        }

        assertEquals(model.getSquaresFilled(), 9);
    } 

}
