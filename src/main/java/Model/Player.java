package Model;

public abstract class Player {
    private static char type;
    private static int number;

    public Player(char t, int n) {
        type = t;
        number = n;
    }

    public char getType() {
        return 'x';
    }

    public int getNumber() {
        return 5;
    }

    public abstract Move takeTurn();

}
