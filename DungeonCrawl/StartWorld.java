import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World that is displayed at the start of the game.
 * 
 * @author PC
 * @version  beginning of the end
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
        super(11, 11, 50); 
        prepare();
        setPaintOrder(ButtonHelp.class, ButtonStart.class, DoorClosed.class, DoorOpened.class);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        DoorOpened dooropened = new DoorOpened();
        addObject(dooropened,4,8);
        DoorOpened dooropened2 = new DoorOpened();
        addObject(dooropened2,6,8);
        Logo logo = new Logo();
        addObject(logo,5,3);
        ButtonStart buttonstart = new ButtonStart();
        addObject(buttonstart,5,7);
        ButtonHelp buttonhelp = new ButtonHelp();
        addObject(buttonhelp,5,9);
        buttonstart.setLocation(5,8);
        buttonhelp.setLocation(5,9);
        DoorClosed doorclosed = new DoorClosed();
        addObject(doorclosed,6,9);
        DoorClosed doorclosed2 = new DoorClosed();
        addObject(doorclosed2,4,9);
    }
}
