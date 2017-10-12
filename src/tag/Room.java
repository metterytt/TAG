/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private boolean visited = false;
    private Room north = null;
    private Room south = null;
    private Room east = null;
    private Room west = null;
    private ArrayList<String> choices = new ArrayList<>();

    public Room(String description, String name)
    {
        this.description = description;
        this.name = name;
    }

    public void setVisited(boolean visited)
    {
        this.visited = visited;
    }


    public boolean isVisited()
    {
        return visited;
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
