package UI;

import Model.GamePanelModel;

import javax.swing.*;
import java.awt.*;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

class GamePanel extends JPanel {
    private JButton[] _buttons = new JButton[9];
    private int _boardID;

    GamePanel(EventBus bus, int boardID) {
        setLayout(new GridLayout(3, 3, 5, 5));
        _boardID = boardID;
        for (JButton button : _buttons) {
            button = new JButton();
            add(button);
            JButton finalButton = button;
            button.addActionListener (e -> bus.post(finalButton));
        }
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        setPreferredSize(new Dimension(200, 200));
    }

    public int getBoardID()
    {
      return _boardID;
   }
}
