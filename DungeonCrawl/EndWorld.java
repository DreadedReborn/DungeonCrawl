import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        super(10, 10, 50); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        winscreen winscreen = new winscreen();
        addObject(winscreen,5,4);
        winscreen.setLocation(4,4);
        ButtonStart startbutton = new ButtonStart();
        addObject(startbutton,5,7);
        startbutton.setLocation(5,7);
    }
}
