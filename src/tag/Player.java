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
public class Player
        
{
    private String name;
    private int health = 100;
    
    public Player (String name)
    {
        this.name = name;
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
        this.health = health;
    }
    
}
