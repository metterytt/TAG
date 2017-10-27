
package tag;

import java.io.Serializable;

/**
 *
 * @author mette, kim og rasmus
 */
public class Item implements Serializable
{
    protected RND random = new RND();
    protected String name;
    protected int value;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

}
