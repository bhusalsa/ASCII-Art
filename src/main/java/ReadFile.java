import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.Imaging;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        //To Run the code from command line
        if (args.length == 0) {
            System.out.println("Please provide the image file path as an argument.");
            System.exit(1); // Exit if no argument is passed
        }

        String imagePath = args[0];  // Get the image file path from the command-line argument

        //This class will read the Image file
        //File imagefile = new File("src/main/resources/pineapple.jpeg");
        File imagefile = new File(imagePath);

        ArrayList<ArrayList<int []>> colorInfo = new ArrayList<>();

        int[] avgColor;

        ImageInfo imageInfo = Imaging.getImageInfo(imagefile);

        int imageWidth = imageInfo.getWidth();
        int imageHeight = imageInfo.getHeight();

        avgColor = new int[imageHeight * imageWidth];

        System.out.println("Image Dimensions:");
        System.out.println("Image Width: " + imageWidth + "\nImage Height: " + imageHeight);

        BufferedImage bufferedImage = Imaging.getBufferedImage(imagefile);

        int  i = 0 ;
        for( int y = 0; y < imageHeight; y++){
            ArrayList<int[]> color = new ArrayList<>();
            for( int x = 0; x < imageWidth; x++){

                int rgb = bufferedImage.getRGB(x,y);

                //ChatGPT code still don't understand what it is doing
                // Extract the individual color components (Red, Green, Blue)
                int red = (rgb >> 16) & 0xFF;   // Red is the most significant 8 bits
                int green = (rgb >> 8) & 0xFF;  // Green is the middle 8 bits
                int blue = rgb & 0xFF;          // Blue is the least significant 8 bits

                int[] pixelColor = {red,green,blue};

                int average = (red + green + blue)/3 ;

                avgColor[i++] = average;
                color.add(pixelColor);
                //System.out.println(average);
            }

            colorInfo.add(color);
        }

        String characters = "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";

        //System.out.println(characters.length());

        int count = 0;
        while ( count < avgColor.length)
        {
            double val = avgColor[count]/3.92;
            int num = (int) Math.ceil(val);
            System.out.print(characters.charAt(num));
//            System.out.print(characters.charAt(num));
//            System.out.print(characters.charAt(num));
            if (count % imageWidth == 0)
                System.out.println();
            count++;
        }

    }
}
