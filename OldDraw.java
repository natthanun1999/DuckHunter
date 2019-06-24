import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Draw extends JPanel implements MouseListener, MouseMotionListener, ActionListener
{
    Duck duckPos[] = new Duck[9];

    ImageIcon duck[] = new ImageIcon[9];
    ImageIcon shoot = new ImageIcon("Images\\shoot.png");
    ImageIcon background = new ImageIcon("Images\\BG.png");
    ImageIcon backgroundC = new ImageIcon("Images\\BGC.png");

    int width, height;

    Timer time;

    public Draw(int width, int height)
    {
        this.width = width;
        this.height = height;

        Initialize();
    }

    public void Initialize()
    {
        time = new Timer(50, this);

        for (int n = 0; n < 9; n++)
        {
            duck[n] = new ImageIcon("Images\\Duck.gif");
            duckPos[n] = new Duck();
        }

        duckPos[0].setX(0);
        duckPos[0].setY((int)(Math.random() * 751));

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics g) 
    {
        super.paint(g);

        backgroundC.paintIcon(this, g, 0, 0);

        background.paintIcon(this, g, 0, 0);

        duck[0].paintIcon(this, g, duckPos[0].getX(), duckPos[0].getY());

        time.start();
    }

    public void Moved()
    {

    }

    public void actionPerformed(ActionEvent e) 
    {
        if (duckPos[0].getX() < width)
        {
            duckPos[0].setX(duckPos[0].getX() + 10);
        }
        else
        {
            int [] milisec = { 1000, 1500, 2000, 2500, 3000};
            int select = (int)(Math.random() * 5);

            long startTime = System.currentTimeMillis();

            while (true)
            {
                long now = System.currentTimeMillis();

                if(now - startTime >= milisec[select])
                {
                    System.out.println("Delay : " + ((float)(now - startTime) / (float)1000) + " sec.");

                    break;
                }
            }

            duckPos[0].setX(0);
        }

        repaint();
    }

    public void shoot(Graphics g, int x, int y)
    {
        shoot.paintIcon(this, g, x, y);
    }

    public boolean isInside(int Mx, int My, int x, int y, int w, int h)
    {
        if (Mx >= x && Mx <= w)
        {
            if (My >= y && My <= h)
            {
                return true;
            }
        }

        return false;
    }

    public void mouseClicked(MouseEvent e)
    {
        Graphics g = getGraphics();

        shoot(g, e.getX(), e.getY());
    }

    public void mouseDragged(MouseEvent e) { }

    public void mouseMoved(MouseEvent e) { }

    public void mousePressed(MouseEvent e) { }

    public void mouseReleased(MouseEvent e) { }

    public void mouseEntered(MouseEvent e) { }

    public void mouseExited(MouseEvent e) { }

}