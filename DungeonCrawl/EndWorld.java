import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 * 
 * @author PC
 * @version placeholder
 */
public class EndWorld extends ActiveWorld
{

    /**
     * Constructor for objects of class EndWorld.
     * 
     */
    public EndWorld()
    {    
        // Create a new world with 10x10 cells with a cell size of 50x50 pixels.
        super(9, 11, 50); 
        prepare();
        // //musicloop.stop();
        // Greenfoot.playSound("win.mp3");
        setPaintOrder(ButtonEnd.class, Wall.class);
    }
    /*
    public void act()
    {
    musicAct();
    }
     */
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        winscreen winscreen = new winscreen();
        addObject(winscreen,4,3);
        ButtonEnd endbutton = new ButtonEnd();
        addObject(endbutton,4,8);
        Music music = new Music(true);
        addObject(music,1,1);
        Wall wall = new Wall(2);
        addObject(wall,5,8);
        Wall wall2 = new Wall(2);
        addObject(wall2,3,8);
    }
}
