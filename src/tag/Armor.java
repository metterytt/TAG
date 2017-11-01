
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
        armorNames.add("Leather Armor");
        armorNames.add("Chainmail Armor");
        switch (tier)
        {
            case 1:
                this.value = random.nextInt(20, 30);
                this.tier = 1;
                this.name = "Cloth Armor";
                break;
            case 2:
                this.value = random.nextInt(40, 50);
                this.tier = 2;
                this.name = armorNames.get(random.nextInt(0,armorNames.size()-1));
                break;
            case 3:
                this.value = random.nextInt(60, 70);
                this.tier = 3;
                this.name = "Plate Armor";
                break;
            default:
                this.value = 0;
        }
        
        
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
