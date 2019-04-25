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
        setPaintOrder(ButtonHelp.class, ButtonStart.class, DoorClosed.class, DoorOpened.class);
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
        DoorOpened dooropened = new DoorOpened(1);
        addObject(dooropened,3,9);
        DoorOpened dooropened2 = new DoorOpened(1);
        addObject(dooropened2,5,9);
        Logo logo = new Logo();
        addObject(logo,4,3);
        ButtonStart buttonstart = new ButtonStart();
        addObject(buttonstart,4,7);
        ButtonHelp buttonhelp = new ButtonHelp();
        addObject(buttonhelp,4,9);
        DoorClosed doorclosed = new DoorClosed(1);
        addObject(doorclosed,5,7);
        DoorClosed doorclosed2 = new DoorClosed(1);
        addObject(doorclosed2,3,7);
        Music music = new Music(true);
        addObject(music, 1, 1);
    }
}
