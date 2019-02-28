import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Player class represents the player's character in the world.
 * It is the primary method in which the player interacts with the world.
 * 
 * @author PC
 * @version 2
 */
public class Player extends Mob
{
    private World currentworld = getWorld();
    private TestWorld gameWorld = (TestWorld) getWorld();

    public int Health = 50;
    public int MaxHealth = 50;
    public int Attack = 1;
    public int Defense = 2;
    public int weaponDefense = 0;
    public int oldAttack;
    public int oldDefense;
    public int oldweaponDefense;
    public int totalDefense;
    private Counter counter;
    private Counter healthbar;
    public Armor wornarmor;
    public Weapon wornweapon;
    public Shield wornshield;

    public Item[] inv;

    public Item invholder;
    public Inventory inv2;

    public boolean isCursed = false;
    private boolean loadHealth = true;
    private boolean hasMoved = false;
    public boolean TurnActive = false;
    public boolean newWeapon = false;
    private int x = 25;
    private int timer = 0;
    public int progressiveDifficulty;

    //private World[] currentFloor;

    GifImage gifImage = new GifImage("man01sword.gif");

    private void Player()
    {
        inv = new Item[6];
        inv2 = new Inventory();
    }

    private void addedToWorld()
    {
        if (loadHealth)
        {
            TestWorld gameWorld = (TestWorld) getWorld();
            Counter healthbar = gameWorld.getHealthBar();
            healthbar.setscore(Health);
            loadHealth = false;
            progressiveDifficulty = 2;
        }

    }

    /**
     * ActOnTurn -An adjustment of the Act method, this method is only called when the player engages a turn by any means.
     * This will normally be called by a method in a world class.
     * In theory and practice, it is an event loop.
     */
    public void actOnTurn() 
    {

        totalDefense = Defense + weaponDefense;
        waitForMove();
        //movement();
        openDoor();
        //setImage(gifImage.getCurrentImage());

    }     

    public void act()
    {
        String key = Greenfoot.getKey();
        if (hasMoved){
            if (timer>=25)
            {
                timer = 0;
                hasMoved = false;
            }
            else
            {
                timer++;
            }
        }
        else {
            if (key != null){
                TestWorld gameWorld = (TestWorld) getWorld();
                gameWorld.Turn();
                //hasMoved = true;
            }
            if (TurnActive = true)
            {
                actOnTurn();
            }
        }
        changeAnimation();
        setImage(gifImage.getCurrentImage());
    }

    /**
     * Handle keyboard input.
     * Events are : Pressing the w key, a key, s key or d key.
     * 
     * Hosts multiple interactions the player can make with the environment, e.g. gold, doors, etc.
     */
    //this is an event driven program because there are key components of an event driven program in the code (event handlers, trigger functions, etc)
    public void movement()
    {
        int d = 1;
        //String key = Greenfoot.getKey();
        /*
         * Wall and floor detection
         */
        Actor leftCollide = getOneObjectAtOffset(-1, 0, Wall.class);
        Actor rightCollide = getOneObjectAtOffset(1, 0, Wall.class);
        Actor upCollide = getOneObjectAtOffset(0, -1, Wall.class);
        Actor downCollide = getOneObjectAtOffset(0, 1, Wall.class);
        Actor collideOnce = getOneIntersectingObject(Gold.class);
        Actor nextFloor = getOneIntersectingObject(Stairs.class);
        Actor hotbar = getOneObjectAtOffset(0,1,EmptyHotbar.class);
        /*
         * Enemy detection
         */
        Monster leftEnemy = (Monster)getOneObjectAtOffset(-1, 0, Monster.class);
        Monster rightEnemy = (Monster)getOneObjectAtOffset(1, 0, Monster.class);
        Monster upEnemy = (Monster)getOneObjectAtOffset(0, -1, Monster.class);
        Monster downEnemy = (Monster)getOneObjectAtOffset(0, 1, Monster.class);
        //Actor Skeleton = currentworld.getskeleton();
        /*
         * Interactable Object Detection
         */
        Chest leftChest = (Chest)getOneObjectAtOffset(-1, 0, Chest.class);
        Chest rightChest = (Chest)getOneObjectAtOffset(1, 0, Chest.class);
        Chest upChest = (Chest)getOneObjectAtOffset(0, -1, Chest.class);
        Chest downChest = (Chest)getOneObjectAtOffset(0, 1, Chest.class);

        /*
         * World and Abstract detection
         */
        World TestWorld = getWorld();
        TestWorld currentworld = (TestWorld)TestWorld;        
        Counter counter = currentworld.getCounter();

        //Actor Enemy = getNeighbours(1, false, Skeleton.class).get(0);

        if (leftCollide==null){ //trigger function
            if (leftEnemy==null){
                if (Greenfoot.isKeyDown("a")) {//another trigger function
                    if (leftChest != null){
                        openChest(leftChest);
                        EndTurn();
                    }
                    else {
                        setLocation(getX() - d, getY()); //event handler
                        EndTurn();
                    }
                } 
            } 
            else if (leftEnemy!=null){
                if (Greenfoot.isKeyDown("a")){
                    leftEnemy.takeDamage(Attack, leftEnemy);
                    EndTurn();
                }
            }
        } 
        if (downCollide==null){
            if (hotbar==null){
                if (downEnemy==null){
                    if (Greenfoot.isKeyDown("s")) {
                        if (downChest != null){
                            openChest(downChest);
                            EndTurn();
                        }
                        else {
                            setLocation(getX(),getY() + d);
                            EndTurn();
                        }
                    } 
                } 
                else if (downEnemy!=null){
                    if (Greenfoot.isKeyDown("s")) {
                        downEnemy.takeDamage(Attack, downEnemy);
                        EndTurn();
                    }
                }
            }
        }
        if (rightCollide==null){
            if (rightEnemy==null){
                if(Greenfoot.isKeyDown("d")) {
                    if (rightChest != null){
                        openChest(rightChest);
                        EndTurn();
                    }
                    else {
                        setLocation(getX() + d,getY());
                        EndTurn();
                    }
                } 
            }
            else if (rightEnemy!=null){
                if(Greenfoot.isKeyDown("d")) {
                    rightEnemy.takeDamage(Attack, rightEnemy);
                    EndTurn();
                }
            }
        }
        if (upCollide==null){
            if (upEnemy==null){
                if(Greenfoot.isKeyDown("w")) {
                    if (upChest != null){
                        openChest(upChest);
                        EndTurn();
                    }
                    else {
                        setLocation(getX(),getY() - d);
                        EndTurn();
                    }
                }
                else if (upEnemy!=null){
                    if(Greenfoot.isKeyDown("w")) {
                        upEnemy.takeDamage(Attack, upEnemy);
                        EndTurn();
                    }
                }
            }
        }
        if (collideOnce != null){
            if (counter !=null){

                counter.addScore(5);
                getWorld().removeObject(collideOnce);
                //boolean findgold = false;
                ///while (findgold = false)
                //{
                //getWorld().addObject(new Gold(), Greenfoot.getRandomNumber(getWorld().getWidth()), Greenfoot.getRandomNumber(getWorld().getHeight()));
                //if (getOneIntersectingObject(Wall.class) == null)
                //{
                //    findgold = true;
                //} else if (getOneIntersectingObject(Wall.class) != null)
                //{
                //getWorld().removeObject(this);
                //}

                //}
            }
        }

        if (nextFloor != null){
            progressiveDifficulty++;
            newLevel(counter, currentworld, progressiveDifficulty);          

        }

    }
    // The integer 'progressiveDifficulty' allows the game to continually become more difficult as the player progresses throughout the game.
    // This method (below) uses the integer to create a new level where the enemies are slightly stronger than the previous level.
    // This is using OOP structure to minimize code, thereby making the code efficient.
    // mfr U6 P5 M1 M2 U15 P2 M2 U22 D2 
    /**
     * Loads a new level, saving inventory items, health, and equipment.
     */
    public void newLevel(Counter counter, TestWorld currentworld, int progressiveDifficulty)
    {
        TestWorld gameWorld = (TestWorld) getWorld();
        Counter healthbar = currentworld.getHealthBar();
        World nextLevel = new TestWorld(true, counter.getscore(), healthbar.getscore(), progressiveDifficulty);
        nextLevel.addObject(this, 4, 5);
        newLevelInventoryTransfer(nextLevel);
        Greenfoot.setWorld(nextLevel);
    }

    /**
     * Transports player inventory across worlds. 
     * Should not be called in normal gameplay unless called by a level transfer method.
     * @param World
     */
    public void newLevelInventoryTransfer(World nextLevel)
    {
        int p = 0;

        for(p=0;p<=6;p++)
        {
            // setLocation(p,11);
            // invholder = (Item)getOneIntersectingObject(Item.class);
            // invholder = ;
            if (invholder != null){
                nextLevel.addObject(invholder, p, 11);
            }
        }
        if (wornweapon != null){nextLevel.addObject(wornweapon, 7, 11);}
        if (wornarmor != null){nextLevel.addObject(wornarmor, 10, 11);} 
        if (wornshield != null){nextLevel.addObject(wornshield, 6, 11);}
    }

    /**
     * Opens an adjacent chest when called.
     */
    public void openChest(Chest chest)
    {
        chest.openChest();
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

    /**
     * causes the enemy to take damage from an Attack.
     */
    public void takeDamage(int dmg, greenfoot.Actor enemy)
    {
        int x = 0;
        x = dmg - totalDefense;
        if (x < 0)
        {
            x = 0;
        }

        Health = Health - (x);
        TestWorld gameWorld = (TestWorld) getWorld();
        Counter healthbar = gameWorld.getHealthBar();
        healthbar.addScore(-x);
        getWorld().addObject(new HitEffect(Integer.toString(x)), getX(), getY());
        if (Health <= 0)
        {
            getWorld().removeObject(this);
            World gameOver = new EndWorld();
            Greenfoot.setWorld(gameOver);
        }
    }

    /**
     * Allows player to view their character's equipment and stats.
     * Uses multiple graphics to show the equipment and stats.
     * 
     */
    public void charactersheetaccess()
    {

    }

    /**
     * Used in conjunction with method "movement" to force the actor to wait between movement attempts. 
     * For actors that attempt to move every act() execution.
     */
    public void waitForMove()
    {
        if (TurnActive = true){
            movement();
        }
        else {
            if (timer>=25)
            {
                timer = 0;
                TurnActive = true;
            }
            else
            {
                timer++;
            }
        }
    }

    /**
     * Debug command. Raises the difficulty by 10. Occurs after a new level.
     */
    public void difficultyUp()
    {
        progressiveDifficulty += 9;
    }

    /**
     * Ends the Player's turn.
     */
    private void EndTurn()
    {

        TurnActive = false;
        hasMoved = true;
    }

    /**
     * Changes the player's animations based on currently equipped weapon.
     * Uses .gifs stored in /images/
     */
    private void changeAnimation()
    {
        if (newWeapon)
        {
            if (wornweapon instanceof Sword)
            {
                gifImage = new GifImage("man01sword.gif");
            }
            else if (wornweapon instanceof Knife)
            {
                gifImage = new GifImage("man01knife.gif");
            }
            else if (wornweapon instanceof GreatAxe)
            {
                gifImage = new GifImage("man01greataxe.gif");
            }
        }
    }
    /*
    /**
     * Allows player to store and use items they pick up in the game world.
     * Usable as long as player character is alive (with exceptions)
     */
    /*
    public void hotbaraccess()
    {

    }
     */
}
