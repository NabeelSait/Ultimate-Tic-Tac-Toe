package UI;

import javax.swing.*;
import java.awt.*;

class GamePanel extends JPanel {
    private JButton[] _buttons = new JButton[9];

    GamePanel() {
        setLayout(new GridLayout(3, 3, 5, 5));
        for (JButton button : _buttons) {
            button = new JButton();
            add(button);
        }
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        setPreferredSize(new Dimension(200, 200));
    }
}


