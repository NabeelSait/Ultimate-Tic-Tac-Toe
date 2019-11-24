package UI;

import Model.Move;
import com.google.common.eventbus.EventBus;

import javax.swing.*;
import java.awt.*;
import java.io.*;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileManager extends JFrame {
   private JFileChooser _chooser;

   FileManager() {
      _chooser = new JFileChooser();
      _chooser.setCurrentDirectory(new File("./replays"));
   }

   public static int saveReplay(ArrayList<Move> moveList) throws IOException{
      String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
      String filename = "replays/" + timestamp + ".replay";
      System.out.println(filename);

      Charset utf8 = StandardCharsets.UTF_8;
      Writer writer = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(filename), utf8));
      for (Move m : moveList)
      {
          writer.write(String.valueOf(m.getBoard()), 0, String.valueOf(m.getBoard()).length());
          writer.write(" ");
          writer.write(String.valueOf(m.getPosition()), 0, String.valueOf(m.getPosition()).length());
      }
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
