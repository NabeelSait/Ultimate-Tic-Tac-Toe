import org.junit.*;
import static org.junit.Assert.*;

public class PuzzleTest
{

   public static void testConstructor(Level expectedLevel, int expectedSize)
   {
      Puzzle puzzle = new Puzzle(expectedLevel);
      assertEquals("Puzzle constructor set incorrect level", expectedLevel, puzzle.level);
      assertEquals("Puzzle constructor set incorrect size", expectedSize, puzzle.size);
   }

   public static Puzzle initOrderedPuzzle(int numTiles)
   {
      Puzzle puzzle = new Puzzle(Level.EASY);
      int[] tiles = new int[numTiles];
      for (int i = 0; i < numTiles; i++)
      {
         tiles[i] = i;
      }
      puzzle.tiles = tiles;
      return puzzle;
   }

   public static void getSizeTest(int expectedSize)
   {
      Puzzle puzzle = new Puzzle(Level.EASY);
      puzzle.size = expectedSize;
      int actualSize = puzzle.getSize();
      assertEquals("puzzle.getSize()", expectedSize, actualSize); 
   }

   @Test
   public void testMoveInvalid()
   {
      Puzzle puzzle = initOrderedPuzzle(9);
      assertEquals("puzzle.move()", false,  puzzle.move(8));
   }

   @Test
   public void testMoveValid()
   {
      Puzzle puzzle = initOrderedPuzzle(9);
      assertEquals("puzzle.move()", true, puzzle.move(1));
   }
 
   @Test
   public void testConstructorEasyLevel()
   {
      testConstructor(Level.EASY, 3);
   }

   @Test
   public void testConstructorMediumLevel()
   {
      testConstructor(Level.MEDIUM, 4);
   }

   @Test
   public void testConstructorHardLevel()
   {
      testConstructor(Level.HARD, 5);
   }

   @Test
   public void testGetSize()
   {
      getSizeTest(64);
   }
}
