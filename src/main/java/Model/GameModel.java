package Model;

public interface GameModel {
    int checkWinCon(Move m, Player player);

    void fillSquare(Move m, Player player);
}
