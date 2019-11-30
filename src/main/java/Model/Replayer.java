package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles the actions of the replay
 */
public class Replayer
{
   private ArrayList<Move> _moveList;
   private int _moveIndex;

   /**
    * Loads the replay file and populates the move list
    * @param replayFile replay file to be loaded
    */
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

   /**
    * Get the next move of the replayed match
    * @return Move next sequential move
    */
   public Move nextMove() {
      Move move = _moveList.get(_moveIndex);

      // Update the move index
      _moveIndex++;
      return move;
   }

   /**
    * Get the previous move of the replayed match
    * @return previous move
    */
   public Move previousMove() {
      // Update the move index
      _moveIndex--;
      return _moveList.get(_moveIndex);
   }

   /**
    * Is there another move?
    * @return true if game is not over, false otherwise
    */
   public boolean hasNextMove() {
      return _moveIndex != _moveList.size();
   }

   /**
    * Is there a move before
    * @return true if game is not on first move, false otherwise
    */
   public boolean hasPrevMove() {
      return _moveIndex > 0;
   }

   /**
    * Get the total moves in a replay
    * Used for testing
    * @return total moves in replay
    */
   int getTotalMoves() {
      return _moveList.size();
   }

}
