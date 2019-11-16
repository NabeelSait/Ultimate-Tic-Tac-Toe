package Model;

public class ComputerPlayer extends Player
{
   public ComputerPlayer(String t, int n)
   {
      super(t,n);
   }

   public Move takeTurn() {
      return step();
   }

   private Move step() {
      return new Move(0, 0);
   }
}
