import javax.swing.*;
import java.awt.*;

public class UIPrototype extends JFrame
{
    JTextField statusBar;
    JButton fButton;

    public UIPrototype()
    {
      setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();
      GameBoard gB = new GameBoard();

      c.gridx = 0;
      c.gridy = 0;
      c.anchor = GridBagConstraints.NORTHWEST;
      add(gB,c);

      statusBar=new JTextField("Player1's Turn");
      statusBar.setEditable(false);
      c.gridx = 0;
      c.gridy = 1;
      c.anchor = GridBagConstraints.CENTER;
      add(statusBar,c);

      fButton = new JButton("Forfeit");
      c.gridx = 0;
      c.gridy = 2;
      add(fButton, c);

      setTitle("Ultimate Tic Tac Toe");
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(500,500,400,400);
    }

    public class GamePanel extends JPanel
    {
        JButton [][] buttons= new JButton[3][3];
        public GamePanel()
        {
            setLayout(new GridLayout(3,3));
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    buttons[i][j]=new JButton();
                    add(buttons[i][j]);
                }
             }
             setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.black));
             setPreferredSize(new Dimension(100,100));
         }
    }
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
}