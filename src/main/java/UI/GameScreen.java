package UI;

import Model.EndGameEvent;
import Model.Player;
import com.google.common.eventbus.Subscribe;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

/**
 * Screen container
 */
class GameScreen extends JPanel {
    private JTextField _statusBar;
    private boolean _computerPlayer;
    private JButton _forfeitButton;
    private GameBoard _gameBoard;

    /**
     * Basic Constructor
     * @param computerPlayer denotes if a computer player is required
     */
    GameScreen(boolean computerPlayer) {
        _computerPlayer = computerPlayer;

        // Register with EventBus to use it
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

        _gameBoard = new GameBoard(_computerPlayer);
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        add(_gameBoard, c);

        _forfeitButton = new JButton("Forfeit");
        _forfeitButton.addActionListener(e -> Bus.getInstance().post(_forfeitButton));
        c.gridy = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        c.insets = new Insets(20,0,0,0);
        add(_forfeitButton, c);
    }

    /**
     * Listen for a button event to toggle the statusbar's text
     * @param player Player whose turn it is
     */
    @Subscribe
    public void buttonEvent(Player player) {
        if(!_computerPlayer)
            _statusBar.setText("Player " + player.get_id() + "'s turn");
    }

    /**
     * Listen for an EndGameEvent to be posted to EventBus
     * Save a replay, offer to return to menu
     * @param e EndGameEvent
     * @throws IOException unable to create, write into, or save file. Shouldn't happen unless rwx attributes were
     * externally set
     */
    @Subscribe
    public void endGameEvent(EndGameEvent e) throws IOException{
        if (e.getWinner().get_id() == 1) {
            _statusBar.setText("You won!");
        }
        if (e.getWinner().get_id() == 2) {
            _statusBar.setText("You lose!");
        }

        else {
            _statusBar.setText("Tie!");
        }
        _forfeitButton.setText("Return to Main Menu");
        FileManager.saveReplay(_gameBoard.getMoveList());
    }
}
