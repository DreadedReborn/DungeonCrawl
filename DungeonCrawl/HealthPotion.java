import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Health Potion - Item/healing - Provides 25hp on use. Goes on hotbar.
 * 
 * @author PC 
 * @version 0.5
 */
public class HealthPotion extends Item
{

    public int healthRestored; //Variable that defines the amount of health the item regens. Default is 15.
    public boolean isBeingUsed;

    public HealthPotion() {
        healthRestored = 25;
    }

    /**
     * Act 
     */
    public void act() 
    {
        pickUp();
        discard();
        use(healthRestored);
    }    

    /**
     * Allows the item to be used.
     */
    public void use(int healthRestored)
    {
        if(getWorld() != null){
            if (getWorld() instanceof TestWorld){
                TestWorld world = (TestWorld)getWorld();
                if(beingUsed()==true)
                {
                    world.changeHealth(healthRestored, this);
                    if (isBeingUsed){
                        getWorld().removeObject(this);
                    }
                }
            }
        }
    }
}
