import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*; //Imports java's utility library.
//import greenfoot.greenfootSound.*; //Imports greenfootsound.

/**
 * The Player class represents the player's character in the world.
 * It is the primary method in which the player interacts with the world.
 * 
 * @author PC
 * @version Shop Update
 */
public class Player extends Mob
{
    private World currentworld = getWorld();
    private TestWorld gameWorld = (TestWorld) getWorld();

    GreenfootSound footstep = new GreenfootSound("step.mp3");
    GreenfootSound pickUp =  new GreenfootSound("player_pickup.mp3");
    GreenfootSound pickUpGold = new GreenfootSound("player_gold.mp3");
    GreenfootSound openChestSound = new GreenfootSound("player_chest.mp3");
    GreenfootSound attack = new GreenfootSound("player_attack.mp3");
    GreenfootSound hurt = new GreenfootSound("player_hurt.mp3");
    GreenfootSound die = new GreenfootSound("player_die.mp3");

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

    // public Item[] inv;
    //====================================================================================================

    /*
     * Temporary, really gross, should fix with array.
     */
    public Item inv1;
    public Item inv2;
    public Item inv3;
    public Item inv4;
    public Item inv5;
    public Item inv6;

    //====================================================================================================
    public Item invholder;
    // public Inventory inv2;
    private String keypressed;
    /*
     * Booleans for checking if a monster exists.
     */
    private boolean leftEnemyTrue;
    private boolean rightEnemyTrue;
    private boolean upEnemyTrue;
    private boolean downEnemyTrue;
    private boolean doorTrue;

    //====================================================================================================

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
        //inv = new Item[6];
        // inv2 = new Inventory();
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
        // openDoor();
        //setImage(gifImage.getCurrentImage());

    }     

    public void act()
    {
        String[] key = {"w","s","a","d","space"};
        keypressed = Greenfoot.getKey();
        int keychoose = 0;
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
            if (keypressed != null){
                for(keychoose=0; keychoose<5; keychoose++){
                    String keyselect = key[keychoose];

                    if (keypressed.equals(keyselect)){
                        TestWorld gameWorld = (TestWorld) getWorld();
                        gameWorld.Turn();
                    }
                }
                //p = 0;
                if (TurnActive = true)
                {
                    actOnTurn();
                }
            }
        }
        if (newWeapon){
            changeAnimation();
        }
        setImage(gifImage.getCurrentImage());
        checkWin();

        footstep.setVolume(20);
        pickUp.setVolume(80);
        pickUpGold.setVolume(20);
        openChestSound.setVolume(50);
        attack.setVolume(50);
        //musicAct();
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
        Actor closedDoor = getOneObjectAtOffset(0,0,DoorClosed.class);
        /*
         * Enemy detection
         */
        Monster leftEnemy = (Monster)getOneObjectAtOffset(-1, 0, Monster.class);
        Monster rightEnemy = (Monster)getOneObjectAtOffset(1, 0, Monster.class);
        Monster upEnemy = (Monster)getOneObjectAtOffset(0, -1, Monster.class);
        Monster downEnemy = (Monster)getOneObjectAtOffset(0, 1, Monster.class);
        //Actor Skeleton = currentworld.getskeleton();

        //Checks for enemies, and adds booleans based on their existance.

        if (getOneObjectAtOffset(-1, 0, Monster.class) instanceof Monster)
        {
            leftEnemyTrue = true;
        }
        else {
            leftEnemyTrue = false;
        }
        if (getOneObjectAtOffset(1, 0, Monster.class) instanceof Monster)
        {
            rightEnemyTrue = true;
        }
        else {
            rightEnemyTrue = false;
        }
        if ((Monster)getOneObjectAtOffset(0, -1, Monster.class) instanceof Monster)
        {
            upEnemyTrue = true;
        }
        else {
            upEnemyTrue = false;
        }
        if ((Monster)getOneObjectAtOffset(0, 1, Monster.class) instanceof Monster)
        {
            downEnemyTrue = true;
        }
        else {
            downEnemyTrue = false;
        }
        if ((DoorClosed)getOneIntersectingObject(DoorClosed.class) instanceof DoorClosed)
        {
            doorTrue = true;
        }
        else {
            doorTrue = false;
        }
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

        if (doorTrue)
        {
            openDoor();
        }
        
        if (leftCollide == null){ //trigger function
            if (leftEnemyTrue){
                if (keypressed.equals("a")){
                    leftEnemy.takeDamage(Attack, leftEnemy);
                    EndTurn();
                }
            } 
            else if (!leftEnemyTrue){
                if (keypressed.equals("a")) {//another trigger function
                    if (leftChest != null){
                        openChest(leftChest);

                        EndTurn();
                    }
                    else {
                        setLocation(getX() - d, getY()); //event handler
                        footstep.play();
                        EndTurn();
                    }
                } 
            } 
        }

        if (downCollide == null){
            if (hotbar == null){
                if (downEnemyTrue){
                    if (keypressed.equals("s")) {
                        downEnemy.takeDamage(Attack, downEnemy);
                        EndTurn();
                    }
                } 

                else if (!downEnemyTrue){
                    if (keypressed.equals("s")) {
                        if (downChest != null){
                            openChest(downChest);

                            EndTurn();
                        }
                        else {
                            setLocation(getX(),getY() + d);
                            footstep.play();
                            EndTurn();
                        }
                    }
                }
            }
        }
        if (rightCollide==null){
            if (!rightEnemyTrue){
                if(keypressed.equals("d")) {
                    if (rightChest != null){
                        openChest(rightChest);

                        EndTurn();
                    }
                    else {
                        setLocation(getX() + d,getY());
                        footstep.play();
                        EndTurn();
                    }
                } 
            }
            else if (rightEnemyTrue){
                if(keypressed.equals("d")) {
                    rightEnemy.takeDamage(Attack, rightEnemy);
                    EndTurn();
                }
            }
        }
        if (upCollide == null){
            if (!upEnemyTrue){
                if(keypressed.equals("w")) {
                    if (upChest != null){
                        openChest(upChest);

                        EndTurn();
                    }
                    else {
                        setLocation(getX(),getY() - d);
                        footstep.play();
                        EndTurn();
                    }
                }
            }
            else if (upEnemyTrue){
                if(keypressed.equals("w")) {
                    upEnemy.takeDamage(Attack, upEnemy);
                    EndTurn();
                }
            }

        }
        if (collideOnce != null){
            if (counter != null){
                pickUpGold.play();
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

        if (keypressed.equals("m"))
        {
            Music music = getWorld().getObjects(Music.class).get(0);
            music.checkToggle();
        }

        if (nextFloor != null){
            progressiveDifficulty++;
            newLevel(counter, currentworld, progressiveDifficulty);          

        }
    }
    /*
    /**
     * Gives the player the control to toggle music on/off.
     * Uses method toggleMusic.

    public void musicAct()
    {
    String musicKeyPressed = Greenfoot.getKey();
    if (musicKeyPressed == "m")
    {
    toggleMusic();
    }
    }
     */
    /*

    /**
     * Allows the music to be toggled on/off when called, based on boolean musicToggle.
     * See method musicAct for use.
    //
    public void toggleMusic()
    {
    GreenfootSound musicloop = gameWorld.getCurrentMusic();
    Boolean musicToggle = gameWorld.getMusicToggle();
    if (musicToggle){
    musicloop.playLoop();
    musicToggle = false;
    }
    else {
    musicloop.pause();
    musicToggle = true;
    }

    }
     */

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
        Music music = getWorld().getObjects(Music.class).get(0);
        Music music2 = new Music(music.getToggle());
        // music.getToggle();
        Greenfoot.setWorld(nextLevel);
    }

    /**
     * Adds an item to player inventory.
     * @param inventory, as Item.
     * @param itemNo, as int.
     */
    public void logToInventory(Item inventory, int itemNo)
    {
        // if (inv != null){
        // if (inv.length > -1){
        // if (inv[itemNo] != null)
        // {
        // // inv[itemNo] = new Item[itemNo](inventory);
        // // inv[itemNo] = inventory;
        // }
        // }
        // }
        //==========================
        //gross code below
        if (itemNo == 0)
        {
            inv1 = inventory;
        }
        if (itemNo == 1)
        {
            inv2 = inventory;
        }
        if (itemNo == 2)
        {
            inv3 = inventory;
        }
        if (itemNo == 3)
        {
            inv4 = inventory;
        }
        if (itemNo == 4)
        {
            inv5 = inventory;
        }
        if (itemNo == 5)
        {
            inv6 = inventory;
        }

    }

    /**
     * Transports player inventory across worlds. 
     * Should not be called in normal gameplay unless called by a level transfer method.
     * @param World
     */
    public void newLevelInventoryTransfer(World nextLevel)
    {
        int p = 0; //p acts as an indicator for the X axis in which the item currently is, and will be pushed to in the next level.
        // Item[] inv;
        // for (p = 0;p<6;p++){
        // inv[p] = getWorld().getObjectsAt(p,11,Item.class).get(p); //toArray(new Item[p]); //This converts the list of items currently held into an array, going along the X axis.
        // }
        // p = 0;
        // if (inv.length > -1){
        // if (inv.length > -1){
        // for(p=0;p<inv.length;p++)
        // {
        // // setLocation(p,11);
        // // invholder = (Item)getOneIntersectingObject(Item.class);
        // // try {
        // // Item[] inv = getWorld().getObjectsAt(p,11,Item.class).toArray(new Item[0]); //This converts the list of items currently held into an array, going along the X axis.
        // // inv = getWorld().getObjectsAt(p,11, Item.class).toArray(new inv[p]);
        // // } catch (Exception e){e.printStackTrace();}
        // // if (p != null)
        // // {
        // // if (inv.length > 0){
        // if (inv[p]!=null){invholder = inv[p]; } //If there is an item in the array, reference it under invholder.
        // // }
        // // }
        // if (invholder != null){ //If invholder isn't null, put it in the new level with the same x axis as before.
        // nextLevel.addObject(invholder, p, 11);
        // }
        // }
        // }
        // }
        if (inv1 != null){nextLevel.addObject(inv1, 0, 11);};
        if (inv2 != null){nextLevel.addObject(inv2, 1, 11);};
        if (inv3 != null){nextLevel.addObject(inv3, 2, 11);};
        if (inv4 != null){nextLevel.addObject(inv4, 3, 11);};
        if (inv5 != null){nextLevel.addObject(inv5, 4, 11);};
        if (inv6 != null){nextLevel.addObject(inv6, 5, 11);};
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
        openChestSound.play();
    }

    /**
     * Opens doors on the same tile as player.
     */
    public void openDoor()
    {
        int difficulty;
        DoorClosed door = (DoorClosed)getOneObjectAtOffset(0, 0, DoorClosed.class);
        if (door != null){
            difficulty = door.inheritDifficulty();
        }
        else 
        {
            difficulty = 1;
        }

        if (door != null)
        {
            DoorOpened door2 = new DoorOpened(difficulty);
            getWorld().removeObject(door);
            getWorld().addObject(door2, getX(), getY());
            // Greenfoot.playSound("death2.mp3");
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
        hurt.play();
        getWorld().addObject(new HitEffect(Integer.toString(x)), getX(), getY());
        if (Health <= 0)
        {
            getWorld().removeObject(this);
            World gameOver = new DeathWorld();
            Greenfoot.setWorld(gameOver);
            die.play();
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
                newWeapon = false;
            }
            else if (wornweapon instanceof Knife)
            {
                gifImage = new GifImage("man01knife.gif");
                newWeapon = false;
            }
            else if (wornweapon instanceof GreatAxe)
            {
                gifImage = new GifImage("man01greataxe.gif");
                newWeapon = false;
            }
        }
    }

    /**
     * Checks if the level is the final boss level. If so, checks if the Lich is dead.
     * Once both conditions are fulfilled, enter the Win screen.
     */
    private void checkWin()
    {
        TestWorld world = (TestWorld)getWorld();
        if (world.bossLevel)
        {
            if (world.getObjects(Lich.class).size() == 0)
            {
                World gameOver = new EndWorld();
                Greenfoot.setWorld(gameOver);
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
