
package my_game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


class BackGround {

    private BufferedImage image;
    private int width;
    private int height;
    private int x1 = 0;
    private int y1 = 0;
    private int x2 = x1+width;
    private int y2 = y1 + height;
    int xloc, yloc, velocity, acceleration;
    
    BackGround(int start) throws IOException{
        image = ImageIO.read(new File("back_ground.png"));
        width = image.getWidth();
        height = image.getHeight();
        x1 = start;
        y1 = 0;
        x2 = x1+width;
        y2 = y1 + height;
    }
    public BufferedImage get_image() throws IOException{
        return image;
    }
    public int get_width(){
        return width;
    }
    
    public void update(int offset){
        if(x2<=1){
            x1 = offset -20;
            x2 = x1+width;
        }
        else{
            x1-=10;
            x2-=10;
        }
    }
    
    public int offset(){
        return x2;
    }
    public int get_location_x1(){
        return x1;
    }
    public int get_location_x2(){
        return x2;
    }
}
