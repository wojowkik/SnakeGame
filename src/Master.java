import java.awt.*;
import java.awt.image.BufferedImage;

public class Master
{
    private int width=720, height=720; public int getWidth(){return width;} public int getHeight(){return height;}
    protected DrawBoard map;
    private DrawSnake snake;
    Master()
    {
        int pictureSize=30;
        map= new DrawBoard(width,height,pictureSize);
        snake = new DrawSnake(width,height,pictureSize);
    }
    public void drawEverything(Graphics2D g2d)
    {
        map.drawPlayground(g2d);
        snake.drawSnake(g2d);
    }
    public void snakeControl(int controlCode)
    {
        snake.changeDirection(controlCode);
    }
    public boolean gameOver(Graphics2D g2d)
    {
        if(snake.gameOver())
        {
            g2d.setColor(Color.RED);
            g2d.fillRect(0,0,height,width);
            g2d.setColor(Color.BLACK);
            g2d.drawString("Game Over", (width/2)-20, height/2);
            g2d.drawString("Wynik: "+snake.getSnakeSize(), (width/2)-20, (height/2)+20);
            return true;
        }
        else return false;
    }
    public void setPictures(BufferedImage image_background, BufferedImage leftBorder, BufferedImage rightBorder, BufferedImage upBorder, BufferedImage downBorder, BufferedImage inTheCorner,BufferedImage imageSnakeHead,BufferedImage imageSnakeBody, BufferedImage imageFruit)
    {
        map.setPicures(image_background, leftBorder,rightBorder,upBorder,downBorder,inTheCorner);
        snake.setPictures(imageSnakeHead,imageSnakeBody,imageFruit);
    }
}
