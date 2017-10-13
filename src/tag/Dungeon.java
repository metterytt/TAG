package tag;

import java.util.ArrayList;
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
    private Text catalogue = new Text();
    private ArrayList<Room> rooms = new ArrayList<>();
    private Room current;

    public Dungeon()
    {
        for (int i = 0; i < 20; i++)
        {
            rooms.add(new Room(catalogue.getDescription(i), "room" + i));
        }
        rooms.add(new Room("Quitting room", "room20"));
        rooms.add(new Room("Winning room", "room21"));

        rooms.get(0).setNorth(rooms.get(1));
        rooms.get(0).setSouth(rooms.get(20));

        rooms.get(1).setSouth(rooms.get(0));
        rooms.get(1).setEast(rooms.get(2));
        rooms.get(1).setWest(rooms.get(8));

        rooms.get(2).setNorth(rooms.get(12));
        rooms.get(2).setSouth(rooms.get(4));
        rooms.get(2).setEast(rooms.get(3));
        rooms.get(2).setWest(rooms.get(1));

        rooms.get(3).setNorth(rooms.get(13));
        rooms.get(3).setSouth(rooms.get(5));
        rooms.get(3).setWest(rooms.get(2));

        rooms.get(4).setNorth(rooms.get(2));
        rooms.get(4).setSouth(rooms.get(6));
        rooms.get(4).setEast(rooms.get(5));

        rooms.get(5).setNorth(rooms.get(3));
        rooms.get(5).setWest(rooms.get(4));

        rooms.get(6).setNorth(rooms.get(4));

        rooms.get(7).setNorth(rooms.get(9));
        rooms.get(7).setEast(rooms.get(8));

        rooms.get(8).setNorth(rooms.get(10));
        rooms.get(8).setEast(rooms.get(1));
        rooms.get(8).setWest(rooms.get(7));

        rooms.get(9).setSouth(rooms.get(7));
        rooms.get(9).setEast(rooms.get(10));

        rooms.get(10).setNorth(rooms.get(17));
        rooms.get(10).setSouth(rooms.get(8));
        rooms.get(10).setWest(rooms.get(9));

        rooms.get(11).setNorth(rooms.get(16));

        rooms.get(12).setNorth(rooms.get(15));
        rooms.get(12).setSouth(rooms.get(2));
        rooms.get(12).setEast(rooms.get(13));

        rooms.get(13).setNorth(rooms.get(14));
        rooms.get(13).setSouth(rooms.get(3));
        rooms.get(13).setWest(rooms.get(12));

        rooms.get(14).setSouth(rooms.get(13));
        rooms.get(14).setWest(rooms.get(15));

        rooms.get(15).setSouth(rooms.get(12));
        rooms.get(15).setEast(rooms.get(14));
        rooms.get(15).setWest(rooms.get(16));

        rooms.get(16).setNorth(rooms.get(19));
        rooms.get(16).setSouth(rooms.get(11));
        rooms.get(16).setEast(rooms.get(15));
        rooms.get(16).setWest(rooms.get(17));

        rooms.get(17).setSouth(rooms.get(10));
        rooms.get(17).setEast(rooms.get(16));
        rooms.get(17).setWest(rooms.get(18));

        rooms.get(18).setEast(rooms.get(17));

        rooms.get(19).setSouth(rooms.get(16));
        io.put("***** Text Adventure Game: The Abandoned Castle *****\n\n");
        io.put("How to play:\n"
                + "You must find your way through the castle.\n");
        help();

        io.put("Enter your name:");
        player = new Player(io.get());
        io.put("\nWelcome, " + player.getName() + ", to The Abandoned Castle.\n"
                + "Your initial health is set to " + player.getHealth() + ".\n");
    }

    public ArrayList<Room> getRoomList()
    {
        return rooms;
    }

    public void play()
    {
        current = rooms.get(0);
        current = enter();
        while (!current.equals(rooms.get(20)) && !current.equals(rooms.get(21)))
        {
            current = enter();
        }
        if (current.equals(rooms.get(21)))
        {
            io.put("You won the game.");
        } else
        {
            io.put("\nYou are overwhelmed with fear and leave the castle.\nThank you for playing our game.");
        }
    }

    public Room enter()
    {
        io.put("\n");

        if (current.equals(rooms.get(11)))
        {
            return checkCode();
        }

        io.put(current.getDescription());
        io.put("\n_________________________________________________________________________");
        io.put("\n\n");
        isHereGold();
        isHereAMonster();
        if (player.getHealth() == 0)
        {
            return rooms.get(20);
        }
        io.put("In which direction would you like to continue?");
        String input = io.get();
        input = input.toLowerCase();
        Room result = response(input);
        while (result == null)
        {
            io.put("You can't go that way from here. Try again:");
            result = response(io.get());
        }
        return result;

    }

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
            return rooms.get(21);
        } else
        {
            io.put("This is an incorrect combination. Maybe you should look around "
                    + "a bit more. You return to the master dinig room.\n");
            return rooms.get(16);
        }
    }

    private Room response(String input)
    {
        while (input.equals("help"))
        {
            help();
            io.put("In which direction would you like to continue?" + "\n");
            input = io.get();
            input = input.toLowerCase();
        }
        switch (input)
        {
            case "quit":
                return rooms.get(20);
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
            default:
                return null;
        }
    }

    private void help()
    {
        io.put("Here is a list of the possible commands:" + "\n");
        io.put("\n");
        io.put("help - displays a list of possible commands" + "\n");
        io.put("quit - quits the game" + "\n");
        io.put("n - goes north from the current location (if available)" + "\n");
        io.put("s - goes south from the current location (if available)" + "\n");
        io.put("e - goes east from the current location (if available)" + "\n");
        io.put("w - goes west from the current location (if available)" + "\n");
        io.put("\n");
    }

    private void isHereAMonster()
    {
        int monsterType;
        monsterType = (int) (Math.random() * 3 + 1);
        if (monsterType == 1 && !current.equals(rooms.get(0)))
        {
            monsterEvent((int) (Math.random() * 3 + 1));
        }
    }

    private void monsterEvent(int monsterType)
    {
        io.put(">>>>> MONSTER ATTACK <<<<<\n");
        switch (monsterType)
        {
            case 1:
            {
                io.put("You hear a sizzling noise from the left. You quickly "
                        + "spin around, only to see an abnormously large rat \n"
                        + "moving towards you, hissing angrily.\n\n");
                combat((int) (Math.random() * 50 + 1));
                break;
            }
            case 2:
            {
                io.put("You only just have time to get a short view of you "
                        + "surroundings, before you are attacked by a vicious troll!\n\n");
                combat((int) (Math.random() * 50 + 1));
                break;
            }
            case 3:
            {
                io.put("An ominous rattling is heard from the far side of the "
                        + "premises. Before you even have the chance to look for \n"
                        + "a proper escape route, a skeleton is moving towards "
                        + "you surprisingly rapidly, weapon raised to attack.\n\n");
                combat((int) (Math.random() * 50 + 1));
                break;
            }

        }
    }

    private void combat(int monsterHealth)
    {
        io.put("You have no choice but to fight!\n\n");
        int playerHealth = player.getHealth();
        playerHealth = playerHealth - monsterHealth / 4;
        player.setHealth(playerHealth);
        if (player.getHealth() < 0)
        {
            player.setHealth(0);
        }
        io.put("The battle is over. Your health is now " + player.getHealth() + ".");
        io.put("\n_________________________________________________________________________\n\n");
    }

    private void isHereGold()
    {
        int i;
        i = (int) (Math.random() * 5 + 1);
        if (i == 1 && !current.equals(rooms.get(0)))
        {
            int goldFound = (int) (Math.random() * 10 + 1);
            io.put("What luck! You found " + goldFound + " gold coins!!\n");
            player.setGold(player.getGold() + goldFound);
            io.put("You now have " + player.getGold() + " gold coins!");
            io.put("\n_________________________________________________________________________\n\n");
        }
    }

    @Override
    public String toString()
    {
        return "Dungeon{" + "rooms=" + rooms + '}';
    }

}
