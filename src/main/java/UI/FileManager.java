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
      String filename = "replays/" + timestamp + ".txt";
      System.out.println(filename);

      File file = new File(filename);

      if (file.createNewFile()) {
          System.out.println("File is created!");
      } else {
          System.out.println("File already exists.");
      }

      FileWriter writer = new FileWriter(file);
      BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));
      for (Move m : moveList)
      {
          out.write(String.valueOf(m.getBoard()));
          out.write(" ");
          out.write(String.valueOf(m.getPosition()));
          out.write(" \n");
      }
      out.close();
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
