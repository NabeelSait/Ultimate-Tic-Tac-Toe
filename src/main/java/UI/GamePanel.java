package UI;

import Model.*;

import javax.swing.*;
import java.awt.*;

/**
 * An individual tic-tac-toe board UI
 */
class GamePanel extends JPanel {
    private JButton[] _buttons;
    private int _boardID;

    /**
     * Default Constrructor
     * @param boardID Which board this is, used to post move to EventBus
     */
    GamePanel(int boardID) {
        _buttons = new JButton[9];
        _boardID = boardID;
        setLayout(new GridLayout(3, 3, 5, 5));
        for (int i = 0; i < 9; i++) {
            _buttons[i] = new JButton();
            add(_buttons[i]);
            final int buttonID = i;
            _buttons[i].addActionListener(e -> Bus.getInstance().post(new Move(_boardID, buttonID)));
            setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
            setPreferredSize(new Dimension(130, 130));
        }
    }

    /**
     * Getter for Board ID
     * @return int BoardID 0-8
     */
    public int getBoardID() {
        return _boardID;
    }

    /**
     * Close the board by disabling all buttons
     */
    void closeBoard() {
        for (JButton button : _buttons) {
            button.setEnabled(false);
        }
    }

    /**
     * Open the board by enabling all button that are currently not occupied
     */
    void openBoard() {
        for (JButton button : _buttons) {
            if (button.getIcon() == null) {
                button.setEnabled(true);
            }
        }
    }

    /**
     * Fill the square with the player's shape
     * @param pos position to fill
     * @param player player to assign to pos
     */
    void fillSquare(int pos, Player player) {
        //TODO: Load these once for all boards instead of at every move
        Image img;
        if(player.getShape().compareTo("O") == 0) {
            img = new ImageIcon("./.icons/o.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        }
        else {
            img = new ImageIcon("./.icons/x.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        }
        _buttons[pos].setIcon(new ImageIcon(img));
        closeBoard();
    }

    /**
     * Undo a move
     * @param buttonID 0-8 pos to undo move
     */
    void undoMove(int buttonID)
    {
        _buttons[buttonID].setIcon(null);
    }
}
