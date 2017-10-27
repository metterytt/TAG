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
    private TextIO io = new TextIO(new SysTextIO());
    private boolean hasHadAnEvent = false;
    private Room north = null;
    private Room south = null;
    private Room east = null;
    private Room west = null;
    private ArrayList<String> choices = new ArrayList<>();
    private Item item;

    public Room(String description, String name)
    {
        this.description = description;
        this.name = name;
    }

    public Item getItem()
    {
        return item;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }

    public boolean isHasHadAnEvent()
    {
        return hasHadAnEvent;
    }

    public void setHasHadAnEvent(boolean hasHadAnEvent)
    {
        this.hasHadAnEvent = hasHadAnEvent;
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
