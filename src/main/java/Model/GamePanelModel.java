package Model;

import java.util.ArrayList;

class GamePanelModel {
    private String[] _squares;
    private int _squaresFilled;
    private boolean _won;
    private boolean _playable;
    // player can make a move here at this time

    GamePanelModel() {
        _squares = new String[9];
        for (int i = 0; i < 9; i++) {
            _squares[i] = "";
        }
        _won = false;
        _squaresFilled = 0;
        _playable = true;
    }

    void fillSquare(int position, Player player) {
        _squares[position] = player.getType();
        _squaresFilled++;
    }

    boolean checkWinCon(int pos, Player player) {

        //Checks for ties
        if (_squaresFilled == 9) {
            _won = true;
            return false;
        }

        //Side Horizontals
        if (_squares[4].equals(player.getType())) {
            if (_squares[3].equals(player.getType())) {
               if (_squares[5].equals(player.getType())) {
                   _won = true;
                  return true;
               }
            }
            else if (_squares[1].equals(player.getType())) {
                if (_squares[7].equals(player.getType())) {
                    _won = true;
                    return true;
                }
            }
        }
        else if (_squares[1].equals(player.getType())) {
            if (_squares[0].equals(player.getType())) {
               if (_squares[2].equals(player.getType())) {
                   _won = true;
                  return true;
               }
            }
        }
        else if(_squares[7].equals(player.getType())) {
           if (_squares[6].equals(player.getType())) {
             if (_squares[8].equals(player.getType())) {
                 _won = true;
                return true;
             }
          }
        }
        //Side Verticals
        else if (_squares[3].equals(player.getType())) {
            if (_squares[0].equals(player.getType())) {
                if (_squares[6].equals(player.getType())) {
                    _won = true;
                   return true;
                }
            }
        }
        else if (_squares[5].equals(player.getType())) {
           if (_squares[2].equals(player.getType())) {
             if(_squares[8].equals(player.getType())) {
                 _won = true;
                return true;
             }
          }
        }
        //Diagonals
        if (_squares[4].equals(player.getType())) {
            if (pos == 0 && _squares[8].equals(player.getType())) //Bottom Left to Top Right
            {
                _won = true;
                return true;
            }
            else if (pos == 8 && _squares[0].equals(player.getType())) {
                _won = true;
                return true;
            }
            else if (pos == 2 & _squares[6].equals(player.getType()))//Bottom Right to Top Left
            {
                _won = true;
                return true;
            }
            else if(pos == 6 & _squares[2].equals(player.getType())) {
                _won = true;
                return true;
            }
        }
        return false;
    }

    boolean isOpen() {
//        if (_won || _squaresFilled == 9) {
//            return false;
//        }
        return _playable;
    }

    boolean isWonOrFull() {
        return _won || _squaresFilled == 9;
    }

    void open() {
        if (!_won && _squaresFilled != 9) {
            _playable = true;
        }
    }

    void close() {
        _playable = false;
    }

    String getSquare(int position) {
        return _squares[position];
    }

    int getSquaresFilled()
    {
       return _squaresFilled;
    }

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
