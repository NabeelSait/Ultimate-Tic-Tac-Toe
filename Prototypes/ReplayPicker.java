import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class ReplayPicker extends JFrame
{
   JFileChooser rpicker;
   public ReplayPicker()
   {
      setLayout(new BorderLayout());

      setTitle("Choose a replay file");

      rpicker = new JFileChooser();
      FileFilter filter = new ReplayFileFilter();
      rpicker.setFileFilter(filter);

      add(rpicker);

      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(600,600,400,400);
   }
   public class ReplayFileFilter extends FileFilter
   {
       public String fileExt = "";
       String txtExt = ".txt";

       public ReplayFileFilter()
       {
           fileExt = ".replay";  //default file type extension.
       }

        @Override public boolean accept(File f)
        {
           if (f.isDirectory())
               return true;
           return  (f.getName().toLowerCase().endsWith(fileExt));
        }

       public String getDescription()
       {
          return("Replay files");
       }
    }
}
