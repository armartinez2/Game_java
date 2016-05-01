
package my_game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


class Cat{
    private int velocity, acceleration;
    private int height;
    private int width;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    File file;
    BufferedImage image;
    int frame;
    
    public BufferedImage get_image() throws IOException{
        return image;
    }
    
    Cat() throws IOException{
        file = new File("cat.png");
        image = ImageIO.read(file);
        height = 256;
        width = 512;
        x1 = 0;
        y1 = 0;
        x2 = x1+width;
        y2 = y1 + height;
        frame = 1;
    }
    
    void get_frame(int frame){
        if (frame == 1){
            x1 = 0;
            y1 = 0;
            x2 = x1+width;
            y2 = y1+height;
        }
        else if (frame ==2){
            x1 = 512;
            y1 = 0;
            x2 = x1+width;
            y2 = y1+height;
        }
        else if(frame == 3){
            x1 = 0;
            y1 = 256;
            x2 = x1+width;
            y2 = y1+height;
        }
        else if(frame == 4){
            x1 = 512;
            y1 = 256;
            x2 = x1+width;
            y2 = y1+height;
        }
        else if(frame == 5){
            x1 = 0;
            y1 = 512;
            x2 = x1+width;
            y2 = y1+height;
        }
        else if (frame == 6){
            x1 = 512;
            y1 = 512;
            x2 = x1+width;
            y2 = y1+height;
            
        }
        else if(frame == 7){
            x1 = 0;
            y1 = 768;
            x2 = x1+width;
            y2 = y1+height;
        }
        else {
            x1 = 512;
            y1 = 768;
            x2 = x1+width;
            y2 = y1+height;
        }
    }
    
    public int get_x1(){
        return x1;
    }
    public int get_y1(){
        return y1;
    }
    public int get_x2(){
        return x2;
    }
    public int get_y2(){
        return y2;
    }
    
    public void update(){
        if(frame <= 7) frame++;
        else frame = 1;
        get_frame(frame);
    }
}
