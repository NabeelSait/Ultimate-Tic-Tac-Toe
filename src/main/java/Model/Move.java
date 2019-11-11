package Model;

public class Move {
    private int _board;
    private int _pos;

    Move(int board, int position) {
        _board = board;
        _pos = position;
    }

    public int getBoard() {
        return _board;
    }

    public int getPosition() {
        return _pos;
    }
}
