import java.awt.*;
import javax.swing.*;

public class Menu extends JPanel
{
    private ImageIcon logo = new ImageIcon("Images\\Logo.png");

    public void paint(Graphics g)
    {
        logo.paintIcon(this, g, 390, 72);
    }

    protected void finalize()
    {
        System.out.println("Menu Cleaned.");
    }
}