package UI;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

class GamePanel extends JPanel {
    private JButton[] _buttons = new JButton[9];
    private static int pos[] = new int[9];
    private int _boardID;
    private int _buttonID;

    GamePanel(EventBus bus, int boardID) {
        setLayout(new GridLayout(3, 3, 5, 5));
        _boardID = boardID;
        for (int i = 0; i < 9; i++) {
            _buttons[i] = new JButton();
            add(_buttons[i]);
            _buttonID = i;
            _buttons[i].addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e)
               {
                  Move m = new Move(_boardID, _buttonID);
                  bus.post(m);
               }
            });
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        setPreferredSize(new Dimension(200, 200));
    }
  }

   public int getBoardID()
   {
      return _boardID;
   }

   public void closeBoard()
   {
      for (int i = 0; i < 9; i++)
      {
         _buttons[i].setEnabled(false);
      }

    }

    public void openBoard()
    {
      for (int i = 0; i < 9; i++)
      {
         if (_buttons[i].getText() == "")
         {
            _buttons[i].setEnabled(true);
         }
      }
     }

     public void fillSquare(Player player, int pos)
     {
        _buttons[pos].setText(String.valueOf(player.getType()));
        _buttons[pos].setForeground(Color.BLACK);
        _buttons[pos].setEnabled(false);
     }
}
