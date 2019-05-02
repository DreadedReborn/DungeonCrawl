import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A closed door. Opens when a living creature intersects with it. Purely cosmetic.
 * 
 * @author PC
 * @version Shop Update
 */
public class DoorClosed extends Turf
{
    //broken because greenfoot can't handle this much animation (2cool4school)
    //GifImage gifImage = new GifImage("Door.gif");
    //private int timer = 100;
    private TestWorld currentWorld = (TestWorld)getWorld();

    public DoorClosed(int difficultylevel)
    {
        // if (getWorld() instanceof ActiveWorld)
        // {
            // // ActiveWorld currentWorld = 
            // int difficultylevel = currentWorld.getDifficulty();
            if (difficultylevel == 1)
            {
                // GreenfootImage wallOne = new GreenfootImage("Door_Open.png");
                this.setImage(new GreenfootImage("Door.png"));
            }
            else if (difficultylevel == 2)
            {
                // GreenfootImage wallTwo = new GreenfootImage("Door_Open2.png");
                this.setImage(new GreenfootImage("Door2.png"));
            }
            else if (difficultylevel == 3)
            {
                // GreenfootImage wallThree = new GreenfootImage("Door_Open3.png");
                this.setImage(new GreenfootImage("Door3.png"));
            }
            turfDifficulty = difficultylevel;
        // }
    }

    // private void assignSprites()
    // {
    // if (difficultylevel
    // }

    public void act()
    {
        animate();
    }

    public void animate()
    {
        //if (timer == 0)
        // {
        // setImage(gifImage.getCurrentImage());
        // timer = 100;
        //}
        //timer--;
    }
}
