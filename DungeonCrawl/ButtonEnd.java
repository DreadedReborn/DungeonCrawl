import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button that, when clicked, finishes the game. Replaces 'startbutton' on end screens.
 * 
 * @author PC
 * @version Shop Update
 */
public class ButtonEnd extends Actor
{
    /**
     * Act - do whatever the ButtonEnd wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
        public void act()
    {
        FinishGame();   
    }

    public void FinishGame()
    {
        World w = new StartWorld();
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(w);
        }               
    }
}
