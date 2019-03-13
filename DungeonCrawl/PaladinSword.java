import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Artifact Weapon - Paladin Sword - 20 attack. Does not curse the owner.
 * 
 * @author PC
 * @version rework
 */
public class PaladinSword extends Weapon
{
    public int isWeapon = 0;
    public int defense = 0;
    private GifImage gifimage;

    public PaladinSword()
    {
        gifimage = new GifImage("paladinsword.gif");
        attack = 20;
    }

    /**
     * Act - do whatever the PaladinSword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pickUpEquipment(isWeapon);
        if (isEquipped){updateStats(attack, defense, findOldAttack(), findOldDefense(), isWeapon, isArtifact);}
        playGif();
    }    

    private void playGif()
    {
        if (gifimage != null)
        {
            setImage(gifimage.getCurrentImage());
        }
    }
}
