import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tier-3 shield, provides 9 defense.
 * 
 * @author PC
 * @version rework2
 */
public class SteelShield extends Shield
{
    public int isWeapon = 2;

    private int attack = 0;
    public SteelShield()
    {
        weaponDefense = 9;
    }

    /**
     * Act - do whatever the SteelShield wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        updateStats(attack, weaponDefense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);
    }    
}
