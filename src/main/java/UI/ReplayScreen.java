package UI;

import com.google.common.eventbus.EventBus;

import javax.swing.*;

public class ReplayScreen extends GameScreen
{
   private JButton _next;
   private JButton _prev;

   public ReplayScreen(EventBus bus)
   {
      super(bus);
   }
}
