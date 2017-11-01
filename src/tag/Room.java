package tag;

import java.util.ArrayList;
import textio.SysTextIO;
import textio.TextIO;

/**
 *
 * @author mette, rasmus og kim
 */
public class Room
{

    private String description;
    private String name;
    private int gold = 0;
    private TextIO io = new TextIO(new SysTextIO());
    private Room north = null;
    private Room south = null;
    private Room east = null;
    private Room west = null;
    private ArrayList<String> choices = new ArrayList<>();
    private ArrayList<Item> itemsInRoom = new ArrayList<>();
    private Monster monster;
    private boolean hasMonster = false;

    public Room(String description, String name)
    {
        this.description = description;
        this.name = name;
    }

    public int getGold()
    {
        return gold;
    }

    public void setGold(int gold)
    {
        this.gold = gold;
    }

    public void setHasMonster(boolean hasMonster)
    {
        this.hasMonster = hasMonster;
    }

    public boolean getHasMonster()
    {
        return hasMonster;
    }

    public ArrayList<Item> getItemsInRoom()
    {
        return itemsInRoom;
    }

    public void setItemsInRoom(Item item)
    {
        itemsInRoom.add(item);
    }

    public void clearItems()
    {
        itemsInRoom.clear();
    }

    public void setMonster(Monster monster)
    {
        this.monster = monster;
    }

    public Monster getMonster()
    {
        return monster;
    }

    public void setNorth(Room north)
    {
        this.north = north;
    }

    public void setSouth(Room south)
    {
        this.south = south;
    }

    public void setEast(Room east)
    {
        this.east = east;
    }

    public void setWest(Room west)
    {
        this.west = west;
    }

    public String getDescription()
    {
        return description;
    }

    public Room getNorth()
    {
        return north;
    }

    public Room getSouth()
    {
        return south;
    }

    public Room getEast()
    {
        return east;
    }

    public Room getWest()
    {
        return west;
    }

    public String getName()
    {
        return name;
    }

}
