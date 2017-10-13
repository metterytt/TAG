package tag;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mette&kim&rasmus
 */
public class PlayerTest
{

    private Player p;

    public PlayerTest()
    {
    }

    @Before
    public void setUp()
    {
        this.p = new Player("Lotte");
    }

    @Test
    public void testGetName()
    {
        String expected = "Lotte";
        String actual = p.getName();
        assertEquals(expected, actual);

        String notExpected = "Pia";
        actual = p.getName();
        assertNotEquals(notExpected, actual);
    }

    @Test
    public void testGetHealth()
    {
        int expected = 100;
        int actual = p.getHealth();
        assertEquals(expected, actual);

        int notExpected = 1000;
        actual = p.getHealth();
        assertNotEquals(notExpected, actual);

    }

}
