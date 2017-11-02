package tag;

/**
 *
 * @author mette, kim og rasmus
 */
public class MonsterTier4 extends Monster
{

    final int MIN_HEALTH = 900;
    final int MAX_HEALTH = 1000;
    final int MIN_DAMAGE = 300;
    final int MAX_DAMAGE = 350;

    public MonsterTier4(Item item)
    {
        this.health = random.nextInt(MIN_HEALTH, MAX_HEALTH);
        this.damage = random.nextInt(MIN_DAMAGE, MAX_DAMAGE);

        this.name = "Skeleton King";
        this.item = item;
    }
}
