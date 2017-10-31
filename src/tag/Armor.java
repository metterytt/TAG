
package tag;

import java.util.ArrayList;

/**
 *
 * @author mette, kim og rasmus
 */
public class Armor extends Item
{
    private ArrayList<String> armorNames = new ArrayList<>();
    
    public Armor(int tier)
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
        armorNames.add("Leather Armor");
        armorNames.add("Cloth Armor");
        armorNames.add("Plate Armor");
        armorNames.add("Chainmail Armor");
        this.name = armorNames.get(random.nextInt(0,armorNames.size()-1));
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
        return name +", armor " + value;
    }
}
