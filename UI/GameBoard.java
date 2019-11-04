import javax.swing.*;
import java.awt.*; 
public class GameBoard extends JPanel
    {
      GamePanel topLeft, topMid, topRight, midLeft, midMid, midRight, botLeft, botMid, botRight;
      public GameBoard()
      {
         setLayout(new GridLayout(3,3,0,0));

         topLeft = new GamePanel();
         add(topLeft);

         topMid = new GamePanel();
         add(topMid);

         topRight = new GamePanel();
         add(topRight);

         midLeft = new GamePanel();
         add(midLeft);

         midMid = new GamePanel();
         add(midMid);

         midRight = new GamePanel();
         add(midRight);

         botLeft = new GamePanel();
         add(botLeft);

         botMid = new GamePanel();
         add(botMid);

         botRight = new GamePanel();
         add(botRight);
      }
    }
