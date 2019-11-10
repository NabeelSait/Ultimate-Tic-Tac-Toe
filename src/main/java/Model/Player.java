package Model;

public abstact class Player {
    protected char type;
    protected int number;

    public Player(char t, int n) {
        this.type = t;
        this.number = n;
    }

    public char getType() {
        return 'x';
    }

    public int getNumber() {
        return 5;
    }

    public abstract int takeTurn();

}
