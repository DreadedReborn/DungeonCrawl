import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Turf
{
    // private TestWorld currentWorld = (TestWorld)getWorld();
    public Wall(int difficultylevel)
    {
        // TestWorld currentWorld = (TestWorld) getWorld();
        // World currentWorld = getWorld();
        // if (currentWorld != null)
        // {

            // // ActiveWorld currentWorld = 
            // int difficultylevel = currentWorld.getDifficulty();
            if (difficultylevel == 1)
            {
                // GreenfootImage wallOne = new GreenfootImage("Door_Open.png");
                this.setImage(new GreenfootImage("Wall.png"));
            }
            else if (difficultylevel == 2)
            {
                // GreenfootImage wallTwo = new GreenfootImage("Door_Open2.png");
                this.setImage(new GreenfootImage("Wall2.png"));
            }
            else if (difficultylevel == 3)
            {
                // GreenfootImage wallThree = new GreenfootImage("Door_Open3.png");
                this.setImage(new GreenfootImage("Wall3.png"));
            }
            turfDifficulty = difficultylevel;
        // }
    }

}
