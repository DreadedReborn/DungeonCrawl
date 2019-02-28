package development;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class skeleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class skeleton extends Monster
{
    GifImage gifImage = new GifImage("skeletonidle.gif");
    public int eAttack = 3;
    public int eDefense = 1;
    public int eHealth = 4;
    /**
     * Act - do whatever the skeleton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(gifImage.getCurrentImage());
    }    

    /**
     * causes the enemy to take damage from an attack.
     */
    public void takeDamage(int dmg, greenfoot.Actor enemy)
    {
        eHealth = eHealth - (dmg - eDefense);
        if (eHealth <= 0)
        {
            getWorld().removeObject(this);
        }
    }

    public int getEnemyHealth()
    {
        return eHealth;
    }
}

