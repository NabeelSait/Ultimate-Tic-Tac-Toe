package Model;

public class GamePanelModel implements GameModel {
    private char[] squares;

    public GamePanelModel() {
        squares = new char[9];
        for (int i = 0; i < 9; i++) {
            squares[i] = Character.MIN_VALUE;
        }
    }

    public void fillSquare(Move m, Player player)
    {
      squares[m.getPosition()] = player.getType();
    }

    public int checkWinCon(Move m, Player player)
    {
      if (1 == 1)  //Insert actual wincon checking here
      {
         return 1;
      }
      else
      {
         return 0;
      }
    }

}
