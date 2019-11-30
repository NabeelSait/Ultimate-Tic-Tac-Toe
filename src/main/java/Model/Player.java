package Model;

/**
 * Abstract class for a PLayer
 */
public abstract class Player {
    private String _shape;
    private int _id;
    int score;

    /**
     * Basic Constructor
     * @param shape x | 0
     * @param n id
     */
    public Player(String shape, int n) {
        _shape = shape;
        _id = n;
        score = 0;
    }

    /**
     * Basic getting for Player shape
     * @return X | O
     */
    public String getShape() {
        return _shape;
    }

    /**
     * Basic getter for player id
     * @return 0 | 1
     */
    public int get_id() {
        return _id;
    }
}
