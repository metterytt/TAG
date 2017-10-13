package tag;

/**
 *
 * @author mette, rasmus og kim
 */
public class Player

{

    private String name;
    private int health = 100;
    private int gold = 0;

    public Player(String name)
    {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
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
}
