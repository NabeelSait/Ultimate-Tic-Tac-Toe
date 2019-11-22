package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Replayer
{
   private ArrayList<Move> _moveList;
   private int _moveIndex;

   public Replayer(File replayFile)
   {
      _moveList = new ArrayList<>();
      try {
         Scanner sc = new Scanner(replayFile);

         while(sc.hasNext()) {
            _moveList.add(new Move(sc.nextInt(), sc.nextInt()));
         }
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      _moveIndex = 0;
   }

   public Move nextMove() {
      Move move = _moveList.get(_moveIndex);
      _moveIndex++;
      return move;
   }

   public Move previousMove() {
      _moveIndex--;
      return _moveList.get(_moveIndex);
   }

   public boolean hasNextMove() {
      return _moveIndex != _moveList.size();
   }

   public boolean hasPrevMove() {
      return _moveIndex > 0;
   }

   int getTotalMoves() {
      return _moveList.size();
   }

}
