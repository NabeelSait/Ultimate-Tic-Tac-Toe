package Model;

public class GameBoardModel implements GameModel {
    private GamePanelModel[] boards;

    private static class GamePanelModel {
        GamePanelModel() {
            GamePanelModel[] _boards = new GamePanelModel[9];
            for (int i = 0; i < 9; i++) {
                _boards[i] = new GamePanelModel();
            }
        }
    }

    public void checkWinCon(Player player) {
    }

    public void fillSquare(Player player) {
    }
}