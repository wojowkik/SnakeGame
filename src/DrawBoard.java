import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class DrawBoard extends JPanel
{
    private int width, height, pictureSize;
    public BufferedImage image_background, leftBorder,rightBorder,upBorder,downBorder,inTheCorner;
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public DrawBoard(int width, int height, int pictureSize)
    {
        this.width=width; this.height=height; this.pictureSize=pictureSize;
    }
    public void setPicures(BufferedImage image_background,BufferedImage leftBorder,BufferedImage rightBorder,BufferedImage upBorder,BufferedImage downBorder,BufferedImage inTheCorner)
    {
        this.image_background=image_background;
        this.leftBorder=leftBorder;
        this.rightBorder=rightBorder;
        this.upBorder=upBorder;
        this.downBorder=downBorder;
        this.inTheCorner=inTheCorner;
    }
    public void drawPlayground(Graphics2D g2d)
    {
        for(int i=pictureSize ; i<height-pictureSize ; i+=pictureSize)//for(int i=30 ; i<480-30 ; i+=30)  //wysokosc
        {
            for(int j=pictureSize ; j<width-pictureSize ; j+=pictureSize) //for(int j=30 ; j<480-30 ; j+=30)
            {
                g2d.drawImage(image_background,i,j,this); // szerokosc // plansza
            }
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////BORDER
        for(int i=0 ; i<width ; i+=pictureSize){g2d.drawImage(upBorder,i,0,this);}
        for(int i=0 ; i<width ; i+=pictureSize){g2d.drawImage(downBorder,i,height-pictureSize,this);}
        for(int i=0 ; i<height ; i+=pictureSize){g2d.drawImage(leftBorder,0,i,this);}
        for(int i=0 ; i<height ; i+=pictureSize){g2d.drawImage(rightBorder,width-pictureSize,i,this);}
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////CORNER
        g2d.drawImage(inTheCorner,0,0,this);
        g2d.drawImage(inTheCorner,width-pictureSize,0,this);
        g2d.drawImage(inTheCorner,0,height-pictureSize,this);
        g2d.drawImage(inTheCorner,width-pictureSize,height-pictureSize,this);
    }
}