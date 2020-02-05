import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class DrawSnake extends JPanel
{
    BufferedImage imageSnakeHead, imageSnakeBody, imageFruit;
    int width, height, pictureSize;
    SnakeCalculations Calc;
    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public DrawSnake(int width, int height, int pictureSize)
    {
        this.width=width; this.height=height; this.pictureSize=pictureSize;
        Calc = new SnakeCalculations(width,height,pictureSize);
    }
    public void setPictures(BufferedImage imageSnakeHead,BufferedImage imageSnakeBody,BufferedImage imageFruit)
    {
        this.imageSnakeHead=imageSnakeHead; this.imageSnakeBody=imageSnakeBody; this.imageFruit=imageFruit;
    }
    public void drawSnake(Graphics2D g2d)
    {
        g2d.drawImage(imageFruit,(Calc.getxFruit()*Calc.getPictureSize()),(Calc.getyFruit()*Calc.getPictureSize()),this);
        for (int i=2;i<=Calc.getSnakeSize();i++)
        {
            g2d.drawImage(imageSnakeBody,(Calc.snakeBody.get(i).x*Calc.getPictureSize()),(Calc.snakeBody.get(i).y*Calc.getPictureSize()),this);///Dodać gettery
        }
        g2d.drawImage(imageSnakeHead,(Calc.getxHeadPosition()*Calc.getPictureSize()),(Calc.getyHeadPosition()*Calc.getPictureSize()),this);
    }
    public void changeDirection(int controlCode){Calc.changeDirection(controlCode);}
    public int getSnakeSize() {return Calc.getSnakeSize();}
    public boolean gameOver() {return Calc.gameOver; }
}