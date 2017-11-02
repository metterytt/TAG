/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.util.ArrayList;
import textio.SysTextIO;
import textio.TextIO;

/**
 *
 * @author mette
 */
public class Combat
{

    private TextIO io = new TextIO(new SysTextIO());
    Monster monster;
    Player player;

    public Combat(Monster monster, Player player)
    {
        this.monster = monster;
        this.player = player;
    }

    public int combat()
    {
        // Monster hits player
        int damageToPlayer = monster.attack(player.getArmor());
        player.setHealth(player.getHealth() - damageToPlayer);
        io.put("Your health is down to " + player.getHealth() + "/" + player.getMaxHealth() + "!\n\n");
        if (player.getHealth() == 0)
        {
            return 2;
        }
        // Combat
        while (player.getHealth() > 0 && monster.health > 0)
        {
            combatOptions();
            int choice = io.getInteger(1, 3);

            switch (choice)
            {
                case 1:
                    if (attackPart1())
                    {
                        return 1;
                    }
                    if (attackPart2())
                    {
                        return 2;
                    }
                    break;
                case 2:
                    healDuringCombat();
                    break;
                case 3:
                    // Run away
                    return 3;
                default:
                    return 3;
            }
        }
        return 3;
    }

    private void combatOptions()
    {
        // Output options
        io.put("What would you like to do?\n\n");

        ArrayList<String> options = new ArrayList<>();
        options.add("Attack!");
        options.add("Use Healing Potion");
        options.add("Run away! - Takes you back to the previous room");

        for (int i = 0; i < options.size(); i++)
        {
            io.put((i + 1) + " - " + options.get(i) + "\n");
        }
    }

    private void healDuringCombat()
    {
        // Heal
        ArrayList<Item> playerInventory = player.getInventory();
        int index = -1;

        for (int i = 0; i < playerInventory.size(); i++)
        {
            if (playerInventory.get(i).getName().equals("Healing Potion"))
            {
                index = i;
                player.setHealth(player.getMaxHealth());
                player.removeFromInventory(index);
                io.put("You used a Healing Potion. Your health is back to " + player.getMaxHealth() + ".\n\n");
                break;
            }
        }
        if (index == -1)
        {
            io.put("You don't have any Healing Potions.\n\n");
        }
    }

    public boolean attackPart2()
    {
        int damageToPlayer;
        io.put("The " + monster.name + " attacks again, obviously infuriated!\n");
        damageToPlayer = monster.attack(player.getArmor());
        player.setHealth(player.getHealth() - damageToPlayer);
        io.put("Your health is down to " + player.getHealth() + "/" + player.getMaxHealth() + "!\n\n");
        if (player.getHealth() == 0)
        {
            return true;
        }
        return false;
    }

    public boolean attackPart1()
    {
        // Attack
        monster.setHealth(monster.health - player.getDamage());
        io.put("You take a swing at the " + monster.name + "! "
                + "The " + monster.name + "'s health is down to "
                + monster.health + "!\n\n");
        if (monster.health == 0)
        {
            player.setLevel(player.getLevel() + 1);
            player.setMaxHealth(player.getMaxHealth() + 100);
            player.setHealth(player.getHealth() + 100);
            player.setBaseDamage(player.getBaseDamage() + 20);
            player.setDamage(player.getWeaponEquipped().value);
            return true;
        }
        return false;
    }
}
