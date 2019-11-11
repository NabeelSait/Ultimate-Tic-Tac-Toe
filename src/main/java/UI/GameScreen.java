package UI;

import com.google.common.eventbus.EventBus;

import javax.swing.*;
import java.awt.*;

class GameScreen extends JPanel {
    private JTextField _statusBar;
    private EventBus _bus;
    private JButton forfeitButton;

    GameScreen(EventBus bus) {
        _bus = bus;
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        GameBoard _gameBoard = new GameBoard();

        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        add(_gameBoard, c);

        _statusBar = new JTextField("Player1's Turn");
        _statusBar.setEditable(false);
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        add(_statusBar, c);

        forfeitButton = new JButton("Forfeit");
        forfeitButton.addActionListener(e -> _bus.post(forfeitButton));
        c.gridx = 0;
        c.gridy = 2;
        add(forfeitButton, c);
    }
}
