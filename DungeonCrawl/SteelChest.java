import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SteelChest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SteelChest extends Chest
{
    /**
     * Act - do whatever the SteelChest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        generateSteelLoot();
    }    
      public void generateSteelLoot()
    {
        if (isOpen) {
            if (Greenfoot.getRandomNumber(100) <=30)
            {
                getWorld().addObject(new SteelArmor(), getX(), getY());
            }
            else if (Greenfoot.getRandomNumber(100) <=30)
            {
                getWorld().addObject(new SteelShield(), getX(), getY());
            }
            else if (Greenfoot.getRandomNumber(100) <=30)
            {
                getWorld().addObject(new GreatAxe(), getX(), getY());
            }
            else if (Greenfoot.getRandomNumber(100) <=30)
            {
                getWorld().addObject(new GreatHammer(), getX(), getY());
            }
            else 
            {
                getWorld().addObject(new HealthPotion(), getX(), getY());
            }
            getWorld().removeObject(this);
        }
    }
}
