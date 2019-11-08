package Model;

public class Replayer
{
   private ArrayList<String> _moveList;
   private GameBoard _replayBoard;

   public Replayer(String filePath)
   {
      _moveList = new ArrayList<String>;
      _replayBoard = new GameBoard();
   }

   public void nextMove() {}

   public void previousMove() {}

}
