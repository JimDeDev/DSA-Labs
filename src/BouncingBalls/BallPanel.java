package BouncingBalls;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BallPanel extends JPanel implements ActionListener
{
    private DrawPane drawPane;
    private JPanel bottomMenu;
    private JButton addBallBtn, add100BallBtn, removeBallBtn, removeAllBallsBtn, centreBallsBtn, groupBtn;
    private ArrayList<Ball> balls;

    public BallPanel(ArrayList<Ball> balls)
    {  
        super(new BorderLayout());
        

        
        this.balls = balls;
        setPreferredSize(new Dimension(600, 400));
      
        this.drawPane = new DrawPane(balls);
        this.add(drawPane, BorderLayout.CENTER);
      
        this.bottomMenu = new JPanel(); {
            bottomMenu.setPreferredSize(new Dimension(this.getWidth(), 40));
            bottomMenu.setBackground(Color.lightGray);

            addBallBtn = new JButton("Add");
            addBallBtn.addActionListener(this);
            bottomMenu.add(addBallBtn);
            
            add100BallBtn = new JButton("Add 100");
            add100BallBtn.addActionListener(this);
            bottomMenu.add(add100BallBtn);

            removeBallBtn = new JButton("Remove");
            removeBallBtn.addActionListener(this);
            bottomMenu.add(removeBallBtn);

            removeAllBallsBtn = new JButton("Remove All");
            removeAllBallsBtn.addActionListener(this);
            bottomMenu.add(removeAllBallsBtn);

            centreBallsBtn = new JButton("Centre");
            centreBallsBtn.addActionListener(this);
            bottomMenu.add(centreBallsBtn);

            groupBtn = new JButton("Group");
            groupBtn.addActionListener(this);
            bottomMenu.add(groupBtn);
        }
      this.add(bottomMenu, BorderLayout.SOUTH);

      Timer timer = new Timer(10, this);
      timer.start();  
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == addBallBtn) {
            newBall();
            System.out.println("Number of Balls: " + balls.size());
            
        } else if (source == add100BallBtn) {
            for(int i = 0; i < 100; i++) {
                newBall();
            }
            System.out.println("Number of Balls: " + balls.size());

        } else if (source == removeBallBtn) {
            if (!balls.isEmpty()) {
                balls.get(balls.size() - 1).kill();
                balls.remove(balls.size() - 1);
            }
            System.out.println("Number of Balls: " + balls.size());

        } else if (source == removeAllBallsBtn) {
            for (Ball aBall : balls) aBall.kill();
            balls.removeAll(balls);

            System.out.println("Number of Balls: " + balls.size());

        } else if (source == centreBallsBtn) {
            for (Ball aBall : balls) aBall.centre();
            System.out.println("Balls Centred");

        } else if (source == groupBtn) {
            Random rand = new Random();
            int x = rand.nextInt(this.getWidth());
            int y = rand.nextInt(this.getHeight());

            for (Ball aBall : balls) aBall.position(x, y);
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
