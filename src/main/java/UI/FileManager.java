package UI;

import javax.swing.*;
import java.awt.*;

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
