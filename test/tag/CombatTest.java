/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mette
 */
public class CombatTest
{
    Player p = new Player("Lotte");
    Monster m = new Monster();
    Combat c = new Combat(m, p);
    
    public CombatTest()
    {
    }
    
    @Before
    public void setUp()
    {
    }

    @Test
    public void testAttackPart2()
    {
        m.setHealth(10000);
        m.setDamage(10000);
        p.setHealth(1);
        p.setDamage(1);
        Boolean expected = true;
        Boolean actual = c.attackPart2();
        assertTrue(expected == actual);
    }

    @Test
    public void testAttackPart1()
    {
        p.setHealth(10000);
        p.setDamage(10000);
        m.setHealth(1);
        m.setDamage(1);
        Boolean expected = true;
        Boolean actual = c.attackPart1();
        assertTrue(expected == actual);
    }
    
}
