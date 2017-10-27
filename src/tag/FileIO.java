package tag;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import textio.SysTextIO;
import textio.TextIO;

/**
 *
 * @author mette, rasmus og kim
 */
public class FileIO
{

    private File hiscore;
    private FileOutputStream f;
    private ObjectOutputStream o;
    private FileInputStream fi;
    private ObjectInputStream oi;
    private ArrayList<Player> winners;
    private TextIO io = new TextIO(new SysTextIO());

    public FileIO()

    {
        hiscore = new File("hiscore.txt");

    }

    public void readWinners()
    {
        try
        {
            fi = new FileInputStream(hiscore);
            oi = new ObjectInputStream(fi);
            winners = (ArrayList<Player>) oi.readObject();
            
        } catch (FileNotFoundException e)
        {
            io.put("File not found\n");
        } catch (IOException e)
        {
            io.put("Error initializing stream\n");
//            winners = new ArrayList<Player>();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void addWinner(Player p)
    {
        winners.add(p);
        try
        {
            f = new FileOutputStream(hiscore);
            o = new ObjectOutputStream(f);

            o.writeObject(winners);
        } catch (FileNotFoundException e)
        {
            io.put("File not found");
            e.printStackTrace();
        } catch (IOException e)
        {
            io.put("Error initializing stream");
            e.printStackTrace();
        }

    }

    public void showList()
    {
        try
        {
            fi = new FileInputStream(hiscore);
            oi = new ObjectInputStream(fi);
            ArrayList<Player> winnerReader = (ArrayList<Player>) oi.readObject();
            for(Player p: winnerReader)
            {
                io.put(p.toString());
            }
            
        } catch (IOException e)
        {
            io.put("Error initializing stream");
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

}
