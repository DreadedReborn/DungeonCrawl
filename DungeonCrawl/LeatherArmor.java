import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tier 1 armor equipment. Provides 3 defense and 0 attack.
 * 
 * @author PC
 * @version tanned
 */
public class LeatherArmor extends Armor
{
    public int isWeapon = 1;
    public int attack = 0;
    public int defense = 3;

    /**
     * Act - do whatever the LeatherArmor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        updateStats(attack, defense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);
    }    
}
