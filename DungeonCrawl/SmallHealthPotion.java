import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Small Health Potion - Item/healing - Restores 10hp on use.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SmallHealthPotion extends HealthPotion
{
    public SmallHealthPotion()
    {
        healthRestored = 10;
    }
    
    /**
     * Act - do whatever the SmallHealthPotion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         pickUp();
        discard();
        use(healthRestored);
    }    
}
