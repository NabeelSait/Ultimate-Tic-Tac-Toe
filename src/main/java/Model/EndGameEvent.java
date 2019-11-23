package Model;

public class EndGameEvent
{
   public final Player player;

   EndGameEvent()
   {
      player = new HumanPlayer("NULL", 0);
   }

   EndGameEvent(Player player)
   {
      this.player = player;
   }
}
