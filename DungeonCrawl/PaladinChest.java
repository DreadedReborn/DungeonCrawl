import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PaladinChest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PaladinChest extends Chest
{
    /**
     * Act - do whatever the PaladinChest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        generatePaladinLoot();
    }    
     public void generatePaladinLoot()
    {
        if (isOpen) {
            if (Greenfoot.getRandomNumber(100) <=30)
            {
                getWorld().addObject(new PaladinArmor(), getX(), getY());
            }
            else if (Greenfoot.getRandomNumber(100) <=30)
            {
                getWorld().addObject(new PaladinSword(), getX(), getY());
            }
            else 
            {
                getWorld().addObject(new PaladinShield(), getX(), getY());
            }
            getWorld().removeObject(this);
        }
    }
}
