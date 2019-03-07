import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Provides extreme attack at the cost of all defense + armor.
 * 
 * @author PC
 * @version rework2
 */
public class ArtifactWeapon1 extends Weapon
{
    public int isWeapon = 0;
    
    public int defense = 0;
    public ArtifactWeapon1()
    {
        isArtifact = true;
        attack = 10;
    }
    /**
     * Act - do whatever the ArtifactWeapon1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        if (isEquipped){updateStats(attack, defense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);}
    }    
}
