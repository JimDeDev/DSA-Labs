package StudentMap_5_2;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 *
 * @author gjr5542
 */
public class Main {

    public static void main(String[] args) {

        HashMap<Integer, Student> students = new HashMap<>();

        JFrame frame = new JFrame("Jaime's Student Register");
        // kill all threads when frame closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new StudentPanel(students));
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
