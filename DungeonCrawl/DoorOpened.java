import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An opened door. Is purely visual, and closes itself after a certain period of time.
 * 
 * @author PC 
 * @version Shop Update
 */
public class DoorOpened extends Turf
{
    // private TestWorld currentWorld = (TestWorld)getWorld();
    public DoorOpened(int difficultylevel)
    {
        // if (getWorld() instanceof ActiveWorld)
        // {
            // // ActiveWorld currentWorld = 
            // int difficultylevel = currentWorld.getDifficulty();
            if (difficultylevel == 1)
            {
                // GreenfootImage wallOne = new GreenfootImage("Door_Open.png");
                this.setImage(new GreenfootImage("Door_Open.png"));
            }
            else if (difficultylevel == 2)
            {
                // GreenfootImage wallTwo = new GreenfootImage("Door_Open2.png");
                this.setImage(new GreenfootImage("Door_Open2.png"));
            }
            else if (difficultylevel == 3)
            {
                // GreenfootImage wallThree = new GreenfootImage("Door_Open3.png");
                this.setImage(new GreenfootImage("Door_Open3.png"));
            }
            turfDifficulty = difficultylevel;
        // }

    }
    
    public int inheritDifficulty()
    {
        return this.turfDifficulty;
    }

    /**
     * Act - do whatever the DoorOpened wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        doorClose();
    }    
    // int timeMax = 2000;
    int timer = 2000;
    /**
     * Automatically closes doors after a random amount of time.
     */
    public void doorClose()
    {
        DoorClosed door2 = new DoorClosed(this.inheritDifficulty());
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
