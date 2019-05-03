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
        notwinscreen notwinscreen = new notwinscreen();
        addObject(notwinscreen,4,3);
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
