import greenfoot.*;
/**
 * Write a description of class Startbutton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonStart extends Actor
{


    public void act()
    {
        StartGame();   
    }

    public void StartGame()
    {
        World w = new TestWorld(false, 5, 50, 1);
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(w);
        }               
    }
}
