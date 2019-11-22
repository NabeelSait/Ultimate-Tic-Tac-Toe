package UI;

import javax.swing.*;
import java.awt.*;

import Model.*;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

class GameBoard extends JPanel {
    private GamePanel[] _boards;
    private GameBoardModel _model;
    private Player _player1, _player2, _activePlayer;

    GameBoard(EventBus e) {
        e.register(this);
        setLayout(new GridLayout(3, 3, 10, 10));
        _player1 = new HumanPlayer("X", 1);
        _player2 = new HumanPlayer("O", 2);
        _activePlayer = _player1;
        _boards = new GamePanel[9];
        _model = new GameBoardModel(e, _player1, _player2);
        for (int i = 0; i < 9; i++) {
            _boards[i] = new GamePanel(e, i);
            add(_boards[i]);
        }
        _model = new GameBoardModel(e, _player1, _player2);
    }

    void closeAllBoards() {
        for (GamePanel board : _boards) {
            board.closeBoard();
        }
    }

    void closeBoard(int board) {
        _boards[board].closeBoard();
    }

    private void endTurn() {
        if (_activePlayer == _player1) {
            _activePlayer = _player2;
        } else {
            _activePlayer = _player1;
        }
    }

    public void undoMove(Move prev, Move pprev)
    {
      for (int i = 0; i < 9; i++) {
          if (i == pprev.getPosition()) {
              _boards[i].openBoard();
          }
          if (i == prev.getPosition()){
             _boards[i].closeBoard();
          }
          if (i == prev.getBoard()){
             _boards[i].undoMove(prev);
          }
      }

    }

    @Subscribe
    void buttonEvent(Move m) {
      System.out.println("Got here");
        if (!_model.checkClosed(m)) {
            for (int i = 0; i < 9; i++) {
                if (i == m.getPosition()) {
                    _boards[i].openBoard();
                } else {
                    _boards[i].closeBoard();
                }
            }
        } else {
            for (int i = 0; i < 9; i++) {
                if (i == m.getPosition()) {
                    _boards[i].closeBoard();
                } else {
                    _boards[i].openBoard();
                }
            }
        }
        _model.fillSquare(m, _activePlayer);
        _boards[m.getBoard()].fillSquare(m.getPosition(), _activePlayer);
        endTurn();
    }
}
