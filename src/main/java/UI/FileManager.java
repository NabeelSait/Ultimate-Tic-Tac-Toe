package UI;

import Model.Move;
import com.google.common.eventbus.EventBus;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class FileManager extends JFrame {
   JFileChooser _chooser;
   EventBus _bus;

   public FileManager(EventBus bus) {
      _chooser = new JFileChooser();
      _chooser.setCurrentDirectory(new File("./replays"));
      _bus = bus;
   }

   public int saveReplay(ArrayList<Move> moveList) {
      return 0;
   }

   public String openReplay() {
      return "String";
   }

   void pickReplay() {
      int response = _chooser.showOpenDialog(null);
      if (response == JFileChooser.FILES_ONLY) {
         File file = _chooser.getSelectedFile();
         System.out.println(file.getName());
         _bus.post(file);
      }
      // if the user cancelled the operation
      else {
         System.out.println("the user cancelled the operation");
      }
   }
}
