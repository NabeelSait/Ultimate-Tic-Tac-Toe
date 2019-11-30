package Model;

import UI.Bus;

import java.util.ArrayList;

/**
 * Model for the GameBoard
 */
public class GameBoardModel {
    // Fixed size list of each panel
    private GamePanelModel[] _panels;

    // History of the Game
    private ArrayList<Move> _moveList;

    private Player _player1, _player2;

    // Used for end game condition
    private int _panelsFilled;

    /**
     * Initialize the stuff
     * @param p1 Player 1
     * @param p2 Player 2
     */
    public GameBoardModel(Player p1, Player p2) {
        // Create and populate the panel models
        _panels = new GamePanelModel[9];
        for (int i = 0; i < 9; i++) {
            _panels[i] = new GamePanelModel();
        }

        // Set other member variables to appropriate values
        _panelsFilled = 0;
        _player1 = p1;
        _player2 = p2;
        _moveList = new ArrayList<>();
    }

    /**
     * Check if a particular player has won
     * @param player Player to check if the won
     * @return true if player has won, false otherwise
     */
    public boolean checkWinCon(Player player){
        if (player.score >= 5) {
            Bus.getInstance().post(new EndGameEvent(player));
            return true;
        } else if (_panelsFilled == 9) {
            if (_player1.score > _player2.score) {
                Bus.getInstance().post(new EndGameEvent(_player1));
                return true;
            } else if (_player2.score > _player1.score) {
                Bus.getInstance().post(new EndGameEvent(_player2));
                return true;
            }
            else {
                Bus.getInstance().post(new EndGameEvent(new HumanPlayer("Tie", 3)));
                return true;
            }
        }
	    return false;
    }

    /**
     * Apply a move
     * @param m move to be applied
     * @param player player who made the move
     */
    public void fillSquare(Move m, Player player) {
        // Safety check to make sure the move's board is not already full or won
        try {
            _panels[m.getBoard()].fillSquare(m.getPosition(), player);
            if (_panels[m.getBoard()].getWinner() == player) {
                player.score += 1;
                _panelsFilled++;
            }
            else if (_panels[m.getBoard()].isFull()) {
                _panelsFilled++;
            }
            _moveList.add(m);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Standard getter for Move List
     * @return ArrayList of Moves
     */
    public ArrayList<Move> getMoveList() {
        return _moveList;
    }

    /**
     * Try and open a particular board
     * @param board board ID
     */
    public void openBoard(int board) {
        _panels[board].open();
    }

    /**
     * Check if a particular board is open
     * @param board board ID
     * @return true if board is open, false otherwise
     */
    boolean isOpen(int board) {
        return _panels[board].isOpen();
    }

    /**
     * Check if a panel is won or full
     * @param board board id
     * @return true if won or full, false otherwise
     */
    public boolean isWonOrFull(int board) {
        return isWon(board) || isFull(board);
    }

    /**
     * Check if a panel is won
     * @param board board id
     * @return true if won, false otherwise
     */
    private boolean isWon(int board) {
        return _panels[board].isWon();
    }

    /**
     * Check if a panel is full
     * @param board board id
     * @return true if full, false otherwise
     */
    private boolean isFull(int board) {
        return _panels[board].isFull();
    }

    /**
     * Close a particular board
     * @param board board id
     */
    public void closeBoard(int board) {
        _panels[board].close();
    }

    /**
     * Close every board
     */
    public void closeAllBoards() {
        for(int i = 0; i < 9; i++) {
            _panels[i].close();
        }
    }

    /**
     * Used for computer player
     * Get all currently open boards
     * @return ArrayList of board indices that are currently open
     */
    ArrayList<Integer> getOpenBoards() {
        ArrayList<Integer> openBoards = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            if (!isWonOrFull(i) && _panels[i].isOpen()) {
                openBoards.add(i);
            }
        }
        return openBoards;
    }

    /**
     * Basic getter for a panel model
     * @param board board id
     * @return Index of _panels[board]
     */
    GamePanelModel getPanel(int board) {
        return _panels[board];
    }

    //Some methods for Unit Testing

    /**
     * Basic getter for _panelsFilled
     * @return number of panels filled
     */
    int getPanelsFilled()
    {
       return _panelsFilled;
    }

    /**
     * "Fill" the board
     */
    void setPanelsFilled()
    {
       _panelsFilled = 9;
    }
}
