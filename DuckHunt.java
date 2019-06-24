import java.awt.*;
import javax.swing.*;

public class DuckHunt extends JFrame
{
    public DuckHunt()
    {
        super("Duck Hunt Games!");

        int width = 1610;
        int height = 1039;

        Draw draw = new Draw(width, height);

        add(draw);

        setFocusable(true);
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) 
    {
        new DuckHunt();
    }
}