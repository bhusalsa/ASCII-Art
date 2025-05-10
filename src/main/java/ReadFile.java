import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.Imaging;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        //This class will read the Image file
        File imagefile = new File("src/main/resources/pineapple.jpeg");

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


//        int count = 0;
//        // Create a PrintWriter to write to the text file
//        try (PrintWriter writer = new PrintWriter(new File("output.txt"))) {
//            // Loop through avgColor and print to both console and file
//            while (count < avgColor.length) {
//                double val = avgColor[count] / 3.92;
//                int num = (int) Math.ceil(val);
//
//                // Write the characters to the file
//                writer.print(characters.charAt(num));
//                writer.print(characters.charAt(num));
//                writer.print(characters.charAt(num));
//
//                // Add a new line to the file if necessary
//                if ((count + 1) % imageWidth == 0) {
//                    writer.println();
//                }
//
//                count++;
//            }
//            System.out.println("ASCII art saved to output.txt");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        for (int y = 0; y < colorInfo.size(); y++) {
//            System.out.print("Row " + y + ": ");
//            for (int[] rgb : colorInfo.get(y)) {
//                System.out.print(Arrays.toString(rgb) + " ");
//            }
//            System.out.println();  // line break after each row
//        }

//        while ( i < (imageHeight * imageWidth))
//            System.out.print(Arrays.toString(avgColor) + " ");

    }
}
