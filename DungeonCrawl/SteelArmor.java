import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *Tier-3 armor. Provides 0 attack and 12 defense.
 * 
 * @author PC 
 * @version rework2
 */
public class SteelArmor extends Armor
{
    public int isWeapon = 1;

    public int attack = 0;
    public SteelArmor()
    {
        defense = 12;
    }
    /**
     * Act - do whatever the SteelArmor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
            pickUpEquipment(isWeapon);
            updateStats(attack, defense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);
        
    }    
}
