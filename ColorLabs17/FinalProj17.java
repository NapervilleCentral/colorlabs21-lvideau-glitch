
/**
 * Write a description of class FinalProj17 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List; 
public class FinalProj17
{
    public static void main(String[] args)
    {
        Picture apic = new Picture("images\\The starry night.jpg");
        Picture canvas = new Picture("images\\Big.jpg");
        Pixel[] pixels;
        Pixel[] bixels;
        pixels = apic.getPixels();
        bixels = canvas.getPixels();
        copytoCanvas(apic, canvas, 1600, 1276);
        mirrorVertical(apic);
        copytoCanvas(apic, canvas, 0, 0);
    }
    public static void mirrorVertical(Picture apic){
        int width = apic.getWidth();
        int mirrorPoint = width/2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        for (int y = 0; y < apic.getHeight(); y++){
            for (int x = 0; x < width / 2; x++){
                leftPixel = apic.getPixel(x, y);
                rightPixel = apic.getPixel(width - 1 - x, y);
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    public static void copytoCanvas(Picture source, Picture target, int targX, int targY){
        Pixel sourcePix = null;
        Pixel targetPix = null;
        
        for(int sourceX = 0, targetX = targX; sourceX< source.getWidth(); sourceX++, targetX++){
            for(int sourceY = 0, targetY = targY; sourceY<source.getHeight(); sourceY++, targetY++){
                sourcePix = source.getPixel(sourceX, sourceY);
                targetPix = target.getPixel(targetX, targetY);
                targetPix.setColor(sourcePix.getColor());
                
            }
        }
        target.write("images/Canvas.jpg");
    }
}
