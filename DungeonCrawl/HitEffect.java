import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Spawns when a mob takes damage. Displays the damage dealt on itself, and then deletes itself after a certain time threshold.
 * 
 * @author PC
 * @version minute to winit
 */
public class HitEffect extends UI
{
    private String damage;
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private int timelimit = 0;
    public HitEffect(String dealtdamage)
    {
        damage = dealtdamage;
        background = getImage();
    }

    /**
     * Act - do whatever the HitEffect wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        displayDamage();
        if (timelimit == 75)
        {
            selfDestruct();
        }
        else
        {
            timelimit++;
        }
    }    

    /**
     * Displays the damage dealt on the actor itself.
     */
    private void displayDamage()
    {
        GreenfootImage image;
        if ("0".equals(damage)) {
            image = new GreenfootImage("hiteffectnodmg.png");
        }
        else {
            image = new GreenfootImage("hiteffect.png");
        }
        GreenfootImage text = new GreenfootImage(damage, 22, Color.WHITE, transparent);

        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }

        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
            (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }

    /**
     * Removes the actor after a certain time limit, or other factors.
     */
    public void selfDestruct()
    {
        getWorld().removeObject(this);
    }
}
