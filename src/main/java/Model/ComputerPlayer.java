package Model;

public class ComputerPlayer extends Player
{
   public ComputerPlayer(char t, int n)
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
