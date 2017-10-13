package tag;

import java.util.ArrayList;

/**
 *
 * @author mette, rasmus og kim
 */
public class Text
{

    private ArrayList<String> descriptions = new ArrayList<>();

    public Text()
    {
        // room0
        descriptions.add("You have entered the so-called abandoned castle, "
                + "but if the rumors are true, it might not be so. \n"
                + "The people of the nearby village have many stories of"
                + " adventurers, like yourself, seeking the vast treasure \n"
                + "rumored to be deep inside the maze-like castle. "
                + "Every man, woman and child have their own story, but \n"
                + "the ending is allways the same. Once you enter the castle,"
                + "you never return.\n"
                + "\n"
                + "The first room is a huge corridor. An old red carpet "
                + "leads the way across the room, and ends at a big wooden \n"
                + "gate with a grim statue of a gargoyle on each side. "
                + "Otherwise it seems to be empty.\n\n"
                + "North - go through the wooden gate\n"
                + "South - exit the castle");
        //room1
        descriptions.add("You enter an impressive foyer, even though time "
                + "has taken its toll on it. You notice the north wall is \n"
                + "filled with paintings, but too dusty and faded to see the motive. "
                + "You see two identical doors on each side of the room.\n\n"
                + "West - door\n"
                + "East - door");
        //room2
        descriptions.add("This room rivals any library you have ever seen,"
                + " with bookcases on all four walls, so tall you cant see \n"
                + "where they end. You can spot three doors and a staircase "
                + "leading down.\n\n"
                + "North - door\n"
                + "East - door\n"
                + "West - door\n"
                + "South - stairs");
        //room3
        descriptions.add("You are now inside what looks like a trophy room. "
                + "Heads of different creatures hang on the wall, one more \n"
                + "grotesque than the other. You notice 2 doors and a staircase"
                + " leading down.\n\n"
                + "North - door\n"
                + "West - door\n"
                + "South - stairs");
        //room4
        descriptions.add("This must be the castle's wine cellar. The bottles "
                + "and casks are covered in a thick layer of dust. You see two \n"
                + "doors, one normal and a smaller sized, and some stairs"
                + " leading up.\n\n"
                + "North - stairs\n"
                + "East - door\n"
                + "South - small door");
        //room5
        descriptions.add("A storage room, no doubt. It is filled to the brink "
                + "with stacks of paintings, chairs, stuffed animals, and much \n"
                + "more. One could get lost in this mess easily, but you manage"
                + " to find a door and a staircase leading up.\n\n"
                + "North - stairs\n"
                + "West - door");
        //room6
        descriptions.add("A continuation of the wine cellar. Seems like a dead end.\n\n"
                + "North - small door");
        //room7
        descriptions.add("This room has the feel of a barracks, it is filled "
                + "with bunk beds and little else. A door leads to the east, and \n"
                + "a staircase leads north.\n\n"
                + "North - stairs\n"
                + "East - door");
        //room8
        descriptions.add("A hallway, old armors stand facing each other in pairs"
                + " across the hallway. You get the feeling you are being watched. \n"
                + "You increase your pace, quickly trying to decide which way to"
                + " go next. There are two doors and a staircase to choose from.\n\n"
                + "North - stairs\n"
                + "East - door\n"
                + "West - door");
        //room9
        descriptions.add("You enter what must be the mess hall. Several long"
                + " tables make up most of the room's furnishings, although \n"
                + "along the walls are also smaller tables in booths. You can"
                + " almost hear the echoes of the stories that have been told \n"
                + "across the tables, competing with one another in "
                + "outrageousness. From here, stairs lead to the south, "
                + "and a door leads to the east.\n\n"
                + "South - stairs\n"
                + "East - door");
        //room10
        descriptions.add("This must be the kitchen area. Stairs lead to the"
                + " south, and there are also two doors.\n\n"
                + "North - door\n"
                + "South - stairs\n"
                + "West - door");
        //room11
        descriptions.add("Test description 11");
        //room12
        descriptions.add("This room must have served as the castle's living"
                + " room. Several groups of armchairs and sofas are arranged \n"
                + "throughout it. Doors lead north, south and east.\n\n"
                + "North - door\n"
                + "South - door\n"
                + "East - door");
        //room13
        descriptions.add("This seems to be the guests' chambers. Doors lead"
                + " west and south, and to the north is an exit to a balcony.\n\n"
                + "North - balcony\n"
                + "South - door\n"
                + "West - door");
        //room14
        descriptions.add("The balcony. You welcome the sensation of fresh air."
                + " To go back inside, there are entrances to the west and south.\n\n"
                + "South - door\n"
                + "West - door");
        //room15
        descriptions.add("Ballroom. A large door leads to the west, a balcony"
                + " is to the east and also a door leads south.\n\n"
                + "South - door\n"
                + "East - balcony\n"
                + "West - door");
        //room16
        descriptions.add("The master dining room. A winding staircase can be "
                + "entered to the north, and there are also two doors leading east and \n"
                + "west. In the southern wall, there is a small passage.\n\n"
                + "North - stairs\n"
                + "South - small passage\n"
                + "East - door\n"
                + "West - door");
        //room17
        descriptions.add("This is a hallway, impressively decorated with "
                + "paintings and statues. A staircase leads west, and doors \n"
                + "lead to the south and east.\n\n"
                + "South - door\n"
                + "East - door\n"
                + "West - stairs");
        //room18
        descriptions.add("Here is the master's chambers. Vastly furnished"
                + " with exquisite interior, but otherwise a dead end. Stairs"
                + " lead east.\n\n"
                + "East - stairs");
        //room19
        descriptions.add("After ascending a seemingly endless staircase, you"
                + " enter a fully equipped observatory. A majestic telescope situated \n"
                + "in the middle of the room points towards the sky through an opening"
                + " in the vast walls. Examining it closer, it becomes obvious \n"
                + "that this telescope was special to someone. An inscription reads:\n\n"
                + "*** TO MY LOVING DAUGHTER ELENA. I WOULD GIVE YOU THE STARS IF I COULD ***\n\n"
                + "Elena. What a pretty name, you think.\n\n"
                + "The only exit is the stairs leading back south.\n\n"
                + "South - stairs");
    }

    public String getDescription(int i)
    {
        return descriptions.get(i);
    }

}
