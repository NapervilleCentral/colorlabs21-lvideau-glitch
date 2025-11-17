
/**
 * Write a description of class SheparFaireyLab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class SheparFaireyLab
{
    /**
     * main method, to test the picture
     *  
     */
    public static void main(String[] args)
    {
        /**
         * 3, 31, 96
         * 170, 57, 57
         * 36, 88, 126
         * 255, 245, 195
         */
         //opens selfie picture 
        /**
         String fileName = FileChooser.pickAFile();
         Picture pictObj = new Picture(fileName);
         pictObj.explore();
         /**/
         //relative path
         Picture apic = new Picture("images\\Selfie.jpg");
         Picture me = new Picture("images\\Selfie.jpg");
         Picture me1 = new Picture("images\\Selfie.jpg");
         Picture me2 = new Picture("images\\Selfie.jpg");
         
        Pixel[] pixels;
        pixels = apic.getPixels(); 
        int red, blue, green, total, bucket, min = 255, max = 0;
        
        pixels = apic.getPixels();
        for (Pixel spot : pixels){
            total = spot.getRed() + spot.getGreen() + spot.getBlue();
            if (total < (255*3/4)){
                red = 3;
                green = 31;
                blue = 96;
            } else if (total < (255*3/2)) {
                red = 170;
                green = 57;
                blue = 57;
            } else if (total < (255*3*3/4)) {
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
            if (total < min){
                min = total;
            }
            if (total > max){
                max = total;
            }
        }
        apic.explore();
        apic.write("images/Selfie2.jpg");
        
        pixels = me1.getPixels();
        for (Pixel spot : pixels){
            total = spot.getRed() + spot.getGreen() + spot.getBlue();
            if (total < (min + ((max-min)/4))){
                red = 10;
                blue = 30;
                green = 10;
            } else if (total < (min + ((max-min)/2))) {
                red = 10;
                green = 70;
                blue = 140;
            } else if (total < (min + ((max-min)*3/4))) {
                red = 10;
                green = 70;
                blue = 200;
            } else {
                red = 255;
                green = 0;
                blue = 0;
            }
            spot.setRed(red);
            spot.setGreen(green);
            spot.setBlue(blue);
        }
        me1.explore();
        me1.write("images/Selfie3.jpg");
         
        
        pixels = me.getPixels();
        for (Pixel spot : pixels){
            total = spot.getRed() + spot.getGreen() + spot.getBlue();
            if (total < (255*3/4)){
                red = 10;
                blue = 30;
                green = 10;
            } else if (total < (255*3/2)) {
                red = 10;
                green = 70;
                blue = 140;
            } else if (total < (255*3*3/4)) {
                red = 10;
                green = 70;
                blue = 200;
            } else {
                red = 255;
                green = 0;
                blue = 0;
            }
            spot.setRed(red);
            spot.setGreen(green);
            spot.setBlue(blue);
        }
        me.explore();
        me.write("images/Selfie1.jpg");
         
    }//main       
}//class
