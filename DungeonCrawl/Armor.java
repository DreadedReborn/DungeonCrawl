import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass of all armor equipment in the game.
 * 
 * @author PC
 * @version rework2
 */
public class Armor extends Equipment
{
    public boolean isArtifact = false;
    public int defense;
    public int findDefense()
    {
        return this.defense;
    }
}
