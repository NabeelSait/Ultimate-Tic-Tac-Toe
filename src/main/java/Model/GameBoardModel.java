package Model;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class GameBoardModel implements GameModel {
    private GamePanelModel[] boards;
    private Player _player1;
    private Player _player2;
    private Eventbus _bus;
    private ArrayList<Move> _moveList;

    private static class GamePanelModel
    {
        public GamePanelModel(Eventbus _bus)
        {
            GamePanelModel[] _boards = new GamePanelModel[9];
            for (int i = 0; i < 9; i++)
            {
                _boards[i] = new GamePanelModel();
            }
            _moveList = new ArrayList<Move>
        }
    }

    //posts EndGameEvent object
    public void checkWinCon(int pos, Player player) {
    }

    public void fillSquare(int pos, Player player) {
    }

    public ArrayList<Move> getMoveList(){
      return _moveList;
   }
}
