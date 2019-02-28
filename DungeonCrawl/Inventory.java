import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Holds player inventory array.
 * 
 * @author PC
 * @version shallowPockets
 */
public class Inventory extends UI
{
    public Item[] inventory1 = new Item[7];
    
    public Item getInventoryItem(int arrayNo)
    {
        return inventory1[arrayNo];
    }
}
