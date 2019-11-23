package UI;

import javax.swing.*;
import java.awt.*;

import Model.*;
import com.google.common.eventbus.Subscribe;

class GameBoard extends JPanel {
    private GamePanel[] _boards;
    private GameBoardModel _model;
    private Player _player1, _player2, _activePlayer;

    GameBoard(boolean isComputer) {
        Bus.getInstance().register(this);
        setLayout(new GridLayout(3, 3, 10, 10));
        _player1 = new HumanPlayer("X", 1);
        if (isComputer) {
            _player2 = new ComputerPlayer("O", 2);
        } else {
            _player2 = new HumanPlayer("O", 2);
        }

        _activePlayer = _player1;
        _boards = new GamePanel[9];
        _model = new GameBoardModel(_player1, _player2);
        for (int i = 0; i < 9; i++) {
            _boards[i] = new GamePanel(i);
            add(_boards[i]);
        }
        _model = new GameBoardModel(_player1, _player2);
    }

    void closeAllBoards() {
        for (GamePanel board : _boards) {
            board.closeBoard();
        }
    }

    private void openAllBoards() {
        for (int i = 0; i < _boards.length; i++) {
            if (_model.boardOpen(i)) {
                _boards[i].openBoard();
            }
        }
    }

    private void endTurn() {
        if (_activePlayer == _player1) {
            _activePlayer = _player2;
        } else {
            _activePlayer = _player1;
        }
    }

    void stepMove(Move move) {
        _model.fillSquare(move, _activePlayer);
        _boards[move.getBoard()].fillSquare(move.getPosition(), _activePlayer);
        endTurn();
    }

    void undoMove(Move prev) {
        for (int i = 0; i < 9; i++) {
            if (i == prev.getBoard()) {
                _boards[i].undoMove(prev);
            }
        }
    }

    @Subscribe
    public void buttonEvent(final Move m) {
        _model.fillSquare(m, _activePlayer);
        _boards[m.getBoard()].fillSquare(m.getPosition(), _activePlayer);

        // Is the board that the player was sent to already closed
        if (_model.isClosed(m)) {
            openAllBoards();
            _boards[m.getPosition()].closeBoard();
        } else {
            closeAllBoards();
            _boards[m.getPosition()].openBoard();
        }
        endTurn();
    }
}
