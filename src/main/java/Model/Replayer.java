package Model;

import UI.GameBoard;
import UI.ReplayScreen;

import java.util.ArrayList;

public class Replayer
{
   private ArrayList<String> _moveList;
   private ReplayScreen _replayScreen;

   public Replayer(String filePath)
   {
      _moveList = new ArrayList<String>();
   }

   public void nextMove() {}

   public void previousMove() {}

}
