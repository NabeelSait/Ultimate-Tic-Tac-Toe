package Model;

import java.util.ArrayList;

/**
 * Model for an individual Panel (tic tac toe board)
 */
class GamePanelModel {
    private String[] _squares;
    private int _squaresFilled;
    private Player _winner;
    private boolean _playable;

    /**
     * Creates and populates member variables
     */
    GamePanelModel() {
        // Fill _squares with empty string
        _squares = new String[9];
        for (int i = 0; i < 9; i++) {
            _squares[i] = "";
        }

        // Set rest of variables to defaulted values
        _winner = null;
        _squaresFilled = 0;
        _playable = true;
    }

    /**
     * Populate a square with player's type
     * @param position position to fill
     * @param player Player who made the move
     */
    void fillSquare(int position, Player player) {
        _squares[position] = player.getShape();
        _squaresFilled++;

        // Check to see if this move made the player win the board
        checkWinCon(position, player);
    }

    /**
     * Check if a player one, stemming from pos
     * If the player did win this board, close it.
     * @param pos position to check around for three in a row
     * @param player Player to check for
     */
    private void checkWinCon(int pos, Player player) {

        //Checks for ties
        if (_squaresFilled == 9) {
            _winner = player;
        }

        //Side Horizontals
        if (_squares[4].equals(player.getShape())) {
            if (_squares[3].equals(player.getShape())) {
               if (_squares[5].equals(player.getShape())) {
                   _winner = player;
                   close();
               }
            }
            else if (_squares[1].equals(player.getShape())) {
                if (_squares[7].equals(player.getShape())) {
                    _winner = player;
                    close();
                }
            }
        }
        else if (_squares[1].equals(player.getShape())) {
            if (_squares[0].equals(player.getShape())) {
               if (_squares[2].equals(player.getShape())) {
                   _winner = player;
                   close();
               }
            }
        }
        else if(_squares[7].equals(player.getShape())) {
           if (_squares[6].equals(player.getShape())) {
             if (_squares[8].equals(player.getShape())) {
                 _winner = player;
                 close();
             }
          }
        }
        //Side Verticals
        else if (_squares[3].equals(player.getShape())) {
            if (_squares[0].equals(player.getShape())) {
                if (_squares[6].equals(player.getShape())) {
                    _winner = player;
                    close();
                }
            }
        }
        else if (_squares[5].equals(player.getShape())) {
           if (_squares[2].equals(player.getShape())) {
             if(_squares[8].equals(player.getShape())) {
                 _winner = player;
                 close();
             }
          }
        }
        //Diagonals
        if (_squares[4].equals(player.getShape())) {
            if (pos == 0 && _squares[8].equals(player.getShape())) //Bottom Left to Top Right
            {
                _winner = player;
                close();
            }
            else if (pos == 8 && _squares[0].equals(player.getShape())) {
                _winner = player;
                close();
            }
            else if (pos == 2 & _squares[6].equals(player.getShape()))//Bottom Right to Top Left
            {
                _winner = player;
                close();
            }
            else if(pos == 6 & _squares[2].equals(player.getShape())) {
                _winner = player;
                close();
            }
        }
    }

    /**
     * Getter for winner
     * @return Player (or null)
     */
    Player getWinner() {
        return _winner;
    }

    /**
     * Is the board full?
     * @return true if board is full
     */
    boolean isFull() {
        return _squaresFilled == 9;
    }

    /**
     * Is the board open?
     * @return true if open, false otherwise
     */
    boolean isOpen() {
        return _playable;
    }

    /**
     * Is the board won?
     * @return true if won, false otherwise
     */
    boolean isWon() {
        return _winner != null;
    }

    /**
     * Open the board, if the board is not in a terminal state
     */
    void open() {
        if (!isWon() && !isFull()) {
            _playable = true;
        }
    }

    /**
     * Close the board
     */
    void close() {
        _playable = false;
    }

    /**
     * Getter for a particular square's value
     * @param position position of square
     * @return String of either X, O, or null.
     */
    String getSquare(int position) {
        return _squares[position];
    }

    /**
     * Get the number of squares currently filled
     * @return number of squares filled
     */
    int getSquaresFilled()
    {
       return _squaresFilled;
    }

    /**
     * get the unmarked squares
     * @return ArrayList of unmarked square indices
     */
    ArrayList<Integer> getOpenSquares() {
        ArrayList<Integer> openSquares = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            if (_squares[i].length() == 0) {
                openSquares.add(i);
            }
        }
        return openSquares;
    }
}
