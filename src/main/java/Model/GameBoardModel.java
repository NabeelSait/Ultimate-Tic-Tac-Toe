package Model;

import UI.Bus;

import java.util.ArrayList;

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
            return true;
        } else if (_panelsfilled == 9) {
            if (_player1.score > _player2.score) {
                EndGameEvent e = new EndGameEvent(_player1);
                Bus.getInstance().post(e);
                return true;
            } else if (_player2.score > _player1.score) {
                EndGameEvent e = new EndGameEvent(_player2);
                Bus.getInstance().post(e);
                return true;
            }
            else {
                EndGameEvent e = new EndGameEvent(new HumanPlayer("Tie", 3));
                Bus.getInstance().post(e);
                return true;
            }
        }
	    return false;
    }

    public void fillSquare(Move m, Player player){
        if (!_panels[m.getBoard()].isWonOrFull()) {
            _panels[m.getBoard()].fillSquare(m.getPosition(), player);
            if (_panels[m.getBoard()].checkWinCon(m.getPosition(), player)) {
                player.score += 1;
                _panelsfilled++;
                _panels[m.getBoard()].close();
            }
            else if (_panels[m.getBoard()].getSquaresFilled() == 9) {
                _panelsfilled++;
            }
            _moveList.add(m);
        }
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

    public void openBoard(int board) {
        _panels[board].open();
    }

    public boolean isOpen(int board) {
        return _panels[board].isOpen();
    }

    public boolean isWonOrFull(int board) {
        return _panels[board].isWonOrFull();
    }

    public void closeBoard(int board) {
        _panels[board].close();
    }

    public void closeAllBoards() {
        for(int i = 0; i < 9; i++) {
            _panels[i].close();
        }
    }

    ArrayList<Integer> getOpenBoards() {
        ArrayList<Integer> openBoards = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            if (!_panels[i].isWonOrFull() && _panels[i].isOpen()) {
                openBoards.add(i);
            }
        }
        return openBoards;
    }

    ArrayList<Integer> getOpenSquares(int board) {
        return _panels[board].getOpenSquares();
    }
}
