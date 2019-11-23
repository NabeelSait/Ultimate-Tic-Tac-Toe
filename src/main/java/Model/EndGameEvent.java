package Model;

public class EndGameEvent
{
   private final Player _winner;

   EndGameEvent(Player player)
   {
      this._winner = player;
   }

   public Player getWinner() {
      return _winner;
   }
}
