import java.io.*;
import java.util.Scanner;


public class Main
{
    private Scanner console;
    private ArrayList<String> myList;


    public Main()
    {
        console = new Scanner(System.in);
        myList = new ArrayList<String>(); // test with negative, zero, positive, no value
    }


    private void singleInput()
    {
        console = new Scanner(System.in);
        System.out.println("All inputs will be added to the list as strings");
        String input;
        do
        {
            System.out.print("Enter String input (-1 to quit): ");
            input = console.nextLine();
            if (input.equals("-1") == false)
            {
                    myList.add(input);
                    System.out.println("Object '" + input + "' has been added");  
            }
           
        } while (input.equals("-1") == false);
    }


    private void doubleInput()
    {
        // error with this method in it belives any index is too big
        console = new Scanner(System.in);
        System.out.println("All inputs will be added to the list as strings");
        String input;
        int index;
        do
        {
            console = new Scanner(System.in);
            System.out.print("Enter valid index (-1 to quit): ");
            index = console.nextInt();
            console.nextLine();
            if (index == -1)
            {
                return;
            }
            System.out.print("Enter String input (-1 to quit): ");
            input = console.nextLine();


            if (input.equals("-1") == false && index != -1)
            {
                try
                {
                    myList.add(index, input);
                    System.out.println("Object '" + input + "' has been added to slot " + index);
                }
                catch (IndexOutOfBoundsException e)
                {
                    System.out.println(e.getMessage());
                }


            }
        } while (index != -1);
    }


    private void set()
    {
        console = new Scanner(System.in);
        String item;
        int index;
        System.out.println("All new inputs will be handled as Strings");


        do
        {
            // do you wish to continue? -1, y/n?
            System.out.print("Enter valid index (-1 to quit): ");
            index = console.nextInt();
            console.nextLine();
            if (index == -1)
            {
                return;
            }
            System.out.print("Enter new String (-1 to quit): ");
            item = console.nextLine();
            if (item.equals("-1") == false)
            {
                try
                {
                    String replaced = myList.set(index, item);
                    System.out.println("Object '" + item + "' has replaced object '" + replaced + "' at index " + index);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Invalid index " + index);
                }
                catch (IndexOutOfBoundsException e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Invalid index " + index);
                }
            }
        } while (item.equals("-1") == false);
    }


    private void printList()
    {
        for (int i = 0; i < myList.size(); i++)
        {
            System.out.println(i + ": " + myList.get(i));
        }
    }


    private void get()
    {
        console = new Scanner(System.in);
        int index;
        do
        {
            System.out.print("Enter index (-1 to quit): ");
            index = console.nextInt();
            console.nextLine();
            if (index != -1)
            {
                try
                {
                    Object gotten = myList.get(index);
                    System.out.println("Object at index " + index + " is: " + gotten);
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Invalid index: " + index);
                }
                catch (IndexOutOfBoundsException e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Invalid index: " + index);


                }


            }
        } while (index != -1);
    }


    private void remove()
    {
        console = new Scanner(System.in);
        int index;
        do
        {
            System.out.print("Enter index (-1 to quit): ");
            index = console.nextInt();
            console.nextLine();
            if (index != -1)
            {
                try
                {
                    String str = myList.remove(index);
                    System.out.println("Object " + str + " at index " + index + " has been removed.");
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Invalid index: " + index);
                }
                catch (IndexOutOfBoundsException e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Invalid index: " + index);
                }
            }
        } while (index != -1);
    }


    public void mainMenu()
    {
        int choice;
        System.out.println("ArrayList Tester Has Been Initiated");
        do
        {
            System.out.println();
            System.out.println(" (1) Size");
            System.out.println(" (2) isEmpty");
            System.out.println(" (3) Add w/ 1 Parameter");
            System.out.println(" (4) Add w/ 2 Parameter");
            System.out.println(" (5) Set");
            System.out.println(" (6) Get");
            System.out.println(" (7) Remove");
            System.out.println(" (8) Print List");
            System.out.println("(-1) Quit\n");
            System.out.print("Choice ---> ");
            choice = console.nextInt();
            System.out.println();


            if (choice > 0 && choice <= 8)
            {
                switch (choice)
                {
                    case 1:
                        System.out.println("List Size: " + myList.size());
                        break;


                    case 2:
                        if (myList.size() == 0)
                            System.out.println("List is Empty");
                        else
                            System.out.println("List is not Empty");
                        break;


                    case 3:
                        singleInput();
                        break;


                    case 4:
                        doubleInput();
                        break;


                    case 5:
                        set();
                        break;


                    case 6:
                        get();
                        break;


                    case 7:
                        remove();
                        break;


                    case 8:
                        printList();
                        break;


                }
            }
            else if (choice == -1)
            {
                break;
            }
            else
            {
                System.out.println("Invalid Option Selected");
            }
        } while (choice != -1);
        console.close();
    }
}





