import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainForm {
    private JPanel mainPanel;
    private DrawGameAndKeyControlComponent drawGameAndKeyControlComponent1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents()
    {
        // TODO: place custom component creation code here
        drawGameAndKeyControlComponent1 = new DrawGameAndKeyControlComponent();
        BufferedImage image_background, leftBorder,rightBorder,upBorder,downBorder,inTheCorner,imageSnakeHead, imageSnakeBody, imageFruit;
        try
        {
            image_background = ImageIO.read(new File("src\\images\\tlo.png"));
            leftBorder = ImageIO.read(new File("src\\images\\w_prawo.png"));
            rightBorder = ImageIO.read(new File("src\\images\\w_lewo.png"));
            upBorder = ImageIO.read(new File("src\\images\\w_dol.png"));
            downBorder = ImageIO.read(new File("src\\images\\w_gore.png"));
            inTheCorner = ImageIO.read(new File("src\\images\\rog.png"));
            imageSnakeHead = ImageIO.read(new File("src\\images\\glowa.png"));
            imageSnakeBody = ImageIO.read(new File("src\\images\\cialo.png"));
            imageFruit = ImageIO.read(new File("src\\images\\jablko.png"));
            drawGameAndKeyControlComponent1.setImages(image_background, leftBorder,rightBorder,upBorder,downBorder,inTheCorner,imageSnakeHead, imageSnakeBody, imageFruit);
        }
        catch (IOException ex) {
            System.out.println("Blad odczytu");
            System.exit(0);
        }
    }
}
