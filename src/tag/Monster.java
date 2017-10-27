/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

/**
 *
 * @author mette
 */
public class Monster
{
    private RND random = new RND();
    private int health = 100;
    private Room current;

    public Monster(Room room)
    {
        current = room;
    }

    public void move()
    {
        int chooseDirection;
        Room nextRoom;
        do
        {
            chooseDirection = random.nextInt(1, 4);
            switch (chooseDirection)
            {
                case 1:
                    nextRoom = current.getNorth();
                    break;
                case 2:
                    nextRoom = current.getSouth();
                    break;
                case 3:
                    nextRoom = current.getEast();
                    break;
                case 4:
                    nextRoom = current.getWest();
                    break;
                default:
                    nextRoom = null;
            }

        } while (nextRoom == null || nextRoom.getName().equals("room11") || nextRoom.getName().equals("room0"));
        current = nextRoom;
        System.out.println("Lotte er i " + current.getName());
    }

    public int getHealth()
    {
        return health;
    }

    public Room getCurrent()
    {
        return current;
    }
}
