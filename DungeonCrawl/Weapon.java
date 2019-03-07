import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass of all weapon-like items in the game.
 * 
 * @author PC
 * @version rework2
 */
public class Weapon extends Equipment
{
    public int isWeapon = 0;
    public int attack;
    public boolean isArtifact = false;
    public int findAttack()
    {
        return ((Weapon)this).attack;
    }
}
