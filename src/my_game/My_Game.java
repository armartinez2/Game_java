
package my_game;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class My_Game extends JFrame {
    
    My_Game() throws IOException { super("Video Game"); init(); }
    static JFrame frame = new JFrame("this is my game");
    static JPanel panel = new JPanel();
    static Timer time = null;
    int frame_width = 800;
    int frame_height = 600;

    void init() throws IOException
    {
        setFocusable(false);
        setSize(frame_width,frame_height);
        setResizable(false);
        setLocation(20,20);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Surface(frame_height, frame_width));
    }
    
    public static void main(String[] args) throws IOException {
        EventQueue.invokeLater(()->{
            try {
                new My_Game().setVisible(true);
            } catch (IOException ex) {
                ex.printStackTrace();
                Logger.getLogger(My_Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
}
