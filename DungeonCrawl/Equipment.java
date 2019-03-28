import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Superclass for all items that are equippable, i.e. armor, etc.
 * 
 * @author PC
 * @version rework2
 */
public abstract class Equipment extends Obj
{
    public boolean statsUpdated = false;
    public int plrAttack;
    public int plrDefense;
    public int plrItemDefense;
    public int OldItemDefense;
    public boolean isEquipped = false;

    //Every subclass of this item should have the variable isWeapon, which is an integer.
    //isWeapon changes based on what the piece of equipment is. This uses Inheritance, data encapsulation and Polymorphism, all available in OOP.
    //This helps by reducing the amount of duplicate lines of code, thus making the code as a whole more efficient.
    //Also, keeping the code flexible to allow for differences in each method.
    //0 is Weapon, 1 is Armor and 2 is Shield.

    // mfr explains use of a variety of data types U6 P4 U22 M1 also U6 P2 U15 M1 

    /**
     * Allows the object to be picked up and stored.
     * Differs to Item.pickUp in that it stores only in two slots, not the inventory.
     * @param Boolean, provided by subclass.
     */
    public void pickUpEquipment(int isWeapon)
    {
        int value = 0;
        Actor player = getOneIntersectingObject(Player.class);
        if(player!=null){
            if(isWeapon == 0){
                if (((Player)getWorld().getObjects(Player.class).get(0)).isCursed == false) {
                    if (!isEquipmentWorse(((Weapon)this).findAttack(), findOldAttack())){
                        value = 7;
                        getWorld().removeObject(((Player)getWorld().getObjects(Player.class).get(0)).wornweapon);
                        ((Player)getWorld().getObjects(Player.class).get(0)).wornweapon = (Weapon)this;

                        this.isEquipped = true;
                    }
                    else{recycleWorseEquipment((Weapon)this);}
                }
            }
            else if (isWeapon == 1) {
                if (((Player)getWorld().getObjects(Player.class).get(0)).isCursed == false) {
                    if (!isEquipmentWorse(((Armor)this).findDefense(), findOldDefense())){
                        value = 8;
                        getWorld().removeObject(((Player)getWorld().getObjects(Player.class).get(0)).wornarmor);
                        ((Player)getWorld().getObjects(Player.class).get(0)).wornarmor = (Armor)this;
                        this.isEquipped = true;
                    }
                    else{recycleWorseEquipment((Armor)this);}
                }
            }
            else if (isWeapon == 2){
                if (((Player)getWorld().getObjects(Player.class).get(0)).isCursed == false) {
                    if (!isEquipmentWorse(((Shield)this).findItemDefense(), findOldItemDefense())){
                        value = 6;
                        getWorld().removeObject(((Player)getWorld().getObjects(Player.class).get(0)).wornshield);
                        ((Player)getWorld().getObjects(Player.class).get(0)).wornshield = (Shield)this;
                        this.isEquipped = true;
                    }
                    else{recycleWorseEquipment((Shield)this);}
                }
            }
            if (value != 0){
                setLocation(value, 10);

            }
        }
    }

    /**
     * Compares two pieces of equipment, and returns true if the first equipment (Normally the old equipment) is worse, or equal, in terms of stats.
     */
    private boolean isEquipmentWorse(int stat, int stat2)
    {
        // if (isWeapon == 0){
        if(stat != 0){
            if (stat2 != 0){
                int x = stat;
                int y = stat2;
                if (x < y) {return true;}
                else if (x == y) {return true;}
                else {return false;}
            }
            else {return false;}
        }
        else {return false;}
    }

    /**
     * If a piece of equipment is worse than current equipment, remove it and spawn equivalent gold calculated on worse item's stats.
     */
    private void recycleWorseEquipment(Equipment oldEquipment)
    {
        getWorld().addObject(new Gold(), getX(), getY());
        getWorld().removeObject(oldEquipment);
    }

    /**
     * Allows the object to update the player stats when equipped.
     * Only applies to "equipped" (getY = 10) equipment.
     * 
     * @param Integer, for Attack stat increase.
     * @param Integer, for Defense stat increase.
     * @param Boolean, for checking if the equipment is a weapon or an armor (true or false)
     * @param Boolean, for checking if the equipment is an artifact.
     * Parameters can also be negatives to remove stat points.
     */
    public void updateStats(int Attack, int Defense, int oldAttack, int oldDefense, int isWeapon, boolean isArtifact )
    {
        //List<Player> playerfind = getObjectsInRange(15, Player.class);
        //Actor player = playerfind.get(0);

        if (this.getY() == 10){ //If weapon is on hotbar ("inventory")
            if (this.isEquipped){
                if (statsUpdated) {} //If stats were already added, do nothing.
                else //if (getOneIntersectingObject(Class.class) ) {
                {
                    //=========================SHIELDS=========================
                    if (isWeapon == 2) {
                        plrItemDefense = ((Player)getWorld().getObjects(Player.class).get(0)).weaponDefense;
                        OldItemDefense = findOldItemDefense();
                        if (plrItemDefense != 0){
                            plrItemDefense = plrItemDefense - OldItemDefense;
                        }
                        OldItemDefense = Defense;
                        plrItemDefense = plrItemDefense + Defense;
                        ((Player)getWorld().getObjects(Player.class).get(0)).weaponDefense = plrItemDefense; //Finds the first instance of 'Player' in the world.
                        ((Player)getWorld().getObjects(Player.class).get(0)).oldweaponDefense = OldItemDefense;
                    }
                    //=========================WEAPONS=========================
                    else if (isWeapon == 0){ 
                        plrAttack = ((Player)getWorld().getObjects(Player.class).get(0)).Attack ;
                        if (oldAttack != 0) {
                            plrAttack = plrAttack - oldAttack;
                        }
                        oldAttack = Attack;
                        plrAttack = plrAttack + Attack;
                        ((Player)getWorld().getObjects(Player.class).get(0)).Attack = plrAttack; //Finds the first instance of 'Player' in the world.
                        ((Player)getWorld().getObjects(Player.class).get(0)).oldAttack = Attack;
                        ((Player)getWorld().getObjects(Player.class).get(0)).newWeapon = true;
                    }
                    //=========================ARMOR=========================
                    else if (isWeapon == 1){
                        plrDefense = ((Player)getWorld().getObjects(Player.class).get(0)).Defense;
                        if (oldDefense != 0){
                            plrDefense = plrDefense - oldDefense;
                        }
                        oldDefense = Defense;
                        plrDefense = plrDefense + Defense;
                        ((Player)getWorld().getObjects(Player.class).get(0)).Defense = plrDefense; //Finds the first instance of 'Player' in the world.
                        ((Player)getWorld().getObjects(Player.class).get(0)).oldDefense = Defense;

                    }
                    if(isArtifact){
                        ((Player)getWorld().getObjects(Player.class).get(0)).isCursed = true;
                    }
                    statsUpdated = true;

                }
            }
        }
    }

    public int findOldAttack()
    {
        //try {
        return ((Player)getWorld().getObjects(Player.class).get(0)).oldAttack; 
        // }
        // catch (Exception e){}
    }

    public int findOldDefense()
    {
        return ((Player)getWorld().getObjects(Player.class).get(0)).oldDefense;
    }

    public int findOldItemDefense()
    {
        return ((Player)getWorld().getObjects(Player.class).get(0)).weaponDefense;
    }
}
