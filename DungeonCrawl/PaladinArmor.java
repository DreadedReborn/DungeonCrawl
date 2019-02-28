import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Artifact Armor - Paladin Armor. Provides 20 defense, planned bonus against Undead enemies.
 * 
 * @author PC
 * @version rework
 */
public class PaladinArmor extends Armor
{
    public int isWeapon = 1;
    public int attack = 0;
    public int defense = 20;
    /**
     * Act - do whatever the PaladinArmor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        updateStats(attack, defense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);
    }    
}
