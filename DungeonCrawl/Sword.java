import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A basic, tier one sword. Gives 8 attack and 0 defense.
 * 
 * @author PC
 * @version rework2
 */
public class Sword extends Weapon
{
    public int isWeapon = 0;
    public int defense = 0;
    public Sword()
    {
        attack = 8;
    }

    /**
     * Act - do whatever the Sword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        updateStats(attack, defense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);
    }    
}
