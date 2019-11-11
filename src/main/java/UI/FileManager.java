package UI;

import Model.Move;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FileManager extends JFrame
{
   public FileManager()
   {
      setLayout(new BorderLayout());
      JFileChooser c = new JFileChooser();
   }

   public int saveReplay(ArrayList<Move> moveList)
   {
      return 0;
   }

   public String openReplay()
   {
      return "String";
   }
}
