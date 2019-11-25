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
        assertEquals(model.getSquare(0), player.getType());
        assertEquals(model.getSquare(1), "");
    }

    @Test
    public void testWinConditionVertical1() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(0, player);
        model.fillSquare(3, player);
        assertFalse(model.checkWinCon(3, player));

        model.fillSquare(6, player);
        assertTrue(model.checkWinCon(6, player));

    }

    @Test
    public void testWinConditionVertical2() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(1, player);
        model.fillSquare(4, player);
        assertFalse(model.checkWinCon(4, player));

        model.fillSquare(7, player);
        assertTrue(model.checkWinCon(7, player));
    }

    @Test
    public void testWinConditionVertical3() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(2, player);
        model.fillSquare(5, player);
        assertFalse(model.checkWinCon(5, player));
        
        model.fillSquare(8, player);
        assertTrue(model.checkWinCon(8, player));
    }

    @Test
    public void testWinConditionHorizontal1() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(0, player);
        model.fillSquare(1, player);
        assertFalse(model.checkWinCon(1, player));
 
        model.fillSquare(2, player);
        assertTrue(model.checkWinCon(2, player));
    }

    @Test
    public void testWinConditionHorizontal2() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(3, player);
        model.fillSquare(4, player);
        assertFalse(model.checkWinCon(4, player));

        model.fillSquare(5, player);
        assertTrue(model.checkWinCon(5, player));
    }

    @Test
    public void testWinConditionHorizontal3() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(6, player);
        model.fillSquare(7, player);
        assertFalse(model.checkWinCon(7, player));
 
        model.fillSquare(8, player);
        assertTrue(model.checkWinCon(8, player));
    }

    @Test
    public void testWinConditionDiagnonal1() { //top left - bottom right
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(0, player);
        model.fillSquare(4, player);
        assertFalse(model.checkWinCon(4, player));
    
        model.fillSquare(8, player);
        assertTrue(model.checkWinCon(8, player));
    }

    @Test
    public void testWinConditionDiagnonal2() { //top right - bottom left
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(2, player);
        model.fillSquare(4, player);
        assertFalse(model.checkWinCon(4, player));
        
        model.fillSquare(6, player);
        assertTrue(model.checkWinCon(6, player));
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
