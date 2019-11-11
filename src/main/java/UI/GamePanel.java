package UI;

import javax.swing.*;
import java.awt.*;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

class GamePanel extends JPanel {
    private JButton[] _buttons = new JButton[9];
    private int _boardID;

    GamePanel(Eventbus e, int boardID) {
        setLayout(new GridLayout(3, 3, 5, 5));
        _boardID = boardID;
        for (JButton button : _buttons) {
            button = new JButton();
            add(button);
            button.addActionListener (e -> _bus.post(button))
        }
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        setPreferredSize(new Dimension(200, 200));
    }

    public int getBoardID()
    {
      return _boardID;
   }
}
