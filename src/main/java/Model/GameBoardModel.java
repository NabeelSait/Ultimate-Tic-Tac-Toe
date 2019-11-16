package Model;

import com.google.common.eventbus.EventBus;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class GameBoardModel implements GameModel {
    private GamePanelModel[] _panels;
    private EventBus _bus;
    private ArrayList<Move> _moveList;
    private Player _player1, _player2;
    private int _panelsfilled;


    public GameBoardModel(EventBus e) {
        _panels = new GamePanelModel[9];
        for (int i = 0; i < 9; i++) {
            _panels[i] = new GamePanelModel();
        }
        _moveList = new ArrayList<>();
    }

    public GameBoardModel(EventBus e, Player p1, Player p2) {
        _panels = new GamePanelModel[9];
        for (int i = 0; i < 9; i++) {
            _panels[i] = new GamePanelModel();
        }
        _bus = e;
        _panelsfilled = 0;
        _player1 = p1;
        _player2 = p2;
        _moveList = new ArrayList<>();
    }

    //posts EndGameEvent object
    public int checkWinCon(Move m, Player player) {
        //Checks for direct win
        if (player.score >= 5) {
            EndGameEvent e = new EndGameEvent(player);
            _bus.post(e);
        } else if (_panelsfilled == 9) {
            if (_player1.score > _player2.score) {
                EndGameEvent e = new EndGameEvent(_player1);
                _bus.post(e);
            } else if (_player2.score > _player1.score) {
                EndGameEvent e = new EndGameEvent(_player2);
                _bus.post(e);
            } else {
                EndGameEvent e = new EndGameEvent();
                _bus.post(e);
            }
        }
        return 0;
    }

    public void fillSquare(Move m, Player player) {
        GamePanelModel panel = _panels[m.getBoard()];
        if (!(panel.isClosed)) {
            panel.fillSquare(m, player);
            if (panel.checkWinCon(m, player) > 0) {
                player.score += panel.checkWinCon(m, player);
                _panelsfilled++;
                panel.isClosed = true;
            }
            this.checkWinCon(m, player);
            _moveList.add(m);
        }
    }

    public boolean checkClosed(Move m) {
        if (_panels[m.getPosition()].isClosed) {
            return true;
        }
        return false;
    }

    public ArrayList<Move> getMoveList() {
        return _moveList;
    }

}
