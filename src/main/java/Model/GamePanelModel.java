package Model;

public class GamePanelModel implements GameModel {
    private char[] squares;

    public GamePanelModel() {
        squares = new char[9];
        for (int i = 0; i < 9; i++) {
            squares[i] = Character.MIN_VALUE;
        }
    }

    public void fillSquare(int pos, Player player) {
    }

    public void checkWinCon(int pos, Player player) {
    }
}
