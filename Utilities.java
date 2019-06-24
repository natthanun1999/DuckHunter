import java.io.*;
import javax.sound.sampled.*;

public class Utilities
{
    public Utilities() { }

    public boolean isInside(int Mx, int My, DrawDuck duck)
    {
        int x, y;
        int width, height;

        x = duck.getX();
        y = duck.getY();
        width = duck.getWidth();
        height = duck.getHeight();

        if (Mx >= x && Mx <= (x + width))
        {
            if (My >= y && My <= (y + height))
            {
                return true;
            }
        }

        return false;
    }

    public boolean isInside(int Mx, int My, Btn btn)
    {
        int x, y;
        int width, height;

        x = btn.getX();
        y = btn.getY();
        width = btn.getWidth();
        height = btn.getHeight();

        if (Mx >= x && Mx <= (x + width))
        {
            if (My >= y && My <= (y + height))
            {
                return true;
            }
        }

        return false;
    }

    public void playSounds(String location)
    {
        File shot = new File(location);

        try
        {
            Clip sounds = AudioSystem.getClip();

            sounds.open(AudioSystem.getAudioInputStream(shot));

            sounds.start();
        }
        catch (Exception e) { }
    }

    protected void finalize()
    {
        System.out.println("Utilities Cleaned.");
    }
}