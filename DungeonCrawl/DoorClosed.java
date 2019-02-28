import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoorClosed here.
 * 
 * @author PC
 * @version 1.01
 */
public class DoorClosed extends Turf
{
    //broken because greenfoot can't handle this much animation (2cool4school)
    //GifImage gifImage = new GifImage("Door.gif");
    //private int timer = 100;
    public void act()
    {
        animate();
    }

    public void animate()
    {
        //if (timer == 0)
        // {
        // setImage(gifImage.getCurrentImage());
        // timer = 100;
    //}
    //timer--;
}
}
