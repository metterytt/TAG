package tag;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author mette, rasmus og kim
 */
public class Player implements Serializable

{

    private String name;
    private int health = 100;
    private int gold = 0;
    private int damage = 0;
    private int armor = 0;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Player(String name)
    {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public void addToInventory(Item i)
    {
        inventory.add(i);
    }

    public String getName()
    {
        return name;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getGold()
    {
        return gold;
    }

    public void setGold(int gold)
    {
        this.gold = gold;
    }

    public ArrayList<Item> getInventory()
    {
        return inventory;
    }

    @Override
    public String toString()
    {
        return name + " obtained " + gold + " goldpieces!\n";
    }
}
