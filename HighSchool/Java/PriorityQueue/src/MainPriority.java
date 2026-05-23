import java.io.*;
import java.util.*;


public class MainPriority
{
    private Scanner console;
    private PriorityQueue<Item> myQueue;


    public MainPriority()
    {
        console = new Scanner(System.in);
        myQueue = new PriorityQueue<Item>(); // test with negative, zero, positive, no value
    }


    private void addInput()
    {
        console = new Scanner(System.in);
        System.out.println("All inputs will be added to the list as items");
        int input;
        int inv;
        do
        {
            System.out.print("Enter item ID (-1 to quit): ");
            input = console.nextInt();
            if (input == -1)
            {
                return;
            }
            console.nextLine();
            System.out.print("Enter item inventory (-1 to quit): ");
            inv = console.nextInt();
            if (inv != -1)
            {
                myQueue.add(new Item(input, inv));
                System.out.println("successfully added item: Id=" + input + ", Inv=" + inv);
            }


        } while (inv != -1);
    }


    private void removeBig()
    {
        try
        {
            Item theItem = myQueue.remove();
            System.out.println("Succsesfuly removed " + theItem);
        } catch (NoSuchElementException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public void loadFile()
    {
        Scanner inFile;
        int id;
        int inv;
        try
        {
            inFile = new Scanner(new File("file20.txt"));
            while (inFile.hasNext())
            {
                id = inFile.nextInt();
                inv = inFile.nextInt();
                myQueue.add(new Item(id, inv));
            }
            inFile.close();
        } catch (IOException i)
        {
            System.out.println("Error: " + i.getMessage());
        }


    }


    public void mainMenu()
    {
        int choice;
        System.out.println("PriorityQueue Has Been Initiated");
        do
        {
            System.out.println();
            System.out.println(" (1) Load File");
            System.out.println(" (2) isEmpty");
            System.out.println(" (3) Add");
            System.out.println(" (4) Peek");
            System.out.println(" (5) Remove");
            System.out.println("(-1) Quit\n");
            System.out.print("Choice ---> ");
            choice = console.nextInt();
            System.out.println();


            if (choice > 0 && choice <= 8)
            {
                switch (choice)
                {
                    case 1:
                        loadFile();
                        System.out.println("File 'file20.txt' has been loaded");
                        break;

                    case 2:
                        if (myQueue.isEmpty())
                        {
                            System.out.println("The queue is empty");
                        } 
                        else
                        {
                            System.out.println("The queue is NOT empty");
                        }
                        break;


                    case 3:
                        addInput();
                        break;


                    case 4:
                        System.out.println(myQueue.peek());
                        break;


                    case 5:
                        removeBig();
                        break;
                }
            } else if (choice == -1)
            {
                break;
            } else
            {
                System.out.println("Invalid Option Selected");
            }
        } while (choice != -1);
        console.close();
    }
}


