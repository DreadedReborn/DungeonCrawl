import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tier-3 armor. Provides 0 attack and 9 defense.
 * 
 * @author PC
 * @version rework2
 */
public class BronzeArmor extends Armor
{
    public int isWeapon = 1;
    // public boolean isArtifact = false;
    public int attack = 0;

    public BronzeArmor()
    {
        defense = 9;
    }
    
    /**
     * Act - do whatever the BronzeArmor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        if (isEquipped){updateStats(attack, defense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);}
    }    
}
