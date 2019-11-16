package UI;

import com.google.common.eventbus.EventBus;

import javax.swing.*;
import java.awt.*;

class Menu extends JPanel {
   private EventBus _bus;

   Menu(EventBus bus) {
      _bus = bus;

      setLayout(new GridBagLayout());
      GridBagConstraints c = new GridBagConstraints();
      setPreferredSize(new Dimension(600, 600));

      JTextField title = new JTextField("Ultimate Tic Tac Toe");
      title.setEditable(false);
      title.setFont(new Font("Serif", Font.BOLD, 20));
      title.setBorder(BorderFactory.createEmptyBorder());

      c.gridx = 0;
      c.gridy = 0;
      c.insets = new Insets(10,10,0,0);

      add(title,c);

      final JButton vsCPU = new JButton("   Play Against a Computer   ");
      vsCPU.addActionListener(e -> _bus.post(vsCPU));

      c.gridx = 0;
      c.gridy = 1;

      add(vsCPU, c);

      final JButton vsP = new JButton("Play Against another Player");
      vsP.addActionListener(e -> _bus.post(vsP));

      c.gridx = 0;
      c.gridy = 2;

      add(vsP, c);

      final JButton replay = new JButton("           Watch a Replay           ");
      replay.addActionListener(e -> _bus.post(replay));

      c.gridx = 0;
      c.gridy = 3;

      add(replay, c);
   }
}
