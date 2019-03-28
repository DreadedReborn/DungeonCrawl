import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Holds the methods that all World subclasses may need and use.
 * 
 * @author PC
 * @version scream
 */
public abstract class ActiveWorld extends World
{
    public Counter goldcounter;
    private Actor skeleton;
    //public 
    public GreenfootSound musicloop = new GreenfootSound("crowdhammer.mp3");
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
    
    public void newFloor()
    {
    }
    public Actor getskeleton()
    {
        return skeleton;
    }
   
}
