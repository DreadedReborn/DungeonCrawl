import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World that is displayed at the start of the game.
 * 
 * @author PC
 * @version Shop Update
 */
public class StartWorld extends ActiveWorld
{    
     
    /**
     * Constructor for objects of class StartWorld.
     * 
     */
    public StartWorld()
    {    
        // Create a new world with 11x11 cells with a cell size of 50x50 pixels.

        super(9, 11, 50); 

        prepare();
        setPaintOrder(ButtonHelp.class, ButtonStart.class, Wall.class);
        GreenfootSound musicloop = new GreenfootSound("crowdhammer.mp3");
        //musicloop.playLoop();
        //musicloop.setVolume(40);
    }
    
  

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Wall wall = new Wall(1);
        addObject(wall,3,9);
        Wall wall2 = new Wall(1);
        addObject(wall2,5,9);
        Logo logo = new Logo();
        addObject(logo,4,3);
        ButtonStart buttonstart = new ButtonStart();
        addObject(buttonstart,4,7);
        ButtonHelp buttonhelp = new ButtonHelp();
        addObject(buttonhelp,4,9);
        Wall wall3 = new Wall(1);
        addObject(wall3,5,7);
        Wall wall4 = new Wall(1);
        addObject(wall4 ,3,7);
        Music music = new Music(true);
        addObject(music, 1, 1);
    }
}
