package UI;

import Model.EndGameEvent;
import Model.Player;
import com.google.common.eventbus.Subscribe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class GameScreen extends JPanel {
    private JTextField _statusBar;
    private boolean _computerPlayer;
    private JButton _forfeitButton;

    GameScreen(boolean computerPlayer) {
        _computerPlayer = computerPlayer;
        Bus.getInstance().register(this);

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        if(_computerPlayer) {
            _statusBar = new JTextField("");
        }
        else {
            _statusBar = new JTextField("Player 1's Turn");
        }
        _statusBar.setEditable(false);
        _statusBar.setBorder(new EmptyBorder(15, 5, 15, 5));
        _statusBar.setFont(new Font("Verdana",Font.PLAIN,25));
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10,10,0,0);
        c.anchor = GridBagConstraints.PAGE_START;
        add(_statusBar, c);

        GameBoard gameBoard = new GameBoard(_computerPlayer);
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        add(gameBoard, c);

        _forfeitButton = new JButton("Forfeit");
        _forfeitButton.addActionListener(e -> Bus.getInstance().post(_forfeitButton));
        c.gridy = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(20,0,0,0);
        add(_forfeitButton, c);
    }

    @Subscribe
    public void buttonEvent(Player player) {
        if(!_computerPlayer)
        _statusBar.setText("Player " + player.getNumber() + "'s turn");
    }

    @Subscribe
    public void endGameEvent(EndGameEvent e) {
        if(e.getWinner().getNumber() != 3) {
            _statusBar.setText("Player " + e.getWinner().getNumber() + " has won!");
        }
        else {
            _statusBar.setText("Tie!");
        }
        _forfeitButton.setText("Return to Main Menu");
    }
}
