import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tier-2 chest.
 * 
 * @author PC
 * @version polished and refined
 */
public class BronzeChest extends Chest
{
    /**
     * Act - do whatever the BronzeChest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {generateBronzeLoot();}    

    /**
     * Generates a random item and self-destructs the object when called.
     *
     */
    public void generateBronzeLoot()
    {
        if (isOpen){
            if (Greenfoot.getRandomNumber(100) <=30)
            {
                getWorld().addObject(new BronzeArmor(), getX(), getY());
            }
            else if (Greenfoot.getRandomNumber(100) <=30)
            { 
                getWorld().addObject(new GreatAxe(), getX(), getY());
            }
            else if (Greenfoot.getRandomNumber(100) <= 20)
            {
                getWorld().addObject(new GreatHammer(), getX(), getY());
            }
            else if (Greenfoot.getRandomNumber(100) <=30)
            {
                getWorld().addObject(new BronzeShield(), getX(), getY());
            }
            else if (Greenfoot.getRandomNumber(100) <=60)
            {
                getWorld().addObject(new HealthPotion(), getX(), getY());
            }
            else 
            {
                getWorld().addObject(new Gold(), getX(), getY());
            }
            getWorld().removeObject(this);
        }
    }
}
