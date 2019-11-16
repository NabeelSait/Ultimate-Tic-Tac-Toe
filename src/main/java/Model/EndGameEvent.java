package Model;

public class EndGameEvent
{
   public final Player player;
   public EndGameEvent()
   {
      player = new HumanPlayer("NULL", 0);
   }
   public EndGameEvent(Player player)
   {
      this.player = player;
   }
}
