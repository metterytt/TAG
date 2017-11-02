package tag;

/**
 *
 * @author mette, kim og rasmus
 */
public class MonsterTier2 extends Monster
{

    final int MIN_HEALTH = 400;
    final int MAX_HEALTH = 500;
    final int MIN_DAMAGE = 100;
    final int MAX_DAMAGE = 150;

    public MonsterTier2(Item item)
    {
        this.health = random.nextInt(MIN_HEALTH, MAX_HEALTH);
        this.damage = random.nextInt(MIN_DAMAGE, MAX_DAMAGE);
        this.names.add("Goblin");
        this.names.add("Murloc");
        this.names.add("Ghost");
        this.name = names.get(random.nextInt(3));
        this.item = item;
    }

    
}
