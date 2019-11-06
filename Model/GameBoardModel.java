public class GameBoardModel implements GameModel
{
   GamePanelModel [] boards;

   public GamePanelModel()
   {
      boards = new GamePanelModel[9];
      for (int i = 0; i < 9; i++)
      {
         boards[i] = new GamePanelModel();
      }
   }

   public void checkWinCon(Player player) {}

   public void fillSquare(Player player) {}
}
