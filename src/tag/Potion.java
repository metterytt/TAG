package tag;

/**
 *
 * @author mette, kim og rasmus
 */
public class Potion extends Item
{

    public Potion(int tier)
    {
        this.name = "Healing Potion";
    }

    @Override
    public String toString()
    {
        return name;
    }
}
