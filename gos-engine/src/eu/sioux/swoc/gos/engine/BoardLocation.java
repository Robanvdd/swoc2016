package eu.sioux.swoc.gos.engine;

public class BoardLocation
{
	public BoardLocation(int x, int y)
	{
        if (!IsLegal(x, y))
        {
            throw new IllegalArgumentException("not a legal board location");
        }
		
		X = x;
		Y = y;
	}
	
	public final int X;
	public final int Y;
	
	public static boolean IsLegal(int x, int y)
	{
		return x >= 0 && x < 9 && y >= 0 && y < 9 &&
				(x - y) < 5 && (y - x) < 5 && (x != 4 || y != 4);
	}
}