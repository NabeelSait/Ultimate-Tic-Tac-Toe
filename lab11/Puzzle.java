/*
 * Sliding puzzle model
 */

import java.util.Iterator;

public class Puzzle implements Iterable<Integer>
{
    protected Level level;
    protected int   size;
    protected int[] tiles;
    /**
     * Creates a Puzzle for the specified difficulty level
     * EASY: 3x3
     * MEDIUM: 4x4
     * HARD: 5x5
     */
    public Puzzle(Level level)
    {
        System.out.println("Puzzle: constructor created puzzle with level "+level);
        this.level = level;
        this.size = 0;
    }

    /**
     * @return N, where this puzzle is N x N
     */
    public int getSize()
    {
        System.out.println("Puzzle: getSize() is called");
        return 3;
    }
    /**
     * Attempts to move the selected piece into the empty position
     * @param selectedPiece The piece to move into the empty position
     * @return true if the move was successful, false if the move is invalid
     */
    public boolean move(int selectedPiece)
    {
        System.out.println("Puzzle: move " + selectedPiece +" is called");
        return true;
    }

    /**
     * Randomly shuffles all puzzle pieces, such that the puzzle is solvable
     */
    public void shuffle()
    {
        System.out.println("Puzzle: shuffle is called");
    }

    /**
     * Determines if the puzzle has been solved
     * @return true if the puzzle has been solved, false otherwise
     */
    public boolean isSolved()
    {
        System.out.println("Puzzle: isSolved() is called");
        return true;
    }

    /**
     * Iterator over all puzzle pieces in order. Value of 0 corresponds to the empty piece.
     */
    @Override
    public Iterator<Integer> iterator()
    {
        System.out.println("Puzzle: iterator() is called");
        return new PuzzleIterator();
    }

    private class PuzzleIterator implements Iterator<Integer>
    {
        int currentPosition;
        public PuzzleIterator()
        {
            currentPosition = 0;
        }
        public Integer next()
        {
            return 0;
        }
        public boolean hasNext()
        {
            return false;
        }
    }
}
