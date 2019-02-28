package development;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Player class represents the player's character in the world.
 * It is the primary method in which the player interacts with the world.
 * 
 * @author Jordan Lawrence 
 * @version 1.2
 */
public class Player extends Mob
{
    private World currentworld = (ActiveWorld) getWorld();
    //private ActiveWorld currentworld = (ActiveWorld) getWorld();
    private int Health = 5;
    private int Attack = 2;
    public int Defense = 3;
    private Counter goldcount;
    
    //private World[] currentFloor;

    GifImage gifImage = new GifImage("man01.gif");
    /**
     * Loads all of the maps.
     */
    private void loadMaps(){
        for (int i = 0; i < 7; i = 7){
            //currentFloor[i] = ;
        }
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * In theory and practice, it is an event loop.
     */
    public void act() 
    {
        movement();
        openDoor();
        setImage(gifImage.getCurrentImage());
    }     

    /**
     * Handle keyboard input.
     * Events are : Pressing the w key, a key, s key or d key.
     */
    //this is an event driven program because there are key components of an event driven program in the code (event handlers, trigger functions, etc)
    public void movement()
    {
        int d = 1;
        String key = Greenfoot.getKey();

        Actor leftCollide = getOneObjectAtOffset(-1, 0, Wall.class);
        Actor rightCollide = getOneObjectAtOffset(1, 0, Wall.class);
        Actor upCollide = getOneObjectAtOffset(0, -1, Wall.class);
        Actor downCollide = getOneObjectAtOffset(0, 1, Wall.class);
        Actor collideOnce = getOneIntersectingObject(Gold.class);
        Actor nextFloor = getOneIntersectingObject(Stairs.class);

        Actor leftEnemy = getOneObjectAtOffset(-1, 0, skeleton.class);
        Actor rightEnemy = getOneObjectAtOffset(0, -1, skeleton.class);
        Actor downEnemy = getOneObjectAtOffset(0, 1, skeleton.class);
        Actor upEnemy = getOneObjectAtOffset(1, 0, skeleton.class);
        //Actor Skeleton = currentworld.getskeleton();

        //Actor Enemy = getNeighbours(1, false, skeleton.class).get(0);

        if (leftCollide==null){ //trigger function
            if (leftEnemy==null){
                if ("a".equals(key)) {//another trigger function
                    setLocation(getX() - d, getY()); //event handler
                } 
            } 
            else if (leftEnemy!=null){
                {
                    //Skeleton.takeDamage(Attack);

                }
            }
        }
        if (downCollide==null){
            if (downEnemy==null){
                if ("s".equals(key)) {
                    setLocation(getX(),getY() + d);
                } 
            } 
            else if (downEnemy!=null){
                //Skeleton.takeDamage(Attack, Skeleton);

            }
        }
        if (rightCollide==null){
            if (rightEnemy==null){
                if("d".equals(key)) {
                    setLocation(getX() + d,getY());
                } 
            }
            else if (rightEnemy!=null){
                //Enemy.takeDamage(Attack);
            }
        }
        if (upCollide==null){
            if (upEnemy==null){
                if("w".equals(key)) {
                    setLocation(getX(),getY() - d);
                }
            }
            else if (upEnemy!=null){
                //Enemy.takeDamage(Attack);
            }
        }if (collideOnce != null){
                Counter goldcount = currentworld.getCounter();
            if (goldcount !=null){

                goldcount.addScore(5);
                getWorld().removeObject(collideOnce);
                boolean findgold = false;
                while (findgold = false)
                {
                    getWorld().addObject(new Gold(), Greenfoot.getRandomNumber(getWorld().getWidth()), Greenfoot.getRandomNumber(getWorld().getHeight()));
                    if (getOneIntersectingObject(Wall.class) == null)
                    {
                        findgold = true;
                    } else if (getOneIntersectingObject(Wall.class) != null)
                    {
                        getWorld().removeObject(this);
                    }

                }
            }
        }
        if (nextFloor != null){

        }

    }

    /**
     * Opens doors on the same tile as player.
     */
    public void openDoor()
    {
        Actor door = getOneObjectAtOffset(0, 0, DoorClosed.class);

        DoorOpened door2 = new DoorOpened();
        if (door != null)
        {
            getWorld().removeObject(door);
            getWorld().addObject(door2, getX(), getY());
        }
    }

}
