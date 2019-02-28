import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Skeleton is the first developed enemy of the game, and will be one of the first the player encounters.
 * It is an easy enemy to beat.
 * 
 * This class utilises Inheritance and Polymorphism for most, if not all, of it's methods.
 * Inheritance is where one class "inherits" (obtains the ability to use) a method, or set of methods, from a "parent" class.
 * This saves the developer time as they do not need to re-write the method that is being inherited.
 * 
 * Polymorphism is where
 * 
 * @author PC 
 * @version 1.1
 */
public class Skeleton extends Monster
{ 
    private GifImage gifImage;
    private int paintimer = 0;
    private boolean TurnActive = false;
    private int timer = 0;
    private boolean spritesSet = false;
    
    /**
     * If a skeleton is spawned without any parameters, it will default to these stats. Should not be called in normal gameplay.
     */
    public Skeleton()
    {
        eHealth = 15;
        eAttack = 4;
        eDefense = 1;
        isBoss = false;
    }

    /**
     * Used to create a second player for the game. Acts like a player for all intents and purposes.
     * Shares stats and health with player one due to limitations.
     * This constructor exists to provide an example of Polymorphism.
     * Polymorphism is where an object can take multiple forms, the most common example being that it is a "child" of a "parent" class.
     * 
     * The players are given bonus health as compensation.
     */
    public Skeleton(int health, int attack, int defense)
    {        
        eHealth = health;
        eAttack = attack;
        eDefense = defense;
        isBoss = false;
        sortSprites();
    }

    public boolean getTurnActive()
    {
        return TurnActive;
    }

    public void setTurnActive(boolean turnActive)
    {
        this.TurnActive = turnActive;
    }

    public void act()
    {
        if(TurnActive)
        {
            ActOnTurn();
        }
        setImage(gifImage.getCurrentImage());
    }

    /**
     * 
     * ActOnTurn -An adjustment of the Act method, this method is only called when the player engages a turn by any means.
     * This will normally be called by a method in a world class.
     */
    public void ActOnTurn() 
    {
        if(paintimer>=25)
        {
            if (takingDamage)
            {
                takingDamage = false;
                paintimer=0;
            }
            else {

            }
        }

        else 
        {
            paintimer++;
        }
        //waitformove(eAttack);
        movement(eAttack);
        openDoor();
        //spook();
        TurnActive = false;
    }    
    // mfr explains selection U6 P3
    /**
     * Sorts the skeleton's sprites based on it's stats using selection to determine the image.
     */
    public void sortSprites()
    {
        /*
        if (!spritesSet){
        if (eAttack <= 6){
        gifImage = new GifImage("basicskeletonidle.gif");
        spritesSet = true;
        }
        }
        if (!spritesSet){
        if (eDefense <= 6){
        gifImage = new GifImage("basicskeletonidle.gif");
        spritesSet = true;
        }
        }
         */
        if (!spritesSet){
            if (Greenfoot.getRandomNumber(100)>30){
                gifImage = new GifImage("skeletonidle.gif");
                spritesSet = true;
            }
        }
        /*
        if (!spritesSet){
        if (eAttack >= 7){
        gifImage = new GifImage("skeletonidle.gif");
        spritesSet = true;
        }
        }
         */
        if (!spritesSet){
            if (Greenfoot.getRandomNumber(100)>30){
                gifImage = new GifImage("leatherskeletonidle.gif");
                spritesSet = true;
            }
        }
        if (!spritesSet){
            gifImage = new GifImage("basicskeletonidle.gif");
            spritesSet = true;
        }
    }

    /**
     * Debug command.
     * Sets 'spritesSet' boolean to false.
     */
    public void resetSprites()
    {
        spritesSet = false;
    }

    public void spook()
    {
        if (timer>=100)
        {
            getWorld().addObject(new Skeleton(eHealth, eAttack, eDefense), this.getX(), this.getY());
            timer = 0;
        }
        else
        {
            timer++;
        }
    }
}

