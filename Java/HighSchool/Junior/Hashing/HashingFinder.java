

/**
*  Uses a hash-coded data storage method to store items
*  from a file. a linked list is used as the method for
*  dealing with collisions
*
* @author     G. Peck
* @created    July 18, 2002
*
* Modified by Jason Quesenberry and Nancy Quesenberry
* February 9, 2006
*/
import java.io.*;
import java.util.Scanner;


public class HashingFinder
{
    private HashTable table;
    private final int TABLESIZE = 600;


    public Hashing()
    {
        table = new HashTable(TABLESIZE);
    }


    public void search()
    {
        int idToFind;
        Item location;


        Scanner console = new Scanner(System.in);


        System.out.println("Testing search algorithm\n");
        System.out.print("Enter Id value to search for (-1 to quit) --> ");
        idToFind = console.nextInt();


        while (idToFind >= 0)
        {
            location = (Item) table.find(new Item(idToFind, 0));
            if (location == null)
            {
                System.out.println("Id = " + idToFind + "  No such part in stock");
            }
            else
            {


                System.out.println("Id = " + location.getId() + "  Inv = " + location.getInv());
            }
            System.out.println();
            System.out.print("Enter Id value to search for (-1 to quit) --> ");
            idToFind = console.nextInt();
        }
        console.close();
    }


    public void stats()
    {
        // will print out required stats for this lab
        // Calcs
        float percentNull = (table.getNumberOfNulls() / (float) table.getCapacity()) * (float) 100;
        float avgLength = (float) table.getCapacity() / (float) (table.getNumberOfNulls()); // EDIT LATERR IDK


        System.out.println("\nHash Table Stats");
        System.out.println("Percent of null pointers: " + percentNull + "%");
        System.out.println("Average length of non-null lists: " + avgLength);
        System.out.println("Longest linked list: " + table.getLongestList());
    }


    public void loadFile()
    {
        Scanner inFile;
        String fileName = "file400.txt";
        int id, inv;
        try
        {
            inFile = new Scanner(new File(fileName));

            
            double rand = (double)Math.pow((Math.random() * 10.0 + 1.0), Math.random()*100+1.0);
            System.out.println("value to use: " + rand);
            

            int howMany = inFile.nextInt();
            for (int k = 1; k <= howMany; k++)
            {
                id = inFile.nextInt();
                inv = inFile.nextInt();
                table.add(new Item(id, inv),rand);
            }

            if((table.getNumberOfNulls() / (float) table.getCapacity()) * (float) 100 > 47 || table.getLongestList()>=4)
            {
            table = new HashTable(TABLESIZE);
            loadFile();
            }


        }
        catch (IOException i)
        {
            System.out.println("Error: " + i.getMessage());
        }
        //table.displayList();
    }
}





