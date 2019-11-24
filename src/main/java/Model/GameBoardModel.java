package Model;

import UI.Bus;

import java.util.ArrayList;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.io.IOException;

@SuppressWarnings("ALL")
public class GameBoardModel implements GameModel {
    private GamePanelModel[] _panels;
    private ArrayList<Move> _moveList;
    private Player _player1, _player2;
    private int _panelsfilled;

    public GameBoardModel(Player p1, Player p2) {
        _panels = new GamePanelModel[9];
        for (int i = 0; i < 9; i++) {
            _panels[i] = new GamePanelModel();
        }
        _panelsfilled = 0;
        _player1 = p1;
        _player2 = p2;
        _moveList = new ArrayList<>();
    }

    //posts EndGameEvent object
    public boolean checkWinCon(Move m, Player player){
        //Checks for direct win
        if (player.score >= 5) {
            EndGameEvent e = new EndGameEvent(player);
            Bus.getInstance().post(e);
            saveGameToFile();
	         return true;
        } else if (_panelsfilled == 9) {
            if (_player1.score > _player2.score) {
                saveGameToFile();
                EndGameEvent e = new EndGameEvent(_player1);
                Bus.getInstance().post(e);
                return true;
            } else if (_player2.score > _player1.score) {
                saveGameToFile();
                EndGameEvent e = new EndGameEvent(_player2);
                Bus.getInstance().post(e);
                return true;
            }
            else {
                saveGameToFile();
                EndGameEvent e = new EndGameEvent(new HumanPlayer("Tie", 3));
                Bus.getInstance().post(e);
                return true;
            }
        }
	return false;
    }

    public void fillSquare(Move m, Player player){
        GamePanelModel panel = _panels[m.getBoard()];
        if (panel.open()) {
            panel.fillSquare(m.getPosition(), player);
            if (panel.checkWinCon(m.getPosition(),player)) {
                player.score += 1;
                _panelsfilled++;
                panel.close();
            }
            else if (panel.getSquaresFilled() == 9) {
                _panelsfilled++;
            }
            this.checkWinCon(m, player);
            _moveList.add(m);
        }
    }

    public boolean isClosed(Move m) {
        return !_panels[m.getPosition()].open();
    }

    public ArrayList<Move> getMoveList() {
        return _moveList;
    }


    //Some methods for Unit Testing

    public int getPanelsFilled()
    {
       return _panelsfilled;
    }

    public int setPanelsFilled(int pf)
    {
       _panelsfilled = pf;
       return 1;
    }

    public boolean boardOpen(int board) {
        return _panels[board].open();
    }

    private void saveGameToFile(){
      // Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      // String filename = "/replays/" + String.valueOf(timestamp) + ".replay";
      // FileWriter fw = new FileWriter(filename);
      // for (Move m : this._moveList)
      // {
      //     final String out = String.valueOf(m.getBoard()) + " " + String.valueOf(m.getPosition()) + "\n";
      //     fw.write(out);
      // }
    }
}
