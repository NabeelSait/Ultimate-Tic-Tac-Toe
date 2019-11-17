package Model;

import org.junit.*;
import static org.junit.Assert.*;

public class TestGamePanelModel {

    @Test
    public void testConstructor() {
        GamePanelModel model = new GamePanelModel();
        assertTrue(model.open());
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
    public void testWinConditionVerticle1() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
        model.fillSquare(0, player);
        model.fillSquare(4, player);
        assertFalse(model.checkWinCon(4, player));

        model.fillSquare(7, player);
        assertTrue(model.checkWinCon(7, player));

    }

    @Test
    public void testWinConditionVerticle2() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
    }

    @Test
    public void testWinConditionVerticle3() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
    }

    @Test
    public void testWinConditionVHorizontal1() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
    }

    @Test
    public void testWinConditionVHorizontal2() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
    }

    @Test
    public void testWinConditionVHorizontal3() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
    }

    @Test
    public void testWinConditionVDiagnonal1() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
    }

    @Test
    public void testWinConditionVDiagnonal2() {
        GamePanelModel model = new GamePanelModel();
        Player player = new HumanPlayer("X", 0);
    }

}
