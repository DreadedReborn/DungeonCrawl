import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass for all Shield items.
 * 
 * @author PC
 * @version rework2
 */
public class Shield extends Equipment
{
    public boolean isArtifact = false;
    public int weaponDefense;
    public int findItemDefense()
    {
        return this.weaponDefense;
    }
}
