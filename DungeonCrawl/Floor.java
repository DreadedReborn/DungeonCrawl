import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Turf
{
    // private TestWorld currentWorld = (TestWorld)getWorld();
    public Floor(int difficultylevel)
    {
        // if (getWorld() instanceof ActiveWorld)
        // {
            // // ActiveWorld currentWorld = 
            // int difficultylevel = currentWorld.getDifficulty();
            if (difficultylevel == 1)
            {
                // GreenfootImage wallOne = new GreenfootImage("Door_Open.png");
                this.setImage(new GreenfootImage("Floor.png"));
            }
            else if (difficultylevel == 2)
            {
                // GreenfootImage wallTwo = new GreenfootImage("Door_Open2.png");
                this.setImage(new GreenfootImage("Floor2.png"));
            }
            else if (difficultylevel == 3)
            {
                // GreenfootImage wallThree = new GreenfootImage("Door_Open3.png");
                this.setImage(new GreenfootImage("Floor3.png"));
            }
            turfDifficulty = difficultylevel;
        // }
    }
}
