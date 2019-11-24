package Model;

import java.io.IOException;

public interface GameModel {
    boolean checkWinCon(Move m, Player player);

    void fillSquare(Move m, Player player);
}
