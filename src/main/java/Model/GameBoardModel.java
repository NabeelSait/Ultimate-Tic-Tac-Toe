package Model;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class GameBoardModel implements GameModel {
    private GamePanelModel[] boards;
    private EventBus _bus;
    private ArrayList<Move> _moveList;



    public GameBoardModel(EventBus e)
    {
      GamePanelModel[] _boards = new GamePanelModel[9];
      for (int i = 0; i < 9; i++)
      {
         _boards[i] = new GamePanelModel();
      }
      _moveList = new ArrayList<>();
    }

    //posts EndGameEvent object
    public int checkWinCon(Move m, Player player)
    {
      if (player.score >= 5)
      {
         EndGameEvent e = new EndGameEvent(player);
         _bus.post(e);
      }
      return 0;
    }

    public void fillSquare(Move m, Player player)
    {
      boards[m.getBoard()].fillSquare(m, player);
      player.score += boards[m.getBoard()].checkWinCon(m, player);
      this.checkWinCon(m, player);
    }

    public ArrayList<Move> getMoveList(){
      return _moveList;
   }

}
