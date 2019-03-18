import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MoveIndicator is a UI element that appears at the start of a new game. It will appear over the player character, and slowly fade over time.
 * 
 * @author PC 
 * @version tutorialising
 */
public class MoveIndicator extends UI
{
    //private int timer = 50;
    
    GifImage gifimage = new GifImage("movementvisuals.gif");
    /**
     * Act - do whatever the IngameMovementTutorial wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(gifimage.getCurrentImage());
        trackPlayer();
        for (int timer = 150; timer <= 0; timer--){
            fadeOut();
        }
    }    

    /**
     * Slowly turns the UI element into a completely invisible state, and then deletes it.
     */
    private void fadeOut()
    {
        int x;
        GreenfootImage image = gifimage.getCurrentImage();

        for (x = 255; x <= 0; x--)
        {
            image.setTransparency(x);
        }
        if (x == 0)
        {
            getWorld().removeObject(this);
        }
    }

    /**
     * Keeps the UI element over the Player for the duration of it's existence.
     */
    private void trackPlayer()
    {
        Player player = getWorld().getObjects(Player.class).get(0);
        if (player != null){
            setLocation(player.getX(), player.getY());
        }
    }
}
