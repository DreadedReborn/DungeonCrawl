import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Provides extreme attack at the cost of all defense + armor.
 * 
 * @author PC
 * @version gilgamesh
 */
public class ArtifactWeapon1 extends Weapon
{
    public int isWeapon = 0;
    
    public int attack = 10;
    public int defense = 0;
    public ArtifactWeapon1()
    {
        isArtifact = true;
    }
    /**
     * Act - do whatever the ArtifactWeapon1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        updateStats(attack, defense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);
    }    
}
