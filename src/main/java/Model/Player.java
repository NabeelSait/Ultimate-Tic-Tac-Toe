package Model;

public abstract class Player {
    private static char type;
    private static int number;
    int score;

    public Player(char t, int n) {
        type = t;
        number = n;
        score = 0;
    }

    public char getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    public abstract Move takeTurn();

}
