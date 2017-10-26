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
public class Potion extends Item
{

    public Potion(String name)
    {
        this.value = (int) (Math.random() * 11 + 10);
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return name + ", heals " + value;
    }
}

