package UI;

import Model.Move;
import com.google.common.eventbus.EventBus;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class FileManager extends JFrame {
   private JFileChooser _chooser;

   FileManager() {
      _chooser = new JFileChooser();
      _chooser.setCurrentDirectory(new File("./replays"));
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
         Bus.getInstance().post(file);
      }
      // if the user cancelled the operation
      else {
         System.out.println("the user cancelled the operation");
      }
   }
}
