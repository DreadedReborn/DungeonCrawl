import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonHelp extends Actor
{
    /**
     * Act - do whatever the HelpButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        StartHelp();   
    }

    public void StartHelp()
    {
        HelpWorld w = new HelpWorld();
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(w);
        }               
    }   
}
