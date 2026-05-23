
import kareltherobot.*;

public class Driver implements Directions
{
    public static void main(String[] args)  
    {
        MazeWalker alpha = new MazeWalker(1,1,North,4);
        
        while (!alpha.nextToABeeper()){
                alpha.followWallRight();
        }


        alpha.turnOff();

    }

    static
    {
        World.reset();
        World.setDelay(2);
        World.readWorld("fig6-26.kwld");  
        World.setVisible(true);        
    }
}