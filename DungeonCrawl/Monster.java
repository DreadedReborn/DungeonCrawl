import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class is abstract, thus it serves to host all the game's enemies as subclasses and provide methods through inheritance.
 * 
 * @author PC 
 * @version 0.7
 */
public abstract class Monster extends Mob
{
    public int x = 0;
    public int eAttack;
    public int eDefense;
    public int eHealth;
    public boolean takingDamage;
    public boolean isBoss;

    private int health;
    private int defense;
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

    public int getEnemyHealth()
    {
        return eHealth;
    }

    public int getEnemyDefense()
    {
        return eDefense;
    }

    /**
     * Causes the enemy to take damage from an attack.
     * Inherited by any living monster that needs to be able to take damage.
     */
    public void takeDamage(int dmg, greenfoot.Actor enemy)
    {
        if (getWorld().getObjects(Lich.class).size() != 0)
        {
            Lich lich = getWorld().getObjects(Lich.class).get(0);

            health = lich.getBossHealth();
            defense = lich.getBossDefense();
            if (dmg - defense < 0)
            {
                health = health;
            }
            else {
                health = health - ( dmg - defense);
            }
            getWorld().addObject(new HitEffect(Integer.toString(dmg)), getX(), getY());

            if (health <= 0)
            {

                health = lich.getBossHealth();
                defense = lich.getBossDefense();
                if (dmg - defense < 0)
                {
                    health = health;
                }
                else {
                    health = health - ( dmg - defense);
                }
                getWorld().addObject(new HitEffect(Integer.toString(dmg)), getX(), getY());

                if (health <= 0)
                {

                    if (lich.isBoss){ //If the monster is a boss enemy
                        health = lich.getBossHealth();
                        defense = lich.getBossDefense();
                        if (dmg - defense < 0)
                        {
                            health = health;
                        }
                        else {
                            health = health - ( dmg - defense);
                        }
                        getWorld().addObject(new HitEffect(Integer.toString(dmg)), getX(), getY());

                        if (health <= 0)
                        {

                            if (Greenfoot.getRandomNumber(100)>=60)
                            {
                                getWorld().addObject(new Gold(), getX(), getY());
                            }
                            getWorld().removeObject(this);
                        }
                        else {
                            lich.setBossHealth(health);
                        }
                    }
                }
            }
        }
        else {
            if (dmg - eDefense < 0)
            {
                eHealth = eHealth;
                dmg = 0;
            }
            else {
                eHealth = eHealth - ( dmg - eDefense);
            }
            //GifImage gifimage = new GifImage(damagedEnemy);
            //setImage(gifimage.getCurrentImage());]
            getWorld().addObject(new HitEffect(Integer.toString(dmg - eDefense)), getX(), getY());
            takingDamage = true;

            if (eHealth <= 0)
            {

                if (Greenfoot.getRandomNumber(100)>=60)
                {
                    getWorld().addObject(new Gold(), getX(), getY());
                }
                getWorld().removeObject(this);
            }
        }

    }

    /**
     * Allows the actor to move about the world, showing concern for the impassable terrain around it.
     * It should be used in conjunction with the "waitformove" method, otherwise enemies will move as fast as the game speed is.
     */
    public void movement(int attack)
    {
        int d = 1;

        Actor leftCollide = getOneObjectAtOffset(-1, 0, Wall.class);
        Actor rightCollide = getOneObjectAtOffset(1, 0, Wall.class);
        Actor upCollide = getOneObjectAtOffset(0, -1, Wall.class);
        Actor downCollide = getOneObjectAtOffset(0, 1, Wall.class);
        /*
        Actor leftupCollide = getOneObjectAtOffset(-1, 1, Wall.class);
        Actor rightupCollide = getOneObjectAtOffset(1, 1, Wall.class);
        Actor leftdownCollide = getOneObjectAtOffset(-1, -1, Wall.class);
        Actor rightdownCollide = getOneObjectAtOffset(1, -1, Wall.class);
         */
        Actor hotbar = getOneObjectAtOffset(0, 1, EmptyHotbar.class);
        Player leftEnemy = (Player)getOneObjectAtOffset(-1, 0, Player.class);
        Player rightEnemy = (Player)getOneObjectAtOffset(1, 0, Player.class);
        Player upEnemy = (Player)getOneObjectAtOffset(0, -1, Player.class);
        Player downEnemy = (Player)getOneObjectAtOffset(0, 1, Player.class);

        Chest leftChest = (Chest)getOneObjectAtOffset(-1, 0, Chest.class);
        Chest rightChest = (Chest)getOneObjectAtOffset(1, 0, Chest.class);
        Chest upChest = (Chest)getOneObjectAtOffset(0, -1, Chest.class);
        Chest downChest = (Chest)getOneObjectAtOffset(0, 1, Chest.class);

        boolean HasMovedAlready = false;

        if (!HasMovedAlready){
            if (leftCollide==null){ //trigger function
                if (leftEnemy==null){
                    if (leftChest == null) {
                        if (Greenfoot.getRandomNumber(100)<40) {//another trigger function
                            {
                                setLocation(getX() - d, getY()); //event handler
                                HasMovedAlready = true;
                            }
                        } 
                    } 
                }
                else if (leftEnemy!=null){
                    if (Greenfoot.getRandomNumber(100)<90)
                    {
                        leftEnemy.takeDamage(attack, leftEnemy);
                        HasMovedAlready = true;
                    }
                }
            } 
        }
        if (!HasMovedAlready){
            if (rightCollide==null){
                if (rightEnemy==null){
                    if (rightChest==null){
                        if(Greenfoot.getRandomNumber(100)<40) {
                            setLocation(getX() + d,getY());
                            HasMovedAlready = true;
                        } 
                    }
                }
                else if (rightEnemy!=null){
                    if (Greenfoot.getRandomNumber(100)<90){
                        rightEnemy.takeDamage(attack, rightEnemy);
                        HasMovedAlready = true;
                    }
                }
            }
        }
        if (!HasMovedAlready){
            if (downCollide==null){
                if (hotbar==null){
                    if (downEnemy==null){
                        if (downChest == null){
                            if (Greenfoot.getRandomNumber(100)<40) {
                                setLocation(getX(),getY() + d);
                                HasMovedAlready = true;
                            } 
                        } 
                    }
                    else if (downEnemy!=null){
                        if (Greenfoot.getRandomNumber(100)<90){
                            downEnemy.takeDamage(attack, downEnemy);
                            HasMovedAlready = true;
                        }
                    }
                }
            }   
        }
        if (!HasMovedAlready){
            if (upCollide==null){
                if (upEnemy==null){
                    if (upChest==null){
                        if(Greenfoot.getRandomNumber(100)<40) {
                            setLocation(getX(),getY() - d);
                            HasMovedAlready = true;
                        }
                    }
                }
                else if (upEnemy!=null){
                    if (Greenfoot.getRandomNumber(100)<90){
                        upEnemy.takeDamage(attack, upEnemy);
                        HasMovedAlready = true;
                    }
                }
            }
        }
    }

    /**
     * Used in conjunction with method "movement" to force the actor to wait between movement attempts. 
     * For actors that attempt to move every act() execution.
     */
    public void waitformove(int attack)
    {

        if (x>=80)
        {
            movement(attack);
            x = 0;
        }
        else
        {
            x++;
        }
    }

    /**
     * Sets the selected monster's health to the inputted value.
     * Used for debugging purposes only.
     * Does not add to current health.
     * 
     * @param Health, as integer.
     */
    public void setHealth(int newHealth)
    {
        this.eHealth = newHealth;
    }

    /**
     * Sets the selected monster's attack to the inputted value.
     * Used for debugging purposes only.
     * Does not add to current attack.
     * 
     * @param Attack, as integer.
     */
    public void setAttack(int newAttack)
    {
        this.eAttack = newAttack;
    }

    /**
     * Sets the selected monster's defense to the inputted value.
     * Used for debugging purposes only.
     * Does not add to current defense.
     * 
     * @param Defense, as integer.
     */
    public void setDefense(int newDefense)
    {
        this.eDefense = newDefense;
    }
}
