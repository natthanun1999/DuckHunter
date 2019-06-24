public class Position
{
    private int x, y;

    public Position()
    {
        setX(0);
        setY(0);
    }

    public Position(int x, int y)
    {
        setX(x);
        setY(y);
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
        System.out.println("Duck Position Cleaned.");
    }
}