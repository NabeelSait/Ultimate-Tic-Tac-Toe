package Model;

public class ComputerPlayer extends Player
{
   ComputerPlayer(String t, int n)
   {
      super(t,n);
   }

   public Move takeTurn(int board) {
      return step(board);
   }

   private Move step(int board) {
      return new Move(board, 0);
   }
}
