package Model;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class GameBoardModel implements GameModel {
    private GamePanelModel[] boards;
    private Player _player1;
    private Player _player2;
    private Eventbus _bus;
    private ArrayList<Move> _moveList;


    public GameBoardModel(Eventbus e)
    {
      
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
