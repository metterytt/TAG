/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.util.Random;

/**
 *
 * @author mette
 */
public class RND
{
    private static Random rnd = new Random();
    
    public static int nextInt(int bound)
    {
        return rnd.nextInt(bound);
    }
    
    public static int nextInt(int min, int max)
    {
        return nextInt(max - min + 1) + 1;
    }
}
