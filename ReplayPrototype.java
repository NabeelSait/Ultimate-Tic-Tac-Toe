import javax.swing.*;
import java.awt.*;

public class ReplayPrototype extends UIPrototype
{
   public ReplayPrototype()
   {
      super();

      JPanel bPanel = new JPanel();

      bPanel.setLayout(new BorderLayout());

      JButton nxtB = new JButton("Next Turn");
      JButton prevB = new JButton("Previous Turn");
      bPanel.add(prevB, BorderLayout.LINE_START);
      bPanel.add(nxtB, BorderLayout.LINE_END);

      GridBagConstraints c = new GridBagConstraints();
      c.gridx = 0;
      c.gridy = 2;
      add(bPanel, c);

      setTitle("Replay");
   }
}
