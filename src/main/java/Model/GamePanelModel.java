package Model;

public class GamePanelModel implements GameModel {
    private char[] squares;

    public GamePanelModel(Eventbus _bus)
    {
        GamePanelModel[] _boards = new GamePanelModel[9];
        for (int i = 0; i < 9; i++)
        {
            _boards[i] = new GamePanelModel();
        }
        _moveList = new ArrayList<Move>
    }

    public void fillSquare(int pos, Player player) {
    }

    public void checkWinCon(int pos, Player player) {
    }
}
