import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tier-0 armor. Provides 0 attack and 0 defense.
 * 
 * @author PC
 * @version Ironed
 */
public class ClothArmor extends Armor
{
    public int isWeapon = 1;

    public int attack = 0;
    public ClothArmor()
    {
        defense = 1;
    }

    /**
     * Act - do whatever the ClothArmor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        if (isEquipped){updateStats(attack, defense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);}
    }    
}
