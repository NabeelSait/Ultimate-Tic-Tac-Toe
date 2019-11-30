package Model;

import UI.Bus;
import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Random;

/**
 * Automated player
 */
public class ComputerPlayer extends Player
{
   /**
    * Set shape and playerid
    * @param shape X | O
    * @param id player id
    */
   public ComputerPlayer(String shape, int id)
   {
      super(shape, id);

      // Also have to register with EventBus to receive postings
      Bus.getInstance().register(this);
   }

   /**
    * Method to compute which move to take
    * @param model Snapshot of the model received over EventBus
    */
   @Subscribe
   public void step(GameBoardModel model) {
      // Get all open boards, and select a random one
      ArrayList<Integer> openBoards = model.getOpenBoards();
      int index1 = new Random().nextInt(openBoards.size());

      // Get all open squares on the randomly selected open board, and select a random one
      ArrayList<Integer> openSquares = model.getPanel(index1).getOpenSquares();
      int index2 = new Random().nextInt(openSquares.size());

      // Make a move out of the randomly selected Board / Square and post to the EventBus
      Bus.getInstance().post(new Move(openBoards.get(index1), openSquares.get(index2)));
   }
}
