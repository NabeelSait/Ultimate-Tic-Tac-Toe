package Model;

import UI.Bus;
import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends Player
{
   public ComputerPlayer(String t, int n)
   {
      super(t,n);
      Bus.getInstance().register(this);
   }

   @Subscribe
   public void step(GameBoardModel model) {
      ArrayList<Integer> openBoards = model.getOpenBoards();
      int index1 = new Random().nextInt(openBoards.size());
      ArrayList<Integer> openSquares = model.getOpenSquares(openBoards.get(index1));
      int index2 = new Random().nextInt(openSquares.size());
      Bus.getInstance().post(new Move(openBoards.get(index1), openSquares.get(index2)));
   }
}
