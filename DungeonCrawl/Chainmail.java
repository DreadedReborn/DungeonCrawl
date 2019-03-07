import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tier-2 armor. Provides 7 defense and 0 attack.
 * 
 * @author PC
 * @version rework2
 */
public class Chainmail extends Armor
{
    public int isWeapon = 1;
    public int attack = 0;
    public Chainmail()
    {
        defense = 7;
    }
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
