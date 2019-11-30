package UI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import Model.*;
import com.google.common.eventbus.Subscribe;

/**
 * The GameBoard - 9 tic-tac-toe boards
 */
class GameBoard extends JPanel {
    private GamePanel[] _boards;
    private GameBoardModel _model;
    private Player _player1, _player2, _activePlayer;
    private boolean _hasComputer;

    /**
     * Basic constructor
     * @param hasComputerPlayer denotes whether to create a computer player
     */
    GameBoard(boolean hasComputerPlayer) {
        // Register with EventBus to post events
        Bus.getInstance().register(this);

        setLayout(new GridLayout(3, 3, 10, 10));

        // Create the players
        _player1 = new HumanPlayer("X", 1);
        if (hasComputerPlayer) {
            _player2 = new ComputerPlayer("O", 2);
            _hasComputer = true;
        } else {
            _player2 = new HumanPlayer("O", 2);
        }
        _activePlayer = _player1;

        // Create the boards
        _boards = new GamePanel[9];
        _model = new GameBoardModel(_player1, _player2);
        for (int i = 0; i < 9; i++) {
            _boards[i] = new GamePanel(i);
            add(_boards[i]);
        }
    }

    /**
     * Close every board from being played on
     */
    void closeAllBoards() {
        _model.closeAllBoards();
        for (GamePanel board : _boards) {
            board.closeBoard();
        }
    }

    /**
     * Try and open every board
     */
    private void openAllBoards() {
        for (int i = 0; i < _boards.length; i++) {
            if(!_model.isWonOrFull(i)) {
                _boards[i].openBoard();
                _model.openBoard(i);
            }
        }
    }

    /**
     * End the current player's turn
     */
    private void endTurn() {
        // Toggle _activePlayer
        if (_activePlayer == _player1) {
            _activePlayer = _player2;
            // Send the current model over the EventBus to trigger a move to be made by the computer player
            if(_hasComputer) {
                Bus.getInstance().post(_model);
            }
        } else {
            _activePlayer = _player1;
        }
    }

    /**
     * Apply a move to the GameBoard
     * Used by replay screen
     * Note: The model does not need to be updated
     * @param move Move to be applied
     */
    void stepMove(Move move) {
        _boards[move.getBoard()].fillSquare(move.getPosition(), _activePlayer);
        endTurn();
    }

    /**
     * Revert a move
     * Note: The model does not need to be updated
     * @param prev Previous move to un-apply
     */
    void undoMove(Move prev) {
        _boards[prev.getBoard()].undoMove(prev.getPosition());
    }

    /**
     * Get the move list from the current game
     * @return Array list of sequential moves that have been played so far
     */
    ArrayList<Move> getMoveList(){
        return _model.getMoveList();
   }

    /**
     * EventBus listener for a Move
     * @param m Move that was just played
     */
    @Subscribe
    public void buttonEvent(Move m) {
        _model.fillSquare(m, _activePlayer);
        _boards[m.getBoard()].fillSquare(m.getPosition(), _activePlayer);

        if(_model.checkWinCon(_activePlayer)) {
            Bus.getInstance().unregister(this);
            closeAllBoards();
            return;
        }

        // Is the board that the player was sent to already closed
        if (_model.isWonOrFull(m.getPosition())) {
            openAllBoards();
            _boards[m.getPosition()].closeBoard();
            _model.closeBoard(m.getPosition());
        } else {
            closeAllBoards();
            _boards[m.getPosition()].openBoard();
            _model.openBoard(m.getPosition());
        }

        endTurn();
        Bus.getInstance().post(_activePlayer);
    }
}
