import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tier-4 melee weapon.
 * Provides 13 attack and 0 defense.
 * 
 * @author PC
 * @version rework
 */
public class GreatHammer extends Weapon
{
    public int isWeapon = 0;

    public int attack = 13;
    public int defense = 0;
    /**
     * Act - do whatever the GreatHammer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
       updateStats(attack, defense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);
    }    
}
