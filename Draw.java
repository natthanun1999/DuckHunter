import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Draw extends JPanel implements Runnable, MouseListener, MouseMotionListener
{
    public Draw(int width, int height)
    {
        this.width = width;
        this.height = height;

        Initialize();
    }

    public void Initialize()
    {
        time = 30;

        duck1 = new DrawDuck();
        duck2 = new DrawDuck();
        duck3 = new DrawDuck();

        crosshair = new Shoot();

        addMouseListener(this);
        addMouseMotionListener(this);

        Thread thread = new Thread(this);
        thread.start();
    }

    public void Reset()
    {
        startTime = System.currentTimeMillis();

        time = 30;

        score = 0;

        duck1.setX(0);
        duck2.setX(0);
        duck3.setX(0);
    }

    public void run() 
    {
        while (true)
        {
            long now = System.currentTimeMillis();

            if (time != 0)
            {
                if (start)
                {
                    duck1.update(this);
                    duck2.update(this);
                    duck3.update(this);
                }

                repaint();
            }
            else if (time == 0)
            {
                int x;
                
                x = 100 + (int)(Math.random() * 201);

                duck1.setX(-x);

                x = 100 + (int)(Math.random() * 201);

                duck2.setX(-x);

                x = 100 + (int)(Math.random() * 201);

                duck3.setX(-x);
            }

            if (start)
            {
                if (time > 0)
                {
                    long elapse = (now - startTime);

                    flag = !flag;

                    if (flag)
                    {
                        if(elapse >= 1000 && ((elapse / 100) % 10) == 0)
                        {
                            time--;
                        }
                    }
                }
            }

            try 
            {
                Thread.sleep(50);
            } 
            catch (Exception e) { }
        }
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        backgroundC.paintIcon(this, g, 0, 0);

        background.paintIcon(this, g, 0, 0);
    }

    public void paint(Graphics g) 
    {
        super.paint(g);

        g.setColor(Color.WHITE);
        g.setFont(fontA);

        g.drawString("Score : " + score, 10, 40);

        g.setFont(fontB);
        g.drawString("Time : " + time, (width / 2) - 80, 40);

        g.setFont(fontC);
        g.drawString("Beta v1.0 | Created by Natthanun", 10, 986);

        if (start)
        {
            duck1.paint(g);
            duck2.paint(g);
            duck3.paint(g);

            crosshair.paint(g);
        }
        else
        {
            menu.paint(g);
            startBtn.paint(g);
            exitBtn.paint(g);
        }

        //End
        if (time == 0 && start)
        {
            restartBtn.paint(g);
        }
    }

    public void Exit()
    {
        duck1 = null;
        duck2 = null;
        duck3 = null;

        crosshair = null;

        menu = null;

        startBtn = null;
        restartBtn = null;
        exitBtn = null;

        background = null;
        backgroundC = null;

        System.gc();

        System.exit(0);
    }

    public void mouseReleased(MouseEvent e) 
    { 
        if (e.getButton() == 1)
        {
            //Bang Crosshair
            util.playSounds("Sounds\\Shot.wav");
            
            crosshair.update(e.getX(), e.getY());

            //Menu
            if (util.isInside(e.getX(), e.getY(), startBtn))
            {
                start = true;
            }

            if (util.isInside(e.getX(), e.getY(), exitBtn) && !start)
            {
                Exit();
            }

            //Duck
            if (util.isInside(e.getX(), e.getY(), duck1))
            {
                util.playSounds("Sounds\\Duck.wav");

                duck1.setX(width + 50);

                score++;
            }
            else if (util.isInside(e.getX(), e.getY(), duck2))
            {
                util.playSounds("Sounds\\Duck.wav");

                duck2.setX(width + 50);

                score++;
            }
            else if (util.isInside(e.getX(), e.getY(), duck3))
            {
                util.playSounds("Sounds\\Duck.wav");
                
                duck3.setX(width + 50);

                score++;
            }

            //Restart
            if (util.isInside(e.getX(), e.getY(), restartBtn) && time == 0)
            {
                start = false;

                Reset();
            }
        }
    }

    public void mouseClicked(MouseEvent e) { }

    public void mouseDragged(MouseEvent e) { }

    public void mouseMoved(MouseEvent e) { }

    public void mousePressed(MouseEvent e) { }

    public void mouseEntered(MouseEvent e) { }

    public void mouseExited(MouseEvent e) { }

    private ImageIcon background = new ImageIcon("Images\\BG.png");
    private ImageIcon backgroundC = new ImageIcon("Images\\BGC.png");

    private Menu menu = new Menu();
    private Btn startBtn = new Btn("Images\\Start.png", 605, 448);
    private Btn restartBtn = new Btn("Images\\Restart.png", 605, 448);
    private Btn exitBtn  = new Btn("Images\\Exit.png", 605, 638);

    private int width, height;
    private int score = 0;
    private int time = 0;

    private Font fontA = new Font("Tahoma", Font.BOLD, 26);
    private Font fontB = new Font("Tahoma", Font.BOLD, 36);
    private Font fontC = new Font("Tahoma", Font.PLAIN, 18);

    private DrawDuck duck1, duck2, duck3;
    private Shoot crosshair;

    private Utilities util = new Utilities();

    private long startTime;
    private boolean flag = false;
    private boolean start = false;
}