/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.util.ArrayList;

/**
 *
 * @author mette
 */
public class Monster
{

    protected String name;
    protected int health;
    protected int damage;
    protected Item item;
    protected RND random = new RND();
    protected ArrayList<String> names = new ArrayList<>();

    @Override
    public String toString()
    {
        return name;
    }

    public String getName()
    {
        return name;
    }

    public int attack(int playerArmor)
    {
        int damageToPlayer = damage - playerArmor;
        return damageToPlayer;
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

    public Item getItem()
    {
        return item;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }
}
