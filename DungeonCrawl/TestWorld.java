import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Debug area to make stuff work.
 * 
 * @author PC
 * @version procedural-and-persistent
 */
public class TestWorld extends ActiveWorld
{
    private Counter counter;
    //private Hotbar hotbar[] = new Hotbar[2];
    private Counter healthbar;
    private Counter difficultybar;

    private int wallX[] = new int[11];
    private int wallY[] = new int[12];
    //private DoorClosed doorclosed[] = new DoorClosed[15];
    //private Gold gold[] = new Gold[10];
    //private Skeleton Skeleton[] = new Skeleton[4];

    private int x; 
    private int y;
    private int z;
    public int prevscore;
    private int nextscore;
    public int prevhealth;
    private int nexthealth;

    private boolean stairsAdded = false; //Boolean, used to check whether or not stairs were added in the level generation.
    public boolean playerInWorld; //Boolean, used to check if Player.class exists in the world.
    public boolean bossLevel = false;
    private boolean bossSpawned = false;
    /*

    public TestWorld()
    {
    super(9, 11, 50); 
    setPaintOrder(Player.class, Counter.class, Skeleton.class, Gold.class, Stairs.class, Wall.class, DoorClosed.class);
    prepare();
    counter = new Counter("Gold: ");
    addObject(counter, 4, 9);
    playerInWorld = false;
    }*/
    /**
     * Constructor for objects of class TestWorld.
     * 
     */
    public TestWorld(boolean playerAlreadyhere, int prevscore, int prevhealth, int progressiveDifficulty)
    {    
        // Create a new world with 9x11 cells with a cell size of 50x50 pixels.
        super(9, 11, 50); 
        //Makes sure you can always see important classes.
        setPaintOrder(HitEffect.class, Player.class, Counter.class, Lich.class, Skeleton.class, Gold.class, Stairs.class, HealthPotion.class, SmallHealthPotion.class, Chest.class, Wall.class, DoorClosed.class);
        playerInWorld = playerAlreadyhere; //Boolean for checking if this world was made by a player and stairs or not.
        nextscore = prevscore; //Translates previous score from old level to new counter.
        counter = new Counter("Gold: ");
        addObject(counter, 6, 9);
        nexthealth = prevhealth; //Translates previous health from old level to new counter.
        healthbar = new Counter("Health: ");
        addObject(healthbar, 2 ,9);
        difficultybar = new Counter("Floor: "); 
        addObject(difficultybar, 4, 9);
        prepare(progressiveDifficulty);

    }
    /*
    private void generateArrays()
    {   
    x=0;
    for (x=0;x<=14;x++)
    {
    doorclosed[x] = new DoorClosed();
    }

    x=0;
    }
     */
    /**
     * Generates the current level for the player to go through.
     * Key items will always have a path available to them, along with gold, items, chests and enemies.
     * 
     */
    private void generateLevel(int progressiveDifficulty)
    {
        z=0;
        x=0;
        y=0;
        for (x=0;x<=9;x++)
        {
            wallX[x] = x;
        }
        x=0;
        for (x=0;x<=10;x++)
        {
            wallY[x] = x;
        }
        x=0;
        y=0;
        z=0;
        //I've used a 'for' loop to execute code several times to avoid repetition of code, thus making the code more efficient.
        // mfr explains use of iteration U6 P3
        for (y=0;y<=8;x++) //While Y is 0 to 8, do below code. Adds to X every execution.
        {   
            if (getObjectsAt(x, y, Wall.class).isEmpty()) //Checks if there is no instances of wall.class at the current X and Y values.
            {
                if (getObjectsAt(x,y,Floor.class).isEmpty()) { //Checks if there are no instances of floor.class at the current X and Y values.
                    if (getObjectsAt(x,y, DoorClosed.class).isEmpty()) { //Checks if there are no instances of doorclosed.class at the current X and Y values.
                        if (Greenfoot.getRandomNumber(100)<=10) //If a randomly-selected number is equal to, or smaller than, ten, execute below code.
                        {
                            addObject(new Wall(), wallX[x], wallY[y]); //Adds a wall to current X and Y values.
                        } else if (Greenfoot.getRandomNumber(100)<=10) //Otherwise, if randomly-selected number is equal to, or smaller than, ten, execute below code.
                        {
                            addObject(new DoorClosed(), wallX[x], wallY[y]); //Adds a closed door to current X and Y values.
                        }
                        else if (!stairsAdded){ //Otherwise, if the stairs have not been added yet, execute nested code.
                            if (Greenfoot.getRandomNumber(100)<=10){ //If randomly-selected number is equal to, or smaller than, ten, execute below code.
                                addObject(new Stairs(), wallX[x], wallY[y]); //Adds a stairs turf to the current X and Y values.
                                stairsAdded = true; //Turns the boolean stairsAdded to true.
                            }
                            else //Otherwise,
                            {
                                createFloor(progressiveDifficulty); //See documentation for method createFloor.
                            }   
                        }
                        else
                        {
                            createFloor(progressiveDifficulty); //See documentation for method createFloor.
                        }   
                    }
                }
            }
            if (x==8) //If X has reached the end of the playable space,
            {
                x=-1;
                y++;
            }
        }
        /*
         * This if statement is a safety check.
         * If stairs weren't added the entire generation process, they will spawn at the last possible tile.
         */
        if (!stairsAdded) {
            if (progressiveDifficulty != 21){
                addObject(new Stairs(), 8, 8);
            }
        }
    }

    /**
     * Used in method generateWorld.
     * Creates a floor at the current X and Y values, using the arrays wallX and wallY and the integers x and y.
     */
    public void createFloor(int progressiveDifficulty)
    {
        addObject(new Floor(), wallX[x], wallY[y]);
        if (progressiveDifficulty <= 10){
            newDifficulty1Floor(progressiveDifficulty);
        }
        if (progressiveDifficulty > 10){
            if (progressiveDifficulty <= 20){
                newDifficulty2Floor(progressiveDifficulty);
            }
        }
        if (progressiveDifficulty > 20)
        {
            FinalBossLevel();
        }
    }

    /**
     * Generates a level 1-10 floor.
     * Called in construction of a level.
     * 
     * @param Difficulty, as integer.
     */
    private void newDifficulty1Floor(int progressiveDifficulty)
    {
        if (Greenfoot.getRandomNumber(100)<20)
        {
            addObject(new Gold(), wallX[x], wallY[y]);
        }
        else if (Greenfoot.getRandomNumber(100)<10)
        {
            addObject(new Skeleton(Greenfoot.getRandomNumber(3) + progressiveDifficulty,Greenfoot.getRandomNumber(4) + progressiveDifficulty,Greenfoot.getRandomNumber(2) + progressiveDifficulty), wallX[x], wallY[y]);
        }
        else if (Greenfoot.getRandomNumber(100)<10)
        {
            addObject(new Chest(), wallX[x], wallY[y]);
        }
        else if (Greenfoot.getRandomNumber(10000)<20)
        {
            addObject(new ArtifactChest(), wallX[x], wallY[y]);
        }
    }

    /**
     * Generates a level 11-20 floor.
     * Called in construction of a level.
     * 
     * @param Difficulty, as integer.
     */
    private void newDifficulty2Floor(int progressiveDifficulty)
    {
        if (Greenfoot.getRandomNumber(100)<20)
        {
            addObject(new Gold(), wallX[x], wallY[y]);
        }
        else if (Greenfoot.getRandomNumber(100)<10)
        {
            addObject(new Skeleton(Greenfoot.getRandomNumber(10) + progressiveDifficulty,Greenfoot.getRandomNumber(3) + progressiveDifficulty,Greenfoot.getRandomNumber(3) + progressiveDifficulty), wallX[x], wallY[y]);
        }
        else if (Greenfoot.getRandomNumber(100)<15)
        {
            addObject(new HealthPotion(), wallX[x], wallY[y]);
        }
        else if (Greenfoot.getRandomNumber(100)<10)
        {
            addObject(new BronzeChest(), wallX[x], wallY[y]);
        }
        else if (Greenfoot.getRandomNumber(100)<20)
        {
            addObject(new SmallHealthPotion(), wallX[x], wallY[y]);
        }
        else if (Greenfoot.getRandomNumber(10000)<80)
        {
            addObject(new ArtifactChest(), wallX[x], wallY[y]);
        }
        else if (Greenfoot.getRandomNumber(500)<80)
        {
            addObject(new PaladinChest(), wallX[x], wallY[y]);
        } 
        else if (Greenfoot.getRandomNumber(300)<80)
        {
            addObject(new SteelChest(), wallX[x], wallY[y]);
        }
    }

    /**
     * Spawns the final boss's level, along with the boss itself. No stairs spawn on this level.
     */
    public void FinalBossLevel()
    {

        if (Greenfoot.getRandomNumber(100)<15)
        {
            addObject(new HealthPotion(), wallX[x], wallY[y]);
        }
        else if (Greenfoot.getRandomNumber(100)<20)
        {
            addObject(new SmallHealthPotion(), wallX[x], wallY[y]);
        }
        else if (Greenfoot.getRandomNumber(1000)<80)
        {
            addObject(new ArtifactChest(), wallX[x], wallY[y]);
        }
        else if (Greenfoot.getRandomNumber(250)<80)
        {
            addObject(new PaladinChest(), wallX[x], wallY[y]);
        }
        if (!bossSpawned){
            if (Greenfoot.getRandomNumber(40)<20){
                addObject(new Lich(), wallX[x], wallY[y]);
                bossSpawned = true;
            }
        }
        if (!bossSpawned){
            if (getObjects(Lich.class).size() == 0)
            {
                addObject(new Lich(), 8, 8);
                bossSpawned = true;
            }
        }
        bossLevel = true;
    }

    public Counter getCounter()
    {
        return counter;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare(int progressiveDifficulty)
    {
        //generateArrays();
        generateLevel(progressiveDifficulty);
        Player player = new Player();
        getCounter();
        prepareGUI();
        if (nextscore != 0)
        {
            if (counter != null)
            {
                counter.addScore(nextscore);
            }
        }
        if (nexthealth != 0)
        {
            if (healthbar != null)
            {
                healthbar.setscore(nexthealth);
            }
        }
        if (progressiveDifficulty != 0)
        {
            if (difficultybar != null) 
            {
                difficultybar.setscore(progressiveDifficulty);
            }
        }
        if (!playerInWorld){
            addObject(new Player(),6,6);
            addObject(new Knife(),6,6);
            addObject(new ClothArmor(),6,6);
            playerInWorld = true;
        }
    }

    /**
     * Used to prepare the hotbars for the player, and the walls that stop mobs from climbing all over it.
     */
    public void prepareGUI()
    {
        /*
         * for(x=0;x<=9;x++){
         *  addObject(new Wall(), x, 9);
         * }
         */
        addObject(new EmptyHotbar(), 4, 9);
        addObject(new Hotbar(), 4, 10);
    }

    /**
     * Used by Actors to get a reference to the healthbar object.
     * The object is a Counter.
     */
    public Counter getHealthBar()
    {
        return healthbar;
    }

    /**
     * Changes the displayed health in the health bar. This does not include a change, and should be used for setting the health at the start of the game.
     */
    public void renderHealth(int Health)
    {
        healthbar.setscore(Health);
    }

    /**
     * Changes the health in the health bar. This includes an animation for changing between states. This should be used for calculating damage during the game.
     * @param Health as Integer.
     */
    public void changeHealth(int Health, HealthPotion healthpotion)
    {
        int x;
        int y;
        Player player = (Player)getObjects(Player.class).get(0);
        if (player.Health != player.MaxHealth){ //Checks if the player has actually taken damage.
            x = player.Health;
            y = player.MaxHealth;
            if ((x+=Health) >= y){ //Checks if the new health value is over the max health.
                healthbar.setscore(player.MaxHealth);
                healthpotion.isBeingUsed = true;
            }
            else {
                healthbar.addScore(Health);
                player.Health += Health;
                healthpotion.isBeingUsed = true;
            }
        }
        else {
            healthpotion.isBeingUsed = false;
        }
    }

    /**
     * When called by a class, engages an entire "turn" for the map. This allows all classes with 'ActOnTurn' to perform actions.
     */
    public void Turn()
    {
        getObjects(Player.class).get(0).TurnActive = true;

        for (Skeleton skeleton : getObjects(Skeleton.class)) {
            //Skeleton.getTurnActive();
            skeleton.setTurnActive(true);
        }
        if (getObjects(Lich.class).size() != 0){
            if (getObjects(Lich.class).get(0) != null)
            {
                getObjects(Lich.class).get(0).setTurnActive(true);
            }
        }
    }

    //public void act()
    //{
    //generateLevel();
    //}
}
