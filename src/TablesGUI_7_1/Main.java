package TablesGUI_7_1;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author gjr5542
 */
public class Main {

   private static String dbUrl = "jdbc:mysql://raptor2.aut.ac.nz:3306/animals";

//   public static void main(String[] args) {
//      DatabaseManager db = new DatabaseManager(dbUrl);
//      boolean success = db.login("student", "fpn871");
//      System.out.println("Connection Success? " + success);
//
//   }

     public static void main(String[] args) {

       DatabaseManager db = new DatabaseManager(dbUrl);

      JFrame frame = new JFrame("Jaime's Database GUI");
      // kill all threads when frame closes
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new DBPanel(db));
      frame.pack();

      // position the frame in the middle of the screen
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension screenDimension = tk.getScreenSize();
      Dimension frameDimension = frame.getSize();

      frame.setLocation((screenDimension.width-frameDimension.width)/2,
         (screenDimension.height-frameDimension.height)/2);

      frame.setVisible(true);

      System.out.println("Main thread about to die");
    }
}
