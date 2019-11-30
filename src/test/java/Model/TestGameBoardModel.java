package Model;

import org.junit.*;
import static org.junit.Assert.*;

public class TestGameBoardModel {

   @Test
   public void testGameBoardModelConstructor()
   {
      Player p1 = new HumanPlayer("X", 1);
      Player p2 = new HumanPlayer("O", 2);
      GameBoardModel model = new GameBoardModel(p1, p2);
      assertEquals(model.getPanelsFilled(), 0);


   }

   @Test
   public void testCheckWinCon1() //One player reaches 5
   {
      Player p1 = new HumanPlayer("X", 1);
      Player p2 = new HumanPlayer("O", 2);
      GameBoardModel model = new GameBoardModel(p1, p2);
      p1.score = 5;
      assertTrue(model.checkWinCon(p1));


   }

   @Test
   public void testCheckWinCon2() //Game over one player has higher score
   {
      Player p1 = new HumanPlayer("X", 1);
      Player p2 = new HumanPlayer("O", 2);
      GameBoardModel model = new GameBoardModel(p1, p2);
      model.setPanelsFilled();
      p1.score = 3;
      p2.score = 2;
      assertTrue(model.checkWinCon(p1));

   }

   @Test
   public void testCheckWinCon3() //Meets no 'win' consditions, but will end the game. Should return true.
   {
      Player p1 = new HumanPlayer("X", 1);
      Player p2 = new HumanPlayer("O", 2);
      p1.score = 3;
      p2.score = 3;
      GameBoardModel model = new GameBoardModel(p1, p2);
      model.setPanelsFilled();
      assertTrue(model.checkWinCon(p1));

   }


   @Test
   public void testFillSquare1() //One square filled, panel should still be open
   {
      Player p1 = new HumanPlayer("X", 1);
      Player p2 = new HumanPlayer("O", 2);
      GameBoardModel model = new GameBoardModel(p1, p2);
      Move mv1 = new Move(0, 0);
      model.fillSquare(mv1, p1);
      assertTrue(model.isOpen(mv1.getBoard()));
   }

   //Note that testing for a closed panel assumes panel.checkWinCon(...) works

   @Test
   public void TestCheckClosed()
   {
      Player p1 = new HumanPlayer("X", 1);
      Player p2 = new HumanPlayer("O", 2);
      GameBoardModel model = new GameBoardModel(p1, p2);
      Move mv1 = new Move(0, 0);
      Move mv2 = new Move(0, 1);
      Move mv3 = new Move(0, 2);
      model.fillSquare(mv1, p1);
      model.fillSquare(mv2, p1);
      model.fillSquare(mv3, p1);
      assertFalse(model.isOpen(mv1.getPosition()));
   }

   @Test
   public void TestGetMoveList() //prob didn't need this
   {
      Player p1 = new HumanPlayer("X", 1);
      Player p2 = new HumanPlayer("O", 2);
      GameBoardModel model = new GameBoardModel(p1, p2);
      Move mv1 = new Move(0, 0);
      model.fillSquare(mv1, p1);
      assertTrue(model.getMoveList().contains(mv1));
   }











} //end class
