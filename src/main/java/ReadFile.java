import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.Imaging;

import java.io.File;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        //This class will read the Image file
        File imagefile = new File("eggs.jpg");

        ImageInfo imageInfo = Imaging.getImageInfo(imagefile);

        int imageWidth = imageInfo.getWidth();
        int imageHeight = imageInfo.getHeight();

        System.out.println("Image Dimensions:");
        System.out.println("Image Width: " + imageWidth + "\nImage Height: " + imageHeight);
    }
}
