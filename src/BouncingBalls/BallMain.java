/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BouncingBalls;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author gjr5542
 */
public class BallMain {
    
    private static ArrayList<Ball> balls;

    public static void main(String[] args) {
        balls = new ArrayList();
        
        JFrame frame = new JFrame("Jaime's Bouncing Ball Thing");
        // kill all threads when frame closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new BallPanel(balls));
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
