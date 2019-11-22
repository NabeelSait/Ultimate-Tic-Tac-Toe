package UI;

import com.google.common.eventbus.EventBus;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class GameScreen extends JPanel {
    private JTextField _statusBar;
    private EventBus _bus;
    private JButton _forfeitButton;
    private GameBoard _gameBoard;

    GameScreen(EventBus bus, boolean isComputer) {
        _bus = bus;

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        _statusBar = new JTextField("Player 1's Turn");
        _statusBar.setEditable(false);
        _statusBar.setBorder(new EmptyBorder(15, 5, 15, 5));
        _statusBar.setFont(new Font("Verdana",Font.PLAIN,25));
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10,10,0,0);
        c.anchor = GridBagConstraints.PAGE_START;
        add(_statusBar, c);

        _gameBoard = new GameBoard(bus, isComputer);
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        add(_gameBoard, c);

        _forfeitButton = new JButton("Forfeit");
        _forfeitButton.addActionListener(e -> _bus.post(_forfeitButton));
        c.gridy = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(20,0,0,0);
        add(_forfeitButton, c);
    }
}
