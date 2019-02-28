import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tier-1 Weapon. Provides 2 attack and 0 defense.
 * 
 * @author PC 
 * @version Blunt
 */
public class Knife extends Weapon
{
    public int isWeapon = 0;
    public int attack = 2;
    public int defense = 0;
    /**
     * Act - do whatever the Knife wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        updateStats(attack, defense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);
    }    
}
