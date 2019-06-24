import java.awt.*;
import javax.swing.*;

public class Btn extends JPanel
{
    private ImageIcon button;

    private int x, y;

    public Btn(String location, int x, int y)
    {
        button  = new ImageIcon(location);

        this.x = x;
        this.y = y;
    }

    public void update(Draw draw) { }

    public void paint(Graphics g)
    {
        button.paintIcon(this, g, x, y);
    }

    public int getWidth()
    {
        return button.getIconWidth();
    }

    public int getHeight()
    {
        return button.getIconHeight();
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    protected void finalize()
    {
        System.out.println("Button Cleaned.");
    }
}