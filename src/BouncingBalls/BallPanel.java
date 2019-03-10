package BouncingBalls;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BallPanel extends JPanel implements ActionListener
{
    private DrawPane drawPane;
    private JPanel bottomMenu;
    private JButton addBallButton, add100BallButton, removeBallButton;
    private ArrayList<Ball> balls;

    
    public BallPanel(ArrayList<Ball> balls)
    {  
        super(new BorderLayout());
        

        
        this.balls = balls;
        setPreferredSize(new Dimension(600, 400));
      
        this.drawPane = new DrawPane(balls);
        this.add(drawPane, BorderLayout.CENTER);
      
        this.bottomMenu = new JPanel(); {
            bottomMenu.setPreferredSize(new Dimension(600, 30));
            bottomMenu.setBackground(Color.lightGray);

            addBallButton = new JButton("Add Ball");
            addBallButton.addActionListener(this);
            bottomMenu.add(addBallButton);
            
            add100BallButton = new JButton("Add 100 Balls");
            add100BallButton.addActionListener(this);
            bottomMenu.add(add100BallButton);

            removeBallButton = new JButton("Remove Ball");
            removeBallButton.addActionListener(this);
            bottomMenu.add(removeBallButton);
            
        }
      this.add(bottomMenu, BorderLayout.SOUTH);

      Timer timer = new Timer(10, this);
      timer.start();  
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == addBallButton) {
            newBall();
            System.out.println("Number of Balls: " + balls.size());
            
        } else if (source == add100BallButton) {
            for(int i = 0; i < 100; i++) {
                newBall();
            }
            System.out.println("Number of Balls: " + balls.size());

        } else if (source == removeBallButton) {
            balls.remove(balls.size() - 1);
            System.out.println("Number of Balls: " + balls.size());

        }
        drawPane.repaint();
    }
   
    private void newBall() {
        Ball b = new Ball(drawPane.getWidth(), drawPane.getHeight());
        Thread t = new Thread(b);
        t.start();
        balls.add(b);
        
    }
    
   private class DrawPane extends JPanel {
       
       private ArrayList<Ball> balls;

       public DrawPane(ArrayList<Ball> balls) {
           this.balls = balls;
       }
       
       @Override
       public void paintComponent(Graphics g) {
           super.paintComponent(g);
           
           if (balls.size() > 0){
           balls.get(0).setWorldWidth(this.getWidth());
           balls.get(0).setWorldHeight(this.getHeight());
           }

           balls.forEach((ball) -> {
               ball.drawBall(g);
           });
       }
   }
}
