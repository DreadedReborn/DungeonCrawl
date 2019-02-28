package development;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartWorld extends World
{

    /**
     * Constructor for objects of class StartWorld.
     * 
     */
    public StartWorld()
    {    
        // Create a new world with 11x11 cells with a cell size of 50x50 pixels.
        super(11, 11, 50); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Startbutton startbutton = new Startbutton();
        addObject(startbutton,5,7);
        startbutton.setLocation(5,7);
        startbutton.setLocation(5,7);
        DoorClosed doorclosed = new DoorClosed();
        addObject(doorclosed,4,7);
        DoorClosed doorclosed2 = new DoorClosed();
        addObject(doorclosed2,6,7);
        doorclosed.setLocation(4,8);
        doorclosed2.setLocation(6,7);
        doorclosed.setLocation(4,7);
    }
}
