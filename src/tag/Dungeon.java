package tag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import textio.SysTextIO;
import textio.TextIO;

/**
 *
 * @author mette, rasmus og kim
 */
public class Dungeon
{

    private TextIO io = new TextIO(new SysTextIO());
    private Player player;
    private MovingMonster movingMonster;
    private Text catalogue = new Text();
    private ArrayList<Room> allRooms = new ArrayList<>();
    private ArrayList<Room> roomsTier1 = new ArrayList<>();
    private ArrayList<Room> roomsTier2 = new ArrayList<>();
    private ArrayList<Room> roomsTier3 = new ArrayList<>();
    private ArrayList<Room> roomsTier4 = new ArrayList<>();
    private Room current;
    private Room previousRoom;
    private FileIO hiscore = new FileIO();
    private RND random = new RND();
    private final int MOVINGMONSTER_ROOM_MIN = 9;
    private final int MOVINGMONSTER_ROOM_MAX = 19;
    private ArrayList<Item> itemsTier1 = new ArrayList<>();
    private ArrayList<Item> itemsTier2 = new ArrayList<>();
    private ArrayList<Item> itemsTier3 = new ArrayList<>();

    public Dungeon()
    {
        /**
         * reads in the file with previous hiscores
         */
        hiscore.readWinners();

        /**
         * creates dungeon, including 2 'special rooms'
         */
        for (int i = 0; i < 20; i++)
        {
            allRooms.add(new Room(catalogue.getDescription(i), "room" + i));
        }
        allRooms.add(new Room("Quitting room", "room20"));
        allRooms.add(new Room("Winning room", "room21"));

        setRoomTiers();
        setItemTiers();
        placeMonster();
        placeItem();
        placeGold();
        setExits();
        introSequence();

        Room room = allRooms.get(random.nextInt(MOVINGMONSTER_ROOM_MIN, MOVINGMONSTER_ROOM_MAX));
        movingMonster = new MovingMonster(room);
    }

    private void setRoomTiers()
    {
        roomsTier1.add(allRooms.get(1));
        roomsTier1.add(allRooms.get(2));
        roomsTier1.add(allRooms.get(3));
        roomsTier1.add(allRooms.get(4));
        roomsTier1.add(allRooms.get(7));
        roomsTier1.add(allRooms.get(8));
        roomsTier1.add(allRooms.get(10));
        roomsTier2.add(allRooms.get(5));
        roomsTier2.add(allRooms.get(9));
        roomsTier2.add(allRooms.get(12));
        roomsTier2.add(allRooms.get(13));
        roomsTier2.add(allRooms.get(17));
        roomsTier3.add(allRooms.get(14));
        roomsTier3.add(allRooms.get(15));
        roomsTier3.add(allRooms.get(16));
        roomsTier3.add(allRooms.get(18));
        roomsTier4.add(allRooms.get(19));
    }

    private void setItemTiers()
    {
        itemsTier1.add(new Potion(1));
        itemsTier1.add(new Weapon(1));
        itemsTier1.add(new Armor(1));
        itemsTier2.add(new Potion(2));
        itemsTier2.add(new Weapon(2));
        itemsTier2.add(new Armor(2));
        itemsTier3.add(new Potion(3));
        itemsTier3.add(new Weapon(3));
        itemsTier3.add(new Armor(3));
    }

    private void placeMonster()
    {

        for (Room r : roomsTier1)
        {
            int determineMonster = random.nextInt(1, 4);
            if (determineMonster != 1)
            {
                r.setMonster(new MonsterTier1(itemsTier1.get(random.nextInt(itemsTier1.size()))));
                r.setHasMonster(true);
            }
        }

        for (Room r : roomsTier2)
        {
            int determineMonster = random.nextInt(1, 4);
            if (determineMonster != 1)
            {
                r.setMonster(new MonsterTier2(itemsTier2.get(random.nextInt(itemsTier2.size()))));
                r.setHasMonster(true);
            }
        }

        for (Room r : roomsTier3)
        {
            int determineMonster = random.nextInt(1, 4);
            if (determineMonster != 1)
            {
                r.setMonster(new MonsterTier3(itemsTier3.get(random.nextInt(itemsTier3.size()))));
                r.setHasMonster(true);
            }
        }
        roomsTier4.get(0).setMonster(new MonsterTier4(itemsTier3.get(random.nextInt(itemsTier3.size()))));
        roomsTier4.get(0).setHasMonster(true);

    }

    private void placeItem()
    {
        /**
         * places items in some rooms
         */
        for (Room r : roomsTier1)
        {
            int determineItem = random.nextInt(1, 4);
            if (determineItem != 1)
            {
                r.setItemsInRoom(itemsTier1.get(random.nextInt(itemsTier1.size())));
            }
        }
        for (Room r : roomsTier2)
        {
            int determineItem = random.nextInt(1, 4);
            if (determineItem != 1)
            {
                r.setItemsInRoom(itemsTier2.get(random.nextInt(itemsTier2.size())));
            }
        }
        for (Room r : roomsTier3)
        {
            int determineItem = random.nextInt(1, 4);
            if (determineItem != 1)
            {
                r.setItemsInRoom(itemsTier3.get(random.nextInt(itemsTier3.size())));
            }
        }

    }

    private void placeGold()
    {
        for (Room r : roomsTier1)
        {
            int determineGold = random.nextInt(1, 4);
            if (determineGold != 1)
            {
                r.setGold(random.nextInt(10, 20));
            }
        }
        for (Room r : roomsTier2)
        {
            int determineGold = random.nextInt(1, 4);
            if (determineGold != 1)
            {
                r.setGold(random.nextInt(20, 30));
            }
        }
        for (Room r : roomsTier3)
        {
            int determineGold = random.nextInt(1, 4);
            if (determineGold != 1)
            {
                r.setGold(random.nextInt(30, 40));
            }
        }
    }

    private void setExits()
    {
        /**
         * sets available exits from each room
         */
        allRooms.get(0).setNorth(allRooms.get(1));
        allRooms.get(0).setSouth(allRooms.get(20));

        allRooms.get(1).setSouth(allRooms.get(0));
        allRooms.get(1).setEast(allRooms.get(2));
        allRooms.get(1).setWest(allRooms.get(8));

        allRooms.get(2).setNorth(allRooms.get(12));
        allRooms.get(2).setSouth(allRooms.get(4));
        allRooms.get(2).setEast(allRooms.get(3));
        allRooms.get(2).setWest(allRooms.get(1));

        allRooms.get(3).setNorth(allRooms.get(13));
        allRooms.get(3).setSouth(allRooms.get(5));
        allRooms.get(3).setWest(allRooms.get(2));

        allRooms.get(4).setNorth(allRooms.get(2));
        allRooms.get(4).setSouth(allRooms.get(6));
        allRooms.get(4).setEast(allRooms.get(5));

        allRooms.get(5).setNorth(allRooms.get(3));
        allRooms.get(5).setWest(allRooms.get(4));

        allRooms.get(6).setNorth(allRooms.get(4));

        allRooms.get(7).setNorth(allRooms.get(9));
        allRooms.get(7).setEast(allRooms.get(8));

        allRooms.get(8).setNorth(allRooms.get(10));
        allRooms.get(8).setEast(allRooms.get(1));
        allRooms.get(8).setWest(allRooms.get(7));

        allRooms.get(9).setSouth(allRooms.get(7));
        allRooms.get(9).setEast(allRooms.get(10));

        allRooms.get(10).setNorth(allRooms.get(17));
        allRooms.get(10).setSouth(allRooms.get(8));
        allRooms.get(10).setWest(allRooms.get(9));

        allRooms.get(11).setNorth(allRooms.get(16));

        allRooms.get(12).setNorth(allRooms.get(15));
        allRooms.get(12).setSouth(allRooms.get(2));
        allRooms.get(12).setEast(allRooms.get(13));

        allRooms.get(13).setNorth(allRooms.get(14));
        allRooms.get(13).setSouth(allRooms.get(3));
        allRooms.get(13).setWest(allRooms.get(12));

        allRooms.get(14).setSouth(allRooms.get(13));
        allRooms.get(14).setWest(allRooms.get(15));

        allRooms.get(15).setSouth(allRooms.get(12));
        allRooms.get(15).setEast(allRooms.get(14));
        allRooms.get(15).setWest(allRooms.get(16));

        allRooms.get(16).setNorth(allRooms.get(19));
        allRooms.get(16).setSouth(allRooms.get(11));
        allRooms.get(16).setEast(allRooms.get(15));
        allRooms.get(16).setWest(allRooms.get(17));

        allRooms.get(17).setSouth(allRooms.get(10));
        allRooms.get(17).setEast(allRooms.get(16));
        allRooms.get(17).setWest(allRooms.get(18));

        allRooms.get(18).setEast(allRooms.get(17));

        allRooms.get(19).setSouth(allRooms.get(16));
    }

    private void introSequence()
    {
        /**
         * intro sequence. creates player
         */
        io.put("***** Text Adventure Game: The Abandoned Castle *****\n\n");
        io.put("HOW TO PLAY:\n"
                + "The goal of the game is to find your way through the castle "
                + "and obtain the treasure hidden within.\n"
                + "You start with a piece of armor and a weapon equipped, "
                + "and with a Healing Potion in your inventory.\n"
                + "Whenever you use a Healing Potion, you are healed to your "
                + "maximum health. You can during the game find better armor\n"
                + "and weapons to equip, as well as you can access your inventory "
                + "and drop some of your items if you no longer need them.\n");
        help();

        String name = "";
        io.put("Enter your name:");
        name = io.get();
        while (name.length() == 0)
        {
            io.put("Please re-enter your name.\n");
            name = io.get();
        }

        player = new Player(name);
        io.put("\nWelcome, " + player.getName() + ", to The Abandoned Castle.\n");
    }

    /**
     * starts game. cycles through rooms as the player enters. provides endings
     * for success, for quitting and for dying - if success, writes player to
     * hiscorelist and prints the list.
     */
    public void play()
    {
        current = allRooms.get(0);
        current = enter();
        while (!current.equals(allRooms.get(20)) && !current.equals(allRooms.get(21)))
        {
            current = enter();
        }
        if (current.equals(allRooms.get(21)))
        {
            io.put("You won the game.\n\n");

            hiscore.addWinner(player);

            ArrayList<Player> hiscoreListToBePrinted = new ArrayList<Player>();
            hiscoreListToBePrinted = hiscore.getWinners();
            io.put("List of hiscores in The Abandoned Castle:\n");

            Collections.sort(hiscoreListToBePrinted, new SortByGold());
            for (int i = 0; i < hiscoreListToBePrinted.size(); i++)
            {
                io.put((i + 1) + ". ");
                io.put(hiscoreListToBePrinted.get(i).getName() + ", obtained " + hiscoreListToBePrinted.get(i).getGold() + " goldpieces.\n");
            }

        } else if (player.getHealth() > 0)
        {
            io.put("\nYou run as fast as you can, leaving the castle, "
                    + "overwhelmed with frenzying fear.\n\nThanks for playing!\n");
        } else
        {
            io.put("***************** R.I.P. *****************\nThe locals will add you "
                    + "to the tale of adventurers not returning from The Abandoned"
                    + " Castle.\n\nThanks for playing!\n");
        }
    }

    /**
     * room event for each entered room. if current room has not earlier had an
     * event, checks for gold, traps and items. checks if player health goes to
     * zero. checks code entered in room 11 for escaping.
     */
    private Room enter()
    {
        io.put("\n");

        if (current.equals(allRooms.get(11)))
        {
            return checkCode();
        }
        if (checkForMovingMonster())

        {
            return allRooms.get(20);
        }

        if (current.getHasMonster())
        {
            int resultOfCombat = combat();
            if (resultOfCombat == 3)
            {
                return previousRoom;
            }
            if (resultOfCombat == 2)
            {
                return allRooms.get(20);
            }
            if (resultOfCombat == 1)
            {
                io.put("You defeated the " + current.getMonster().name + "! You gained "
                        + "a level and 100 extra max Health and 20 extra base damage!\n\n");
                io.put("The " + current.getMonster().name + " had a " + current.getMonster().item.toString() + "! "
                        + "Maybe you can use it - type y if you would like to pick it up.\n");
                String pickUp = io.get();
                if (pickUp.equalsIgnoreCase("y"))
                {
                    player.addToInventory(current.getMonster().item);
                    io.put("You added the " + current.getMonster().item + " to your inventory.\n\n");
                    io.put("Now that the battle is over, you are ready to check "
                            + "out your surroundings.\n\n");
                }
                current.setHasMonster(false);
            }
        }

        io.put(current.getDescription());
        if (current.equals(allRooms.get(6)))
        {
            player.setAmulet(true);
        }
        io.put("\n_________________________________________________________________________\n\n");
        isHereAnItem();

        previousRoom = current;

        if ((current.getNorth() != null && current.getNorth().equals(movingMonster.getCurrent())
                || current.getSouth() != null && current.getSouth().equals(movingMonster.getCurrent())
                || current.getEast() != null && current.getEast().equals(movingMonster.getCurrent())
                || current.getWest() != null && current.getWest().equals(movingMonster.getCurrent()))
                && !movingMonster.isDead())
        {
            io.put("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨\n"
                    + "Listening carefully, you hear a growling coming from an adjacent room.\n"
                    + "The sound makes cold chills run down your spine.\n"
                    + "¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨\n");
        }

        /**
         * asks user for input and uses response method to check input and
         * determine next room
         */
        io.put("In which direction would you like to continue?");
        String input = io.get();
        input = input.toLowerCase();
        Room result = response(input);
        while (result == null)
        {
            io.put("You can't go that way from here. Try again:");
            result = response(io.get().toLowerCase());
        }

        if (!movingMonster.isDead())
        {
            movingMonster.move();
        }
        return result;
    }

    private boolean checkForMovingMonster()
    {
        if (current.equals(movingMonster.getCurrent()) && !movingMonster.isDead())
        {
            if (player.hasAmulet())
            {
                io.put("The troll is about to attack you, but suddenly freezes. It stares at the "
                        + "pendant you are wearing, and seems to enter a state of increasing\n"
                        + "fear. It starts to move away from you, but it's movements are strangely "
                        + "inhibited. Before your eyes, the troll's color of skin is changing into a\n"
                        + "stonish grey. Seconds later, the troll is nothing but a statue.\n\n"
                        + "You can continue your quest for the treasure.\n\n");
                movingMonster.setDead(true);
            } else
            {
                io.put("As you enter the room, you hear a loud growling. You are struck with "
                        + "fear even before you can determine the source of the growling.\n"
                        + "You never actually thought the tales of the troll to be true, but before you "
                        + "emerges the largest creature you have ever seen. In a single strike \n"
                        + "you are slain to the floor, mercifully losing contiousness.\n\n");
                player.setHealth(0);
                return true;
            }
        }
        return false;
    }

    /**
     * checks for access code to final room for escaping dungeon
     *
     * @return
     */
    private Room checkCode()
    {
        io.put("The door is locked. However, you notice a curious looking field "
                + "covered in dust just next to the handle. It could be some \n"
                + "kind of combination lock of five letters. You wonder what to enter...\n");
        String code = io.get();
        if (code.equalsIgnoreCase("ELENA"))
        {
            io.put("\nThe lock opens with a click, and you are able to open the "
                    + "door. It squeaks from the hinges after being locked in place for centuries.\n\n"
                    + "You enter a dark room with no windows. You feel a bit "
                    + "uncomfortable, trying to get your torch lit. Once you \n"
                    + "succeed, you are filled with expectation and a sense "
                    + "of victory by the sight that meets you. An ornamented \n"
                    + "chest sits in the center of the room, and as you open "
                    + "it the contents glitter in the light of your newly lit torch.\n\n"
                    + "You have found the treasure.\n\nFor a long time now, the name "
                    + player.getName() + " will appear in the lore of the local villages, being the"
                    + " first hero to ever return from The Abandoned Castle.\n\n");
            return allRooms.get(21);
        } else
        {
            io.put("This is an incorrect combination. Maybe you should look around "
                    + "a bit more. You return to the master dining room.\n");
            return allRooms.get(16);
        }
    }

    private int combat()
    {

        if (current.equals(allRooms.get(19)))
        {
            io.put("As you emerge from the seemingly endless staircase, you hear "
                    + "an ominous rattling from the far side of the room. Before you\n"
                    + "even have the chance to look for an escape route, the "
                    + current.getMonster().name + " himself is moving towards you, surprisingly rapidly, \n"
                    + "ready to kill! You know now that a tough battle awaits.\n\n");
        } else
        {
            io.put("Before you can get a view of your surroundings, "
                    + "you are attacked by a vicious " + current.getMonster().getName() + "!\n"
                    + "This " + current.getMonster().name + " has " + current.getMonster().health + " health.\n\n");
        }

        int damageToPlayer = current.getMonster().attack(player.getArmor());
        player.setHealth(player.getHealth() - damageToPlayer);
        io.put("Your health is down to " + player.getHealth() + "/" + player.getMaxHealth() + "!\n\n");
        if (player.getHealth() == 0)
        {
            return 2;
        }
        while (player.getHealth() > 0 && current.getMonster().health > 0)
        {

            io.put("What would you like to do?\n\n");

            ArrayList<String> options = new ArrayList<>();
            options.add("Attack!");
            options.add("Use Healing Potion");
            options.add("Run away! - Takes you back to the previous room");

            for (int i = 0; i < options.size(); i++)
            {
                io.put((i + 1) + " - " + options.get(i) + "\n");
            }

//        io.select("What would you like to do?", options, "Enter your choice:");
            int choice = io.getInteger(1, 3);
            if (choice == 3)
            {
                return 3;
            }

            {
                switch (choice)
                {
                    case 1:
                        current.getMonster().setHealth(current.getMonster().health - player.getDamage());
                        io.put("You take a swing at the " + current.getMonster().name + "! "
                                + "The " + current.getMonster().name + "'s health is down to "
                                + current.getMonster().health + "!\n\n");
                        if (current.getMonster().health == 0)
                        {
                            player.setLevel(player.getLevel() + 1);
                            player.setMaxHealth(player.getMaxHealth() + 100);
                            player.setHealth(player.getHealth() + 100);
                            player.setBaseDamage(player.getBaseDamage() + 20);
                            player.setDamage(player.getWeaponEquipped().value);

                            return 1;
                        }
                        io.put("The " + current.getMonster().name + " attacks again, obviously infuriated!\n");
                        damageToPlayer = current.getMonster().attack(player.getArmor());
                        player.setHealth(player.getHealth() - damageToPlayer);
                        io.put("Your health is down to " + player.getHealth() + "!\n\n");
                        if (player.getHealth() == 0)
                        {
                            return 2;
                        }

                        break;
                    case 2:
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
                        break;
                    default:
                    {
                        return 3;
                    }
                }
            }
        }
        return 3;
    }

    /**
     * handles various user inputs
     *
     * @param input
     * @return
     */
    private Room response(String input)
    {
        while (input.equalsIgnoreCase("i") || input.equalsIgnoreCase("help") || input.equalsIgnoreCase("stats"))
        {
            if (input.equalsIgnoreCase("i"))
            {
                ArrayList<Item> inventory = player.getInventory();
                if (inventory.size() == 0)
                {
                    io.put("You haven't collected any items yet.\n");
                }
                for (int i = 0; i < inventory.size(); i++)
                {
                    io.put((i + 1) + " - ");
                    io.put(inventory.get(i).toString());
                    io.put("\n");
                }
                io.put("...and " + player.getGold() + " goldpieces.\n\n");

                io.put("\nType y if you would like to use or equip any of your items, "
                        + "type 'drop' to drop a specific item and leave it in the room, "
                        + "or type n to continue.\n");
                String pickUp = io.get();
                if (pickUp.equalsIgnoreCase("drop"))
                {
                    io.put("Enter the number of the item you would like to drop:\n");
                    int itemSelected = io.getInteger(1, inventory.size());
                    Item itemToDrop = inventory.get(itemSelected - 1);
                    player.removeFromInventory(itemSelected - 1);
                    current.setItemsInRoom(itemToDrop);
                }
                if (pickUp.equals("y") || pickUp.equals("yes"))
                {
                    io.put("Enter the number of the item to use or equip it:\n");

                    int itemSelected = io.getInteger(1, inventory.size());
                    Item itemToEquip = inventory.get(itemSelected - 1);

                    if (itemToEquip.getClass().equals(Weapon.class))
                    {
                        player.setDamage(itemToEquip.value);
                        io.put("You equip the " + itemToEquip.toString() + ". Your damage is now "
                                + player.getDamage() + ".\n\n");
                        player.removeFromInventory(itemSelected - 1);//DET ER HER
                        player.addToInventory(player.getWeaponEquipped());
                        player.setWeaponEquipped(itemToEquip);

                    }
                    if (itemToEquip.getClass().equals(Armor.class))
                    {
                        player.setArmor(itemToEquip.value);
                        io.put("You equip the " + itemToEquip.toString() + ". Your armor is now "
                                + player.getArmor() + ".\n\n");
                        player.removeFromInventory(itemSelected - 1);//DET ER HER
                        player.addToInventory(player.getArmorEquipped());
                        player.setArmorEquipped(itemToEquip);
                    }
                    if (itemToEquip.getClass().equals(Potion.class))
                    {
                        player.setHealth(player.getMaxHealth());
                        io.put("You use the " + itemToEquip.name.substring(0, 14) + ". Your health is now "
                                + player.getHealth() + ".\n\n");
                        player.removeFromInventory(itemSelected - 1);
                    }
                }

                io.put("_________________________________________________________________________\n");
                io.put("In which direction would you like to continue?" + "\n");
                input = io.get();
                input = input.toLowerCase();
            }
            if (input.equalsIgnoreCase("help"))
            {
                help();
                io.put("In which direction would you like to continue?" + "\n");
                input = io.get();
                input = input.toLowerCase();
            }
            if (input.equalsIgnoreCase("stats"))
            {
                io.put("Player name: " + player.getName() + "\nHealth: " + player.getHealth()
                        + "\nLevel: " + player.getLevel() + "\nDamage: " + player.getDamage()
                        + "\nArmor: " + player.getArmor() + "\nWeapon equipped: "
                        + player.getWeaponEquipped().toString()
                        + "\nArmor equipped: " + player.getArmorEquipped().toString()
                        + "\n\nBase damage: " + player.getBaseDamage() + "\nMax health: "
                        + player.getMaxHealth() + "\n\n");
                io.put("In which direction would you like to continue?" + "\n");
                input = io.get();
                input = input.toLowerCase();

            }
        }

        switch (input)
        {
            case "quit":
                return allRooms.get(20);
            case "n":
                return current.getNorth();
            case "north":
                return current.getNorth();
            case "s":
                return current.getSouth();
            case "south":
                return current.getSouth();
            case "e":
                return current.getEast();
            case "east":
                return current.getEast();
            case "w":
                return current.getWest();
            case "west":
                return current.getWest();
            case "hide":
                return current;
            case "cheat":
                player.setGold(200);
                return current = allRooms.get(16);
            default:
                return null;
        }
    }

    /**
     * prints out list of commands when 'help' is entered
     */
    private void help()
    {
        io.put("Here is a list of the possible commands:" + "\n");
        io.put("\n");
        io.put("help - displays a list of possible commands" + "\n");
        io.put("quit - quits the game" + "\n");
        io.put("i - show inventory\n");
        io.put("stats - shows your current stats\n");
        io.put("n - goes north from the current location (if available)" + "\n");
        io.put("s - goes south from the current location (if available)" + "\n");
        io.put("e - goes east from the current location (if available)" + "\n");
        io.put("w - goes west from the current location (if available)" + "\n");
        io.put("\n");
    }

    /**
     * checks if room has an item or gold and if so, asks if user wants to add
     * to inventory
     */
    private void isHereAnItem()
    {
        ArrayList<Item> newItem = current.getItemsInRoom();
        if (newItem.size() > 0 || current.getGold() > 0)
        {
            io.put("Searching the room, you find a chest containing:\n\n");
            for (int i = 0; i < newItem.size(); i++)
            {
                io.put(newItem.get(i).toString() + "\n");
            }
            if (current.getGold() > 0)
            {
                io.put(current.getGold() + " goldpieces.\n");
            }
            io.put("\nWould you like to pick it up?\nWrite 'y' or 'yes' to pick it up.\n");
            String pickUp = io.get();
            if (pickUp.equals("y") || pickUp.equals("yes"))
            {
                for (Item i : newItem)
                {
                    player.addToInventory(i);
                }
                player.setGold(player.getGold() + current.getGold());
                current.setGold(0);
                current.clearItems();

                io.put("You added the items to your inventory.\n");
                io.put("_________________________________________________________________________\n\n");
            }
        }
    }

    public ArrayList<Room> getAllRooms()
    {
        return allRooms;
    }

    @Override
    public String toString()
    {
        return "Dungeon{" + "rooms=" + allRooms + '}';
    }

    private class SortByGold implements Comparator<Player>
    {

        @Override
        public int compare(Player o1, Player o2)
        {
            return o2.getGold() - o1.getGold();
        }

    }

}
