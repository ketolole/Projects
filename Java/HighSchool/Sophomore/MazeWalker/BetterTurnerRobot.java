
import kareltherobot.*;
public class BetterTurnerRobot extends Robot
{
    public BetterTurnerRobot(int st , int ave , Direction dir, int beeper)
    {
    super(st, ave, dir, beeper);
    }
    public void turnRight()
    {
    turnLeft();
    turnLeft();
    turnLeft();
    }
    public void turnAround()
    {
    turnLeft();
    turnLeft();
    }
    public void stepBackward()
    {
    turnAround();
    move();
    turnAround();
    }
}