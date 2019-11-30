package Model;

/**
 * Created at the end of a played game
 */
public class EndGameEvent
{
   private final Player _winner;

   /**
    * Sets _winner
    * @param player the winner of the game
    */
   EndGameEvent(Player player)
   {
      this._winner = player;
   }

   /**
    * Getter
    * @return Player the winner of the game
    */
   public Player getWinner() {
      return _winner;
   }
}
