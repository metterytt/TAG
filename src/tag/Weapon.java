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
public class Weapon extends Item
{

    public Weapon(String name)
    {
        this.value = (int) (Math.random() * 11 + 10);
        this.name = name;
    }

    public int getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return name + ", damage " + value;
    }
}
