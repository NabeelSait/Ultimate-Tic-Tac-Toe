package UI;

import javax.swing.*;
import java.awt.*;

import Model.*;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class GameBoard extends JPanel {
    private GamePanel[] _boards;
    private GameBoardModel _model;
    private Player _player1, _player2, _Activeplayer;

    public GameBoard(EventBus e) {
        setLayout(new GridLayout(3, 3, 10, 10));
        _player1 = new HumanPlayer('X',1);
        _player2 = new HumanPlayer('O', 2);
        _Activeplayer = _player1;
        GamePanel[] _boards = new GamePanel[9];
        for (int i = 0; i < 9; i++) {
            _boards[i] = new GamePanel(e, i);
            add(_boards[i]);
        }
    }

    @Subscribe
    public void buttonEvent(Move m)
    {
      for (int i= 0; i < 9; i++)
      {
         if (i == m.getBoard())
         {
            _boards[i].openBoard();
         }
         else
         {
            _boards[i].closeBoard();
         }
      }
      _model.fillSquare(m, _Activeplayer);
      if (_Activeplayer == _player1)
      {
         _Activeplayer = _player2;
      }
      else
      {
         _Activeplayer = _player1;
      }
    }
}
