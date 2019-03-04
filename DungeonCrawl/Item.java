import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass of interactable, inanimate Items.
 * This includes items such as Gold, a collectible, and Apple, a healing item.
 * 
 * @author PC
 * @version 0.9
 */
public abstract class Item extends Obj
{
    // public Item[] inventory1 = new Item[7];

    /**
     * Allows the object to be picked up and stored.
     * @param Integer, provided by item subclass.
     */
    public void pickUp()
    {
        int array = oldNo;
        Actor player = getOneIntersectingObject(Player.class);
        if(player!=null)
        {
            // Player player = ((Player)getWorld().getObjects(Player.class).get(0));
            // player.invholder = (Item)this;
            ((Player)getWorld().getObjects(Player.class).get(0)).logToInventory(this, array);
            // player.inv[array] = (Item)this;
            // ((Player)getWorld().getObjects(Player.class).get(0)).inv[array] = (Item)this;
            setLocation(array, 10);
            array++;
        }
        if(array>=6)
        {
            array=0;
        }
        oldNo = array;
    }

    // /**
    // * Provides a single inventory item when provided an integer.
    // * @param Integer
    // */
    // public Item getInventoryItem(int arrayNo)
    // {
    // return inventory1[arrayNo];
    // }

    /**
     * Checks whether or not an item is being used in an inventory.
     */
    public boolean beingUsed()
    {
        if(this.getY()==10)

        { if(Greenfoot.mouseClicked(this))
                if(Greenfoot.getMouseInfo().getButton() == 1)
                {
                    {
                        oldNo=this.getX();
                        return true;
                    }
                }
                else {return false;}
            else {return false;}
        } else {return false;}
    }

    /**
     * Checks whether or not an item is being discarded in an inventory.
     */
    public boolean beingDiscarded()
    {
        if(this.getY()==10)
        { if(Greenfoot.mouseClicked(this))
                if(Greenfoot.getMouseInfo().getButton() == 3)

                {
                    {return true;}
                }
                else {return false;}
            else {return false;}
        } else {return false;}
    }

    /**
     * Allows the item to be thrown away/deleted/removed/etc.
     * For all intents and purposes, deletes the item.
     */
    public void discard()
    {
        if(this.getY()==10)
        {
            if(beingDiscarded())
            {
                getWorld().removeObject(this);
            }
        }
    }
}

