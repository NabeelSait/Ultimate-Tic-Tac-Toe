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

        //Horizontal Right
        if (pos + 1 <= 8 & pos + 1 >= 0 && _squares[pos + 1].equals(player.getType())) {
            if (pos + 2 <= 8 && _squares[pos + 2].equals(player.getType())) {
                return true;
            }
        }
        //Horizontal Left
        else if (pos - 1 <= 8 && pos - 1 >= 0 && _squares[pos - 1].equals(player.getType())) {
            if (pos - 2 >= 0 && _squares[pos - 2].equals(player.getType())) {
                return true;
            }
        }
        //Vertical Up
        else if (pos - 3 >= 0 && _squares[pos - 3].equals(player.getType())) {
            if (pos - 6 >= 0 && _squares[pos - 6].equals(player.getType())) {
                return true;
            }
        }
        //Vertical Down
        else if (pos + 3 <= 8 && _squares[pos + 3].equals(player.getType())) {
            if (pos + 6 <= 8 && _squares[pos + 6].equals(player.getType())) {
                return true;
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
