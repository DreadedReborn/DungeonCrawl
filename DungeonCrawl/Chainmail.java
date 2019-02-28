import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tier-2 armor. Provides 5 defense and 0 attack.
 * 
 * @author PC
 * @version linked
 */
public class Chainmail extends Armor
{
    public int isWeapon = 1;
    public int attack = 0;
    public int defense = 5;

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
