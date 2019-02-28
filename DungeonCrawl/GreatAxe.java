import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tier-3 Weapon. Provides 10 attack, but removes 1 defense.
 * Defense down has been temporarily removed.
 * 
 * @author PC 
 * @version rework
 */
public class GreatAxe extends Weapon
{
    
    public int attack = 10;
    public int defense = 0;

    /**
     * Act - do whatever the GreatAxe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        updateStats(attack, defense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);
    }    
}
