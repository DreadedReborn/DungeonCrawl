package development;

mport greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoorOpened here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoorOpened extends Turf
{
    /**
     * Act - do whatever the DoorOpened wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        doorClose();
    }    
    int timeMax = 2000;
    int timer = Greenfoot.getRandomNumber(timeMax);
    /**
     * Automatically closes doors after a random amount of time.
     */
    public void doorClose()
    {
        DoorClosed door2 = new DoorClosed();
        if (timer == 0)
        {
            getWorld().addObject(door2, getX(), getY());
            getWorld().removeObject(this);
        }
        else {
            timer-- ;
        }
    }
}
