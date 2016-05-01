
package my_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;


public class Surface extends JPanel implements ActionListener{
    
    Timer time = null;
    int panel_height;
    int panel_width;
    int points = 0;
    int components = 1;
    int velocity, acceleration;
    Cat my_cat = new Cat();
    BackGround back1 = new BackGround(0);
    BackGround back2 = new BackGround(back1.get_width());
    int delta;
    InputMap imap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
    ActionMap amap = getActionMap();

    
    Surface(int frame_height, int frame_width) throws IOException
    {
        panel_width = frame_width;
        panel_height = frame_height;
        //this.add()
    }
        
    @Override
    public void paintComponent(Graphics g) {
       super.paintComponent(g);
           try {
               doDrawing((Graphics2D) g);
           } catch (IOException ex) {
               Logger.getLogger(Surface.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        //imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), e);
        if(e.getSource() == "spacebar"){
            System.out.println("space bar pressed");
        }

        
    }
    
    public void update(){
        
        back1.update(back2.offset());
        back2.update(back1.offset());
        my_cat.update();
        points++;
    }
    
    void doDrawing(Graphics g2) throws IOException {

        Color clr = new Color(255,255,255);
        g2.drawImage(back1.get_image(), back1.get_location_x1(), 100, back1.get_location_x2(), 500, 0, 0,back1.get_image().getWidth(), back1.get_image().getHeight()-1, Color.white, null); 
        g2.drawImage(back2.get_image(),  back2.get_location_x1(), 100,  back2.get_location_x2(), 500, 0, 0, back2.get_image().getWidth(),back2.get_image().getHeight()-1, Color.white, null); 
        g2.drawImage(my_cat.get_image(), 100, 400, 180, 460, my_cat.get_x1(), my_cat.get_y1(),my_cat.get_x2(), my_cat.get_y2(), clr, null);
        g2.drawString("Number of Points: "+points, 20, 20);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(Surface.class.getName()).log(Level.SEVERE, null, ex);
        }
        update();
        repaint();
    }
    
}
