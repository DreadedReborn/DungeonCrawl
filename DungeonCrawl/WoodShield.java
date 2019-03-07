import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tier 1 Shield, providing 1 defense.
 * 
 * @author PC
 * @version rework2
 */
public class WoodShield extends Shield
{
    public int isWeapon = 2;

    private int attack = 0;
    public WoodShield()
    {
        weaponDefense = 1;        
    }

    /**
     * Act - do whatever the WoodShield wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        if (isEquipped){updateStats(attack, weaponDefense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);}
    }    
}
