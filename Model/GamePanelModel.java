public class GamePanelModel implements GameModel
{
   char [] squares;

   public GamePanelModel()
   {
      squares = new char[9];
      for(int i=0;i<9;i++)
      {
         squares[i] = "";
      }
   }

   public void fillSquare(Player player) {}

   public void checkWinCon(Player player) {}
}