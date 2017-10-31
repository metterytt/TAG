package tag;

/**
 *
 * @author mette, kim og rasmus
 */
public class MonsterTier1 extends Monster
{

    final int MIN_HEALTH = 20;
    final int MAX_HEALTH = 30;
    final int MIN_DAMAGE = 1;
    final int MAX_DAMAGE = 2;

    public MonsterTier1(Item item)
    {
        this.health = random.nextInt(MIN_HEALTH, MAX_HEALTH);
        this.damage = random.nextInt(MIN_DAMAGE, MAX_DAMAGE);
        this.names.add("Rat");
        this.names.add("Snake");
        this.names.add("Spider");
        this.name = names.get(random.nextInt(3));
        this.item = item;
    }

    public int attack(int playerArmor)
    {
        int damageToPlayer = damage - playerArmor;
        return damageToPlayer;
    }

    public String toString()
    {
        return name + " with " + health + " health, dealing " + damage + " damage.";
    }

    public Item getItem()
    {
        return item;
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
        if (health > 0)
        {
            this.health = health;
        } else
        {
            this.health = 0;
        }
    }

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }
}
