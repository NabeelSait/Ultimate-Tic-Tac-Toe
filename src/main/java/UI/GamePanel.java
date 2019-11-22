package UI;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

class GamePanel extends JPanel {
    private JButton[] _buttons = new JButton[9];
    private static int[] pos = new int[9];
    private int _boardID;
    private int _buttonID;

    GamePanel(EventBus bus, int boardID) {
        setLayout(new GridLayout(3, 3, 5, 5));
        _boardID = boardID;
        for (int i = 0; i < 9; i++) {
            _buttons[i] = new JButton();
            _buttons[i].setFont(new Font("Arial", Font.PLAIN, 7));
            add(_buttons[i]);
            _buttonID = i;
            _buttons[i].addActionListener(e -> bus.post(new Move(_boardID, _buttonID)));
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
            if (button.getText().equals("")) {
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

    public void undoMove(Move m)
    {
      for (int i = 0; i < 9; i++){
         if (i == m.getPosition()){
            _buttons[i].setIcon(null);
         }
      }
    }
}
