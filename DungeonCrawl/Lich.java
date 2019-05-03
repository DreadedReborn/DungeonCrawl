import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The final boss of the game. Capable of spawning instances of 'Skeleton.class', and has the highest health, attack and defense of any current monster.
 * 
 * @author PC
 * @version almost fixed
 */
public class Lich extends Monster
{
    public int bossHealth = 60;
    public int bossAttack = 22;
    public int bossDefense = 14;
    private boolean TurnActive = false;
    private boolean hasSummoned = false;
    private int timer = 100;
    private int timer2 = 0;
    private GifImage gifImage = new GifImage("skeletonbossidle.gif");

    public Lich() {
        isBoss = true;
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
        if (!hasSummoned)
        {
            setImage(gifImage.getCurrentImage());
        }
        else if (timer2 == 100)
        {
            hasSummoned = false;
            timer2 = 0;
        }
        else 
        {
            timer2++;
        }
    }

    /**
     * 
     * ActOnTurn -An adjustment of the Act method, this method is only called when the player engages a turn by any means.
     * This will normally be called by a method in a world class.
     */
    public void ActOnTurn() 
    {
        movement(bossAttack);
        // openDoor();
        summonSkeletons();
        TurnActive = false;
    }    

    /**
     * Allows the Lich to summon Skeletons periodically.
     */
    private void summonSkeletons()
    {      
        if (timer>=50)
        {
            setImage("skeletonbosssummon.png");
            hasSummoned = true;
            getWorld().addObject(new Skeleton(20, 8, 4), this.getX() + Greenfoot.getRandomNumber(2)-1, this.getY()+ Greenfoot.getRandomNumber(2)-1);
            timer = 0;
        }
        else
        {
            timer++;
        }

    }

    /**
     * Returns the boss's health as an integer.
     * @return bossHealth, as integer.
     */
    public int getBossHealth()
    {
        return bossHealth;
    }

    /**
     * Returns the boss's deefense, as an integer.
     * @return bossDefense, as integer.
     */
    public int getBossDefense()
    {
        return bossDefense;
    }

    /**
     * Sets the boss's health.
     * Will be used by damage calculating methods in normal play.
     * @param newHealth, as integer.
     */
    public void setBossHealth(int newHealth)
    {
        bossHealth = newHealth;
    }

}
