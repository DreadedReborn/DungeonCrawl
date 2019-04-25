import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The end world, but you are dead and did not win.
 * 
 * @author PC
 * @version die
 */
public class DeathWorld extends ActiveWorld
{

    /**
     * Constructor for objects of class DeathWorld.
     * 
     */
    public DeathWorld()
    {
        super(9, 11, 50); 
        prepare();
        // //musicloop.stop();
        // Greenfoot.playSound("lose.mp3");
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
        notwinscreen notwinscreen = new notwinscreen();
        addObject(notwinscreen,4,3);
        ButtonStart startbutton = new ButtonStart();
        addObject(startbutton,4,8);

    }
}
