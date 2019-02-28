import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SteelArmor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SteelArmor extends Armor
{
    public int isWeapon = 1;

    public int attack = 0;
    public int defense = 10;
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
