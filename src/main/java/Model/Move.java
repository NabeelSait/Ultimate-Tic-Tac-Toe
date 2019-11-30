package Model;

/**
 * Container for a Move
 * Inspired by Chess PGN notation
 */
public class Move {
    private int _board;
    private int _pos;

    /**
     * Basic Constructor
     * @param board board id
     * @param position position id
     */
    public Move(int board, int position) {
        _board = board;
        _pos = position;
    }

    /**
     * Basic getter for which board the move occurred on
     * @return board id
     */
    public int getBoard() {
        return _board;
    }

    /**
     * Basic getter for which position the move occurred on
     * @return position
     */
    public int getPosition() {
        return _pos;
    }
}
