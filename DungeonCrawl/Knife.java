import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tier-1 Weapon. Provides 4 attack and 0 defense.
 * 
 * @author PC 
 * @version rework
 */
public class Knife extends Weapon
{
    public int isWeapon = 0;
    public int defense = 0;
    public Knife()
    {
        attack = 6;
    }

    /**
     * Act - do whatever the Knife wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        if (isEquipped){updateStats(attack, defense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);}
    }    
}
