import javax.swing.*;
import java.awt.*;

public class MenuPrototype extends JFrame
{
   public MenuPrototype()
   {
      setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();

      JTextField title = new JTextField("Ultimate Tic Tac Toe");
      title.setEditable(false);
      title.setFont(new Font("Serif", Font.BOLD, 20));
      title.setBorder(BorderFactory.createEmptyBorder());

      c.gridx = 0;
      c.gridy = 0;
      c.insets = new Insets(10,10,0,0);

      add(title,c);

      JButton vsCPU = new JButton("   Play Against a Computer   ");

      c.gridx = 0;
      c.gridy = 1;

      add(vsCPU, c);

      JButton vsP = new JButton("Play Against another Player");

      c.gridx = 0;
      c.gridy = 2;

      add(vsP, c);

      JButton replay = new JButton("           Watch a Replay           ");

      c.gridx = 0;
      c.gridy = 3;

      add(replay, c);

      setTitle("Menu");
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(400,400,300,300);
   }
}
