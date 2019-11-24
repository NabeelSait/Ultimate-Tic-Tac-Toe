package Model;

class GamePanelModel {
    private String[] _squares;
    private int _squaresFilled;
    private boolean _open;

    GamePanelModel() {
        _squares = new String[9];
        for (int i = 0; i < 9; i++) {
            _squares[i] = "";
        }
        _open = true;
    }

    void fillSquare(int position, Player player) {
        if (_open) {
            _squares[position] = player.getType();
            _squaresFilled++;
        }
    }

    boolean checkWinCon(int pos, Player player) {

        //Checks for ties
        if (_squaresFilled == 9) {
            _open = false;
            return false;
        }

        //Side Horizontals
        if (_squares[4].equals(player.getType())) {
            if (_squares[3].equals(player.getType())) {
               if (_squares[5].equals(player.getType())) {
                  return true;
               }
            }
            else if (_squares[1].equals(player.getType())) {
                if (_squares[7].equals(player.getType())) {
                    return true;
                }
            }
        }
        else if (_squares[1].equals(player.getType())) {
            if (_squares[0].equals(player.getType())) {
               if (_squares[2].equals(player.getType())) {
                  return true;
               }
            }
        }
        else if(_squares[7].equals(player.getType())) {
           if (_squares[6].equals(player.getType())) {
             if (_squares[8].equals(player.getType())) {
                return true;
             }
          }
        }
        //Side Verticals
        else if (_squares[3].equals(player.getType())) {
            if (_squares[0].equals(player.getType())) {
                if (_squares[6].equals(player.getType())) {
                   return true;
                }
            }
        }
        else if (_squares[5].equals(player.getType())) {
           if (_squares[2].equals(player.getType())) {
             if(_squares[8].equals(player.getType())) {
                return true;
             }
          }
        }
        //Diagonals
        if (_squares[4].equals(player.getType())) {
            if (pos == 0 && _squares[8].equals(player.getType())) //Bottom Left to Top Right
            {
                return true;
            }
            else if (pos == 8 && _squares[0].equals(player.getType())) {
                return true;
            }
            else if (pos == 2 & _squares[6].equals(player.getType()))//Bottom Right to Top Left
            {
                return true;
            }
            else return pos == 6 & _squares[2].equals(player.getType());
        }
        return false;
    }

    boolean open() {
        return _open;
    }

    void close() {
        _open = false;
    }

    String getSquare(int position) {
        return _squares[position];
    }

    int getSquaresFilled()
    {
       return _squaresFilled;
    }
}
