package Model;

public abstract class Player {
    private String type;
    private int number;
    int score;

    public Player(String t, int n) {
        type = t;
        number = n;
        score = 0;
    }

    public String getType() {
        return type;
    }

    int getNumber() {
        return number;
    }

    public abstract Move takeTurn(int board);

}
