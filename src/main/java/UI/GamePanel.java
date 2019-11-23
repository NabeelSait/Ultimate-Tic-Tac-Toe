package UI;

import Model.*;

import javax.swing.*;
import java.awt.*;

class GamePanel extends JPanel {
    private JButton[] _buttons = new JButton[9];
    private int _boardID;

    GamePanel(int boardID) {
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

    public int getBoardID() {
        return _boardID;
    }

    void closeBoard() {
        for (JButton button : _buttons) {
            button.setEnabled(false);
        }
    }

    void openBoard() {
        for (JButton button : _buttons) {
            if (button.getIcon() == null) {
                button.setEnabled(true);
            }
        }
    }

    void fillSquare(int pos, Player player) {
        //TODO: Load these once for all boards instead of at every move
        Image img;
        if(player.getType().compareTo("O") == 0) {
            img = new ImageIcon("./.icons/o.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        }
        else {
            img = new ImageIcon("./.icons/x.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        }
        _buttons[pos].setIcon(new ImageIcon(img));
        closeBoard();
    }

    void undoMove(Move m)
    {
      for (int i = 0; i < 9; i++){
         if (i == m.getPosition()){
            _buttons[i].setIcon(null);
         }
      }
    }
}
