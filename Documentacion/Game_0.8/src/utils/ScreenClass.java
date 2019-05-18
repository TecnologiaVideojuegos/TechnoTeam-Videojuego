package utils;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Menu de creación del personaje
 * 
 *
 */

public class ScreenClass {

    public static int nrScreena = 0;

    public static void makeScreen(int bWspX, int bWspY) {
        try {

            double mouseX = MouseInfo.getPointerInfo().getLocation().getX() - bWspX;
            double mouseY = MouseInfo.getPointerInfo().getLocation().getY() - bWspY;

            Rectangle GAMEscreenRect = new Rectangle((int) mouseX, (int) mouseY, 1280, 720);

            BufferedImage capture = new Robot().createScreenCapture(GAMEscreenRect);

            float[] matrix = new float[400];
            for (int i = 0; i < 400; i++) {
                matrix[i] = 1.0f / 400.0f;
            }

            BufferedImageOp op = new ConvolveOp(new Kernel(20, 20, matrix), ConvolveOp.EDGE_NO_OP, null);
            BufferedImage capture1 = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
            nrScreena++;
            ImageIO.write(op.filter(capture, capture1), "png", new File("graphic/menu/skrin" + nrScreena + ".png"));
            if (nrScreena > 2) {
                deleteScreen();
            }

        } catch (AWTException aWTException) {
            System.out.println("Error en ScreenClass makeScreen aWTException");
        } catch (IOException iOException) {
            System.out.println("Error en ScreenClass makeScreen iOException");
        }
    }

    
    public static String screenNumber() {
        return "graphic/menu/skrin" + nrScreena + ".png";
    }

    public static void deleteScreen() {
        try {
            File file;
            for (int i = 0; i < nrScreena; i++) {
                file = new File("graphic/menu/skrin" + i + ".png");
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception - class:ScreenClass   methode:deleteScreen ");
        }
    }
}
