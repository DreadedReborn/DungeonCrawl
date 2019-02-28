import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * What was once an attempt at Paladin armor, it is now a diving suit.
 * Provides extreme defense at the cost of current weapon.
 * 
 * @author PC
 * @version deep sea paladins
 */
public class ArtifactArmor1 extends Armor
{
    public int isWeapon = 1;
    public int attack = 0;
    public int defense = 15;
    public ArtifactArmor1()
    {
        isArtifact = true;
    }
    /**
     * Act - do whatever the ArtifactArmor1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        updateStats(attack, defense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);
    }    
}
