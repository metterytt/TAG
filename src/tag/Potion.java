package tag;

/**
 *
 * @author mette, kim og rasmus
 */
public class Potion extends Item
{

    public Potion(int tier)
    {
        switch (tier)
        {
            case 1:
                this.value = random.nextInt(1, 2);
                this.tier = 1;
                break;
            case 2:
                this.value = random.nextInt(3, 4);
                this.tier = 2;             
                break;
            case 3:
                this.value = random.nextInt(5, 6);
                this.tier = 3;
                break;
            default:
                this.value = 0;
        }
        this.name = "Healing Potion";
        
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
        return name;
    }
}
