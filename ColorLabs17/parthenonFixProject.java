
/**
 * Write a description of class Parthenon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List;
public class parthenonFixProject
{
    public static void main(String[] args)
    {
        Picture apic = new Picture("images\\temple.jpg");
        Pixel[] pixels;
        pixels = apic.getPixels();
        mirrorVertical(apic);
    }
    public static void mirrorVertical(Picture apic){
        int width = apic.getWidth();
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        for (int y = 26; y < 137; y++){
            for (int x = 0; x < width / 2; x++){
                leftPixel = apic.getPixel(x, y);
                rightPixel = apic.getPixel((mirrorPoint + (mirrorPoint - x)), y);
                rightPixel.setColor(leftPixel.getColor());
            }
        }
        apic.explore();
    }
}