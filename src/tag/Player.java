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
    private int maxHealth = 300;
    private int health = 300;
    private int gold = 0;
    private int baseDamage = 20;
    private int damage;
    private int armor = 0;
    private int level = 1;
    private boolean amulet = false;
    private ArrayList<Item> inventory = new ArrayList<>();
    private Item armorEquipped;
    private Item weaponEquipped;

    public Player(String name)
    {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
        inventory.add(new Potion(1));
        weaponEquipped = new Weapon(1);
        armorEquipped = new Armor(1);
        armor = armorEquipped.getValue();
        damage = baseDamage + weaponEquipped.getValue();
    }

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = baseDamage + damage;
    }

    public int getArmor()
    {
        return armor;
    }

    public void setArmor(int armor)
    {
        this.armor = armor;
    }

    public Item getArmorEquipped()
    {
        return armorEquipped;
    }

    public void setArmorEquipped(Item armorEquipped)
    {
        this.armorEquipped = armorEquipped;
    }

    public Item getWeaponEquipped()
    {
        return weaponEquipped;
    }

    public void setWeaponEquipped(Item weaponEquipped)
    {
        this.weaponEquipped = weaponEquipped;
    }

    public int getBaseDamage()
    {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage)
    {
        this.baseDamage = baseDamage;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public void addToInventory(Item i)
    {
        inventory.add(i);
    }

    public void removeFromInventory(int i)
    {
        inventory.remove(i);
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
        if (this.health < 0)
        {
            this.health = 0;
        }
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

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }

    public boolean hasAmulet()
    {
        return amulet;
    }

    public void setAmulet(boolean amulet)
    {
        this.amulet = amulet;
    }

    @Override
    public String toString()
    {
        return name + " obtained " + gold + " goldpieces!\n";
    }

}
