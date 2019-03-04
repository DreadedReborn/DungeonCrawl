import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A chest that can contain randomly-generated loot.
 * 
 * @author PC
 * @version goodie bag
 */
public class Chest extends Item
{
    public boolean isOpen = false;
    /**
     * Act - do whatever the Chest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        generateLoot();
    }    

    /**
     * Called by another method to change a boolean in the object.
     * Specifically, changes the boolean 'isOpen' in this object to "open" the chest.
     */
    public void openChest()
    {
        isOpen = true;
    }

    /**
     * Generates a random item and self-destructs the object when called.
     * Due to the nature of calling classes, this cannot be efficiently made into an inheritable method.
     */
    public void generateLoot()
    {
        if (isOpen) {
            if (Greenfoot.getRandomNumber(100) <=30)
            {
                getWorld().addObject(new LeatherArmor(), getX(), getY());
            }
            else if (Greenfoot.getRandomNumber(100) <=30)
            { 
                getWorld().addObject(new Sword(), getX(), getY());
            }
            else if (Greenfoot.getRandomNumber(100) <= 20)
            {
                getWorld().addObject(new WoodShield(), getX(), getY());
            }

            else if (Greenfoot.getRandomNumber(100) <=60)
            {
                getWorld().addObject(new SmallHealthPotion(), getX(), getY());
            }
            else 
            {
                getWorld().addObject(new Gold(), getX(), getY());
            }
            getWorld().removeObject(this);
        }
    }
}

