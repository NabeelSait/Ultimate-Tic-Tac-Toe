import javax.swing.*;
import java.awt.*;

public class UIPrototype extends JFrame
{
    JButton [][] buttons= new JButton[3][3];
    JTextField statusBar;
    Integer turn;
    Integer count;

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

      setTitle("Tic Tac Toe");
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(500,500,400,400);
    }

    public class GamePanel extends JPanel
    {
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
      public GameBoard()
      {
         setLayout(new GridLayout(3,3,0,0));

         GamePanel topLeft = new GamePanel();
         add(topLeft);

         GamePanel topMid = new GamePanel();
         add(topMid);

         GamePanel topRight = new GamePanel();
         add(topRight);

         GamePanel midLeft = new GamePanel();
         add(midLeft);

         GamePanel midMid = new GamePanel();
         add(midMid);

         GamePanel midRight = new GamePanel();
         add(midRight);

         GamePanel botLeft = new GamePanel();
         add(botLeft);

         GamePanel botMid = new GamePanel();
         add(botMid);

         GamePanel botRight = new GamePanel();
         add(botRight);
      }
    }
}
