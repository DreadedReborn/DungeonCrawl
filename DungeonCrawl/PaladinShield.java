import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Artifact-tier shield, provides 14 defense. Does not curse player.
 * Created as a result of feedback from a player.
 * 
 * @author PC
 * @version rework2
 */
public class PaladinShield extends Shield
{
    public int isWeapon = 2;

    private int attack = 0;
    public PaladinShield()
    {
        weaponDefense = 14;
    }

    /**
     * Act - do whatever the PaladinShield wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        updateStats(attack, weaponDefense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);
    }    
}
