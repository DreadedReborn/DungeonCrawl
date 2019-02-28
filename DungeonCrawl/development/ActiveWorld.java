package development;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ActiveWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ActiveWorld extends World
{
    private Counter goldcounter;
    private Actor skeleton;
    /**
     * Constructor for objects of class ActiveWorld.
     * 
     */
    public ActiveWorld(int width, int height, int cellsize)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, cellsize); 
    }

    public Counter getCounter()
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
