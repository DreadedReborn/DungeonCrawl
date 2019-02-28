package development;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpWorld extends World
{

    /**
     * Constructor for objects of class HelpWorld.
     * 
     */
    public HelpWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(10, 10, 50); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        MovementButton movementbutton = new MovementButton();
        addObject(movementbutton,2,4);
        Player player = new Player();
        addObject(player,3,9);
        player.setLocation(5,8);
        skeletonButton skeletonbutton = new skeletonButton();
        addObject(skeletonbutton,7,4);
    }
}
