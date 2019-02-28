import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * High-tier chest containing Artifact equipment and items.
 * 
 * @author PC
 * @version gilgamesh and iron giant
 */
public class ArtifactChest extends Chest
{
    /**
     * Act - do whatever the ArtifactChest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        generateArtifactLoot();
    }    

    public void generateArtifactLoot()
    {
        if (isOpen) {
            if (Greenfoot.getRandomNumber(100) <=30)
            {
                getWorld().addObject(new ArtifactArmor1(), getX(), getY());
            }
            else if (Greenfoot.getRandomNumber(100) <=30)
            {
                getWorld().addObject(new ArtifactWeapon1(), getX(), getY());
            }
            else 
            {
                
            }
            getWorld().removeObject(this);
        }
    }
}
