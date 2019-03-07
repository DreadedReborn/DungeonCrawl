import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tier 2 shield. Provides 3 defense.
 * 
 * @author PC
 * @version rework2
 */
public class BronzeShield extends Shield
{
    public int isWeapon = 2;

    private int attack = 0;
    public BronzeShield()
    {
        weaponDefense = 3;
    }

    /**
     * Act - do whatever the BronzeShield wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        if (isEquipped){updateStats(attack, weaponDefense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);}
    }    
}
