/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
            System.out.println("File not found");
        } catch (IOException e)
        {
            System.out.println("Error initializing stream");
            //winners = new ArrayList<Player>();
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
            System.out.println("File not found");
        } catch (IOException e)
        {
            System.out.println("Error initializing stream");
        }

    }

    public void showList()
    {
        try
        {
            fi = new FileInputStream(hiscore);
            oi = new ObjectInputStream(fi);
            ArrayList<Player> winnerReader = (ArrayList<Player>) oi.readObject();
            System.out.println("List of hiscores in The Abandoned Castle:\n");
            for (Player p : winnerReader)
            {
                System.out.println(p.toString());
            }
        } catch (IOException e)
        {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

}
