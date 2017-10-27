
package tag;

/**
 *
 * @author mette, kim og rasmus
 */
public class Potion extends Item
{

    public Potion(String name)
    {
        this.value = random.nextInt(10, 20);
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return name + ", heals " + value;
    }
}

