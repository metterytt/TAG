package tag;

/**
 *
 * @author mette, kim og rasmus
 */
public class MonsterTier1 extends Monster
{

    final int MIN_HEALTH = 200;
    final int MAX_HEALTH = 300;
    final int MIN_DAMAGE = 40;
    final int MAX_DAMAGE = 60;

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

}
