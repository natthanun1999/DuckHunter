import java.awt.*;
import javax.swing.*;

public class Shoot extends JPanel
{
    private ImageIcon crosshair = new ImageIcon("Images\\Shoot.png");

    private int x, y;
    
    private boolean shot = false;

    public void update(int x, int y)
    {
        this.x = x;
        this.y = y;

        shot = true;
    }

    public void paint(Graphics g)
    {
        if (shot)
        {
            crosshair.paintIcon(this, g, x - (crosshair.getIconWidth() / 2), y - (crosshair.getIconHeight() / 2));

            shot = false;
        }
    }

    protected void finalize()
    {
        System.out.println("Crosshair Cleaned.");
    }
}