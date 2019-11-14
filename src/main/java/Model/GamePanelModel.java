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
      int pos = m.getPosition();
      //Horizontal Right
      if (((pos + 1) <= 8) & ((pos + 1) >= 0) & ((squares[pos + 1].equals(player.getType()))))
      {
         if (((pos + 2) <= 8) & ((pos + 2) >= 0)) & ((squares[pos +2].equals(player.getType()))))
         {
            return 1;
         }
      }
      //Horizontal Left
      if (((pos - 1) <= 8) & ((pos - 1) >= 0) & ((squares[pos - 1].equals(player.getType()))))
      {
         if (((pos - 2) <= 8) & ((pos - 2) >= 0)) & ((squares[pos - 2].equals(player.getType()))))
         {
            return 1;
         }
      }
      //Vertical Up
      if (((pos - 3) <= 8) & ((pos - 3) >= 0) & ((squares[pos - 3].equals(player.getType()))))
      {
         if (((pos - 3) <= 8) & ((pos - 3) >= 0)) & ((squares[pos - 3].equals(player.getType()))))
         {
            return 1;
         }
      }
      //Vertical Down
      if (((pos + 3) <= 8) & ((pos + 3) >= 0) & ((squares[pos + 3].equals(player.getType()))))
      {
         if (((pos + 6) <= 8) & ((pos + 6) >= 0)) & ((squares[pos + 6].equals(player.getType()))))
         {
            return 1;
         }
      }
      //Diagonals
      if (squares[4].equals(player.getType())
      {
         if ((pos == 0) & (squares[8].equals(player.getType()))) //Bottom Left to Top Right
         {
            return 1;
         }
         if ((pos == 8) & (squares[0].equals(player.getType())))
         {
            return 1;
         }
         if ((pos == 2) & (squares[6].equals(player.getType()))) //Bottom Right to Top Left
         {
            return 1;
         }
         if ((pos == 6) & (squares[2].equals(player.getType())))
         {
            return 1;
         }
      }
      return 0;
    }

}
