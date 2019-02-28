package development;

import greenfoot.*;
/**
 * Write a description of class Startbutton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Startbutton extends Button
{
    /**
     * Constructor for objects of class Startbutton
     */
    public Startbutton()
    {
    }

    public void act()
    {
        StartGame();   
    }

    public void StartGame()
    {
        World11 w = new World11();
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(w);
        }               
    }
}
