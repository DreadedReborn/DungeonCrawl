import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tier-3 shield, provides 9 defense.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SteelShield extends Shield
{
    public int isWeapon = 2;
    private int weaponDefense = 9;
    private int attack = 0;
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
