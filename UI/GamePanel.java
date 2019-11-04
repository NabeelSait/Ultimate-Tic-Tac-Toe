import javax.swing.*;
import java.awt.*;

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
    

