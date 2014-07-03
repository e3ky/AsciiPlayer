import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageToASCII {

    public static void drawPixel(Color color) {
        int intensity = (color.getGreen() + color.getBlue() + color.getRed()) / 3;
        if (intensity > 240) {
            System.out.print(" ");
        } else if (intensity <= 240 && intensity > 200) {

            System.out.print(".");
        } else if (intensity <= 200 && intensity > 160) {
            System.out.print("*");
        } else if (intensity <= 160 && intensity > 120) {
            System.out.print("-");
        } else if (intensity <= 120 && intensity > 80) {
            System.out.print("@");
        } else if (intensity <= 80 && intensity > 40) {
            System.out.print("#");
        } else {
            System.out.print("OOOO");
        }

    }

    public static void main(String[] args) throws IOException {

        // drowImageInASCII(args);
        Scale(args);
    }

    private static void drowImageInASCII(String[] args) throws IOException {
        System.out.println(args[0]);
        BufferedImage buffImage = ImageIO.read((new File((args[0]))));
        // buffImage.
        for (int y = 0; y < buffImage.getHeight(); y++) {
            for (int x = 0; x < buffImage.getWidth(); x++) {
                Color currentPixel = new Color(buffImage.getRGB(x, y), false);
                drawPixel(currentPixel);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
            System.out.println();
        }
    }

    public static void Scale(String[] args) throws IOException {
        System.out.println(args[0]);
        BufferedImage buffImage = ImageIO.read((new File((args[0]))));

        int scaleY = buffImage.getHeight() / 200;
        int scaleX = buffImage.getWidth() / 50;

        for (int y = 0; y < buffImage.getHeight() - scaleY; y = y + scaleX) {
            for (int x = 0; x < buffImage.getWidth() - scaleX; x = x + scaleY) {

                int intensitySum = 0;
                for (int xLoop = x; xLoop < x + scaleX; xLoop++) {
                    for (int yLoop = y; yLoop < y + scaleY; yLoop++) {
                        Color curr = new Color(buffImage.getRGB(xLoop, yLoop), false);
                        intensitySum += (curr.getBlue() + curr.getGreen() + curr.getRed()) / 3;
                    }
                }
                int averageIntensity = intensitySum / (scaleX * scaleY);
                if (averageIntensity > 240) {
                    System.out.print(" ");
                } else if (averageIntensity <= 240 && averageIntensity > 200) {

                    System.out.print(".");
                } else if (averageIntensity <= 200 && averageIntensity > 160) {
                    System.out.print("*");
                } else if (averageIntensity <= 160 && averageIntensity > 120) {
                    System.out.print("-");
                } else if (averageIntensity <= 120 && averageIntensity > 80) {
                    System.out.print("@");
                } else if (averageIntensity <= 80 && averageIntensity > 40) {
                    System.out.print("#");
                } else {
                    System.out.print("%");
                }
            }
            System.out.println();
        }

    }
}
