
/**
 * Write a description of class FinalProj17 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
public class FinalProj17
{
    public static void main(String[] args)
    {
        Picture apic = new Picture("images\\The starry night.jpg");
        Picture canvas = new Picture("images\\Big.jpg");
        //Pixel[] pixels;
        //Pixel[] bixels;
        //pixels = apic.getPixels();
        //bixels = canvas.getPixels();
        copytoCanvas(apic, canvas, 1610, 1277);
        mirrorVertical(apic);
        copytoCanvas(apic, canvas, 0, 0);
        apic = reset();
        SheparFairey(apic);
        copytoCanvas(apic, canvas, 0, 1277);
        apic = reset();
        blackwhite(apic);
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
    public static void SheparFairey(Picture apic){
        Pixel[] pixels = apic.getPixels();
        for(Pixel spot : pixels){
            int red;
            int blue;
            int green;
            int total = spot.getRed() + spot.getGreen() + spot.getBlue();
            if (total < (255*3/5)){
                red = 30;
                blue = 50;
                green = 30;
            } else if (total < (255*3*2/5)) {
                red = 23;
                green = 51;
                blue = 116;
            } else if (total < (255*3*3/5)) {
                red = 170;
                green = 57;
                blue = 57;
            } else if (total < (255*3*4/5)){
                red = 36;
                green = 88;
                blue = 126;
            } else {
                red = 255;
                green = 245;
                blue = 195;
            }
            spot.setRed(red);
            spot.setGreen(green);
            spot.setBlue(blue);
        }
    }
    public static void blackwhite(Picture apic){
        Pixel Pixel1 = null;
        Pixel Pixel2 = null;
        Pixel Pixel3 = null;
        Pixel Pixel4 = null;
        int color = 0;
        for (int y = 0; y < 1265; y+=2){
            for (int x = 0; x < apic.getWidth(); x+=2){
                Pixel1 = apic.getPixel(x, y);
                Pixel2 = apic.getPixel(x + 1, y);
                Pixel3 = apic.getPixel(x, y + 1);
                Pixel4 = apic.getPixel(x + 1, y + 1);
                int total1 = Pixel1.getRed() + Pixel1.getGreen() + Pixel1.getBlue();
                int total2 = Pixel2.getRed() + Pixel2.getGreen() + Pixel2.getBlue();
                int total3 = Pixel3.getRed() + Pixel3.getGreen() + Pixel3.getBlue();
                int total4 = Pixel4.getRed() + Pixel4.getGreen() + Pixel4.getBlue();
                double pureTotal = total1 + total2 + total3 + total4;
                double randomDouble = Math.random();
                double target = (255 * 3 * 2);
                double blockValue = pureTotal * randomDouble;
                if (blockValue > target){
                    color = 255;
                }
                Pixel1.setRed(color);
                Pixel1.setGreen(color);
                Pixel1.setBlue(color);
                Pixel2.setRed(color);
                Pixel2.setGreen(color);
                Pixel2.setBlue(color);
                Pixel3.setRed(color);
                Pixel3.setGreen(color);
                Pixel3.setBlue(color);
                Pixel4.setRed(color);
                Pixel4.setGreen(color);
                Pixel4.setBlue(color);
            }
        }
        apic.explore();
    }
    public static Picture reset(){
        return new Picture("images\\The starry night.jpg");
    }
}
