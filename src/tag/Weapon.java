
package tag;

/**
 *
 * @author mette, kim og rasmus
 */
public class Weapon extends Item
{

    public Weapon(String name)
    {
        this.value = random.nextInt(10, 20);
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public int getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return name + ", damage " + value;
    }
}
