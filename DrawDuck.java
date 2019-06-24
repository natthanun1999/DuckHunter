import java.awt.*;
import javax.swing.*;

public class DrawDuck extends JPanel
{
    private Position duckPos = new Position();

    private ImageIcon duck = new ImageIcon("Images\\Duck.gif");

    private boolean first = true;

    private int x;

    public void update(Draw draw)
    {
        x = 100 + (int)(Math.random() * 201);

        if (first)
        {
            first = false;

            duckPos.setX(-x);
            duckPos.setY((int)(Math.random() * 751));
        }

        if (duckPos.getX() < draw.getWidth() + 50)
        {
            duckPos.setX(duckPos.getX() + 10);
        }
        else
        {
            first = true;

            duckPos.setX(-x);
        }
    }

    public void paint(Graphics g)
    {
        duck.paintIcon(this, g, duckPos.getX(), duckPos.getY());
    }

    public int getWidth()
    {
        return duck.getIconWidth();
    }

    public int getHeight()
    {
        return duck.getIconHeight();
    }

    public void setX(int x)
    {
        duckPos.setX(x);
    }

    public void setY(int y)
    {
        duckPos.setY(y);
    }

    public int getX()
    {
        return duckPos.getX();
    }

    public int getY()
    {
        return duckPos.getY();
    }

    protected void finalize()
    {
        System.out.println("Duck Body Cleaned.");
    }
}