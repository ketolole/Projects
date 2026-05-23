import java.util.Scanner;
import java.io.*;

public class COrderedList
{
    public void testFind(CircularlyLinkedList list)
    {
        int idToFind;
        DListNode location;

        Scanner console = new Scanner(System.in);

        System.out.println("Testing search algorithm\n");
        System.out.print("Enter Id value to search for (-1 to quit) --> ");
        idToFind = console.nextInt();

        while (idToFind >= 0){
            location = (DListNode)list.find(new Item(idToFind, 0));
            if (location == null)
                System.out.println("Id = " + idToFind + "  No such part in stock");
            else
                System.out.println(location.getValue());
            System.out.println();
            System.out.print("Enter Id value to search for (-1 to quit) --> ");
            idToFind = console.nextInt();
        }
    }


    public void testDelete(CircularlyLinkedList list)
    {
        int idToDelete;
        boolean success;

        Scanner console = new Scanner(System.in);

        System.out.println("Testing delete algorithm\n");
        System.out.print("Enter Id value to delete (-1 to quit) --> ");
        idToDelete = console.nextInt();

        while (idToDelete >= 0)
        {
            Item idInvItem = new Item(idToDelete, 0);

            if (list.remove(idInvItem))
                System.out.println("     Id #" + idToDelete + " was deleted");
            else
                System.out.println("Id# " + idToDelete + "  No such part in stock");
            System.out.println();
            System.out.print("Enter Id value to delete (-1 to quit) --> ");

            idToDelete = console.nextInt();
        }
    }

    public void loadData(CircularlyLinkedList list)
    {
        Scanner inFile;

        String fileName = "file10.txt";
        int id, inv;

        try{

            inFile = new Scanner(new File(fileName));
            while(inFile.hasNext()){

                id = inFile.nextInt();
                inv = inFile.nextInt();
                list.insert(new Item(id, inv));
            }
        }catch(IOException i){
            System.out.println("Error: " + i.getMessage());
        }
    }

    public void addItem(CircularlyLinkedList head)
    {
        boolean run = true;      

        Scanner keyboard = new Scanner(System.in);

        while (run)
        {
            System.out.print("\nId of item to add: ");
            int id = keyboard.nextInt();
            System.out.print("Inventory of item to add: ");
            int inv = keyboard.nextInt();
            Item it = new Item(id, inv);
            keyboard.nextLine(); //flush newline
            head.insert(it);
            System.out.println("Item added\n");
            System.out.print("Continue (Y/N): ");
            String answer = keyboard.nextLine();
            run = answer.equalsIgnoreCase("Y");            
        }
    }

    public void mainMenu (CircularlyLinkedList head)
    {
        String choice;
        Scanner console = new Scanner(System.in);

        do{
            System.out.println("Linked List algorithm menu\n");
            System.out.println("(1) Read data from disk");
            System.out.println("(2) Print ordered list");
            System.out.println("(3) Search list");
            System.out.println("(4) Delete from list");
            System.out.println("(5) Clear entire list");
            System.out.println("(6) Count nodes in list");
            System.out.println("(7) Print list backwards");
            System.out.println("(8) Add an item");
            System.out.println("(Q) Quit\n");
            System.out.print("Choice ---> ");
            choice = console.nextLine() + " ";  // kludge to ensure choice.charAt(0) > 0

            System.out.println();

            if ('1' <= choice.charAt(0) && choice.charAt(0) <= '8'){
                switch (choice.charAt(0)){
                    case '1' :
                        loadData(head);
                        break;
                    case '2' :
                        System.out.println();
                        System.out.println("The tree printed inorder\n");
                        head.printList();
                        System.out.println();
                        break;
                    case '3' :
                        testFind(head);
                        break;
                    case '4' :
                        testDelete(head);
                        break;
                    case '5' :
                        head.clear();
                        break;
                    case '6' :
                        System.out.println("Number of nodes = " + head.size ());
                        System.out.println();
                        break;
                    case '7' :
                        head.printBackwards();
                        break;
                    case '8' :
                        addItem(head);
                        break; ///////////
                }
            }
        }
        while (choice.charAt(0) != 'Q' && choice.charAt(0) != 'q');
    }
}

