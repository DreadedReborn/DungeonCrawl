import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Holds all "inanimate" classes that represent physical obstacles or tiles. 
 * 
 * @author PC
 * @version Shop Update
 */
public abstract class Turf extends Actor
{
    public int turfDifficulty;
    public int difficultylevel;

    public int getDifficulty()
    {
          return this.turfDifficulty;
    }

}
