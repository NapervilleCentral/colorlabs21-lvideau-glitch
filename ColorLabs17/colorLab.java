
/**
 * The color lab. Hopefully, if you are seeing this, you know what I'm talking about.
 *
 * Ludovic Videau
 * 11/10/2025
 */
import java.awt.*;
import java.util.*;
import java.util.List;
public class colorLab
{
    public static void main (String [] args){
        Picture pic1 = new Picture("images\\temple.jpg");
        Picture pic2 = new Picture("images\\butterfly1.jpg");
        Picture pic3 = new Picture("images\\whiteFlower.jpg");
        Picture pic4 = new Picture("images\\CumberlandIsland.jpg");
        Picture pic5 = new Picture("images\\arch.jpg");
        Picture pic6 = new Picture("images\\17627819377118825944526613374639.jpg");
        Pixel[] pixels;
        pixels = pic1.getPixels(); 
        int red, blue, green;
        for (Pixel spot : pixels){
            red = spot.getRed();
            red = (red/2);
            spot.setRed(red);
        }
        pic1.explore();
        
        pixels = pic2.getPixels();
        for (Pixel spot : pixels){
            red = (255-(spot.getRed()));
            green = (255-(spot.getGreen()));
            blue = (255-(spot.getBlue()));
            spot.setRed(red);
            spot.setGreen(green);
            spot.setBlue(blue);
        }
        pic2.explore();
        
        pixels = pic3.getPixels();
        for (Pixel spot : pixels){
            red = (20+(spot.getRed()));
            green = (20+(spot.getGreen()));
            blue = (20+(spot.getBlue()));
            spot.setRed(red);
            spot.setGreen(green);
            spot.setBlue(blue);
        }
        pic3.explore();
        
        pixels = pic4.getPixels();
        for (Pixel spot : pixels){
            red = spot.getGreen();
            green = spot.getRed();
            blue = (spot.getBlue() + 20);
            spot.setRed(red);
            spot.setGreen(green);
            spot.setBlue(blue);
        }
        pic4.explore();
        
        pixels = pic5.getPixels();
        for (Pixel spot : pixels){
            int total = spot.getGreen() + spot.getRed() + spot.getBlue();
            int val = total/3;
            spot.setRed(val);
            spot.setGreen(val);
            spot.setBlue(val);
        }
        pic5.explore();
        
        pixels = pic6.getPixels();
        for (Pixel spot : pixels){
            if (spot.getRed() < 237 && spot.getRed() > 197){
                if (spot.getGreen() < 210 && spot.getGreen() > 170){
                    if (spot.getBlue() < 180 && spot.getBlue() > 140){
                         spot.setBlue(255);
                    }
                }
            }
        }
        pic6.explore();
    }
}
