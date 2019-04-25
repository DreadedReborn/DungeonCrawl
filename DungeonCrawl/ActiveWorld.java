import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Holds the methods that all World subclasses may need and use.
 * 
 * @author PC
 * @version Shop Update
 */
public abstract class ActiveWorld extends World
{
    public Counter goldcounter;
    private Actor skeleton;
    //public 

    /**
     * Constructor for objects of class ActiveWorld.
     * 
     */
    public ActiveWorld(int width, int height, int cellsize)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, cellsize); 
    }

    public Counter returnCounter()
    {
        return goldcounter;
    }
    /*
    public GreenfootSound getCurrentMusic()
    {
    return musicloop;
    }
     */
    /*
    public Boolean getMusicToggle()
    {
    return musicToggle;
    }
     */

    
    public void newFloor()
    {
    }

    public Actor getskeleton()
    {
        return skeleton;
    }

}
