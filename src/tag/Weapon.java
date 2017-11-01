
package tag;

import java.util.ArrayList;

/**
 *
 * @author mette, kim og rasmus
 */
public class Weapon extends Item
{
    private ArrayList<String> weaponNames= new ArrayList<>();
    public Weapon(int tier)
    {
        switch (tier)
        {
            case 1:
                this.value = random.nextInt(40, 60);
                this.tier = 1;
                break;
            case 2:
                this.value = random.nextInt(80, 100);
                this.tier = 2;
                break;
            case 3:
                this.value = random.nextInt(120, 150);
                this.tier = 3;
                break;
            default:
                this.value = 0;
        }
        weaponNames.add("Sword");
        weaponNames.add("Dagger");
        weaponNames.add("Mace");
        weaponNames.add("Sabre");
        weaponNames.add("Knife");
        this.name = weaponNames.get(random.nextInt(0,weaponNames.size()-1));
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
        return name +", damage " + value;
    }
}
