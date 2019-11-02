import javax.swing.*;
import java.awt.*;

public class ReplayPrototype extends UIPrototype
{
   JPanel bPanel;
   JButton nxtB, prevB;
   public ReplayPrototype()
   {
      super();

      bPanel = new JPanel();

      bPanel.setLayout(new BorderLayout());

      nxtB = new JButton("Next Turn");
      prevB = new JButton("Previous Turn");
      bPanel.add(prevB, BorderLayout.LINE_START);
      bPanel.add(nxtB, BorderLayout.LINE_END);

      GridBagConstraints c = new GridBagConstraints();
      c.gridx = 0;
      c.gridy = 2;
      remove(fButton);
      add(bPanel, c);

      setTitle("Replay");
   }
}
