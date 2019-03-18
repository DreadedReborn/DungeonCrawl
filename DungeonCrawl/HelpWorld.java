import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpWorld extends World
{

    /**
     * Constructor for objects of class HelpWorld.
     * 
     */
    public HelpWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(9, 11, 50); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        ButtonMovement movementbutton = new ButtonMovement();
        addObject(movementbutton,2,4);
        ButtonStart startbutton = new ButtonStart();
        addObject(startbutton,5,9);
        startbutton.setLocation(4,9);
        ButtonWar warbutton = new ButtonWar();
        addObject(warbutton,4,6);
        ButtonPotion potionbutton = new ButtonPotion();
        addObject(potionbutton,6,4);
        startbutton.setLocation(4,7);
        
    }
}
