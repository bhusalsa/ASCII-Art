import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.Imaging;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        //This class will read the Image file
        File imagefile = new File("src/main/resources/pineapple.jpeg");


        ArrayList<ArrayList<int []>> colorInfo = new ArrayList<>();

        ImageInfo imageInfo = Imaging.getImageInfo(imagefile);

        int imageWidth = imageInfo.getWidth();
        int imageHeight = imageInfo.getHeight();


        System.out.println("Image Dimensions:");
        System.out.println("Image Width: " + imageWidth + "\nImage Height: " + imageHeight);

        BufferedImage bufferedImage = Imaging.getBufferedImage(imagefile);

        for( int y = 0; y < imageHeight; y++){
            ArrayList<int[]> color = new ArrayList<>();
            for( int x = 0; x < imageWidth; x++){

                int rgb = bufferedImage.getRGB(x,y);

                // Extract the individual color components (Red, Green, Blue)
                int red = (rgb >> 16) & 0xFF;   // Red is the most significant 8 bits
                int green = (rgb >> 8) & 0xFF;  // Green is the middle 8 bits
                int blue = rgb & 0xFF;          // Blue is the least significant 8 bits

                int[] pixelColor = {red,green,blue};

                color.add(pixelColor);
            }

            colorInfo.add(color);
        }

//        for (int y = 0; y < colorInfo.size(); y++) {
//            System.out.print("Row " + y + ": ");
//            for (int[] rgb : colorInfo.get(y)) {
//                System.out.print(Arrays.toString(rgb) + " ");
//            }
//            System.out.println();  // line break after each row
//        }

    }
}
