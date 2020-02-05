import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class DrawGameAndKeyControlComponent extends JComponent implements KeyListener
{
    Master master;
    WatekRepaint w = new WatekRepaint();
    Thread t1 = new Thread(w);
    public DrawGameAndKeyControlComponent()
    {
        master = new Master();
        addKeyListener(this);
        t1.start();
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        master.drawEverything(g2d);
        if(master.gameOver(g2d)) {w.stopme();}
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(master.getWidth(),master.getHeight());
    }
    //////////////////////////////////////
    @Override
    public void keyPressed(KeyEvent keyEvent)
    {
        if(keyEvent.getKeyCode() == KeyEvent.VK_UP      || keyEvent.getKeyCode() == KeyEvent.VK_W)
            master.snakeControl(3);
        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN    || keyEvent.getKeyCode() == KeyEvent.VK_S)
            master.snakeControl(1);
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT    || keyEvent.getKeyCode() == KeyEvent.VK_A)
            master.snakeControl(2);
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT   || keyEvent.getKeyCode() == KeyEvent.VK_D)
            master.snakeControl(0);
    }
    @Override
    public void keyTyped(KeyEvent keyEvent) {}
    @Override
    public void keyReleased(KeyEvent keyEvent) {}
    @Override
    public boolean isFocusTraversable() {return true;}
//////////////////////////////////////////////////////////////////
class WatekRepaint implements Runnable
{
    private volatile boolean running;
    @Override
    public void run()
    {
        running = true;
        while (running)
        {
            try
            {
                Thread.sleep(25);
                repaint();
            }
            catch (InterruptedException e)
            {e.printStackTrace();}
        }
    }
    void stopme()
    {
        running = false;
    }
}
///////////////////////////////////////////////
    public void setImages(BufferedImage image_background, BufferedImage leftBorder, BufferedImage rightBorder, BufferedImage upBorder, BufferedImage downBorder, BufferedImage inTheCorner, BufferedImage imageSnakeHead,BufferedImage imageSnakeBody,BufferedImage imageFruit)
    {
        master.setPictures(image_background, leftBorder,rightBorder,upBorder,downBorder,inTheCorner,imageSnakeHead, imageSnakeBody, imageFruit);
    }
}
