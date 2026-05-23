



/**
*  Description of the Class
*
* @author     G. Peck
* @created    July 18, 2002
*
* Modified by Jason Quesenberry and Nancy Quesenberry
* February 9, 2006
*/
import java.util.*;




public class HashTable
{
    private int size;
    private int capacity;
    private ListNode[] myHashTable;




    public HashTable()
    {
        size = 0;
        capacity = 600;
        myHashTable = new ListNode[capacity];
    }




    public HashTable(int numSlots)
    {
        size = 0;
        capacity = numSlots;
        myHashTable = new ListNode[capacity];
    }




    public int getSize()
    {
        return size;
    }




    public int getCapacity()
    {
        return capacity;
    }




    public void add(Object obj)
    {
        // add to array in location determined by call to hashCode()
        int index = ((Item) obj).hashCode();
        myHashTable[index] = new ListNode((Item) obj, myHashTable[index]);
        size++;
    }




    public Object find(Comparable target)
    {
        // will attempt to find idToFind in table, if found return item,
        // else return null (use hashCode to find location, if it's in there)
        int index = ((Item) target).hashCode();
        if (myHashTable[index] == null)
        {
            return null;
        }
        else
        {
            ListNode temp = myHashTable[index];
            while (temp != null)
            {
                if (temp.getValue().equals(target))
                {
                    return (temp.getValue());
                }
                else
                {
                    temp = temp.getNext();
                }
            }
        }
        return null;
    }




    public int getNumberOfNulls()
    {
        int numbNull = 0;
        for (int i = 0; i < capacity; i++)
        {
            if (myHashTable[i] == null)
            {
                numbNull++;
            }
        }
        return numbNull;
    }




    public int getLongestList()
    {
        int max = 0;
        for (int i = 0; i < capacity; i++)
        {
            int count = 0;
            ListNode current = myHashTable[i];
            while (current != null)
            {
                count++;
                current = current.getNext();
            }
            if (count > max)
            {
                max = count;
            }
        }
        return max;




    }




    public void displayList()
    {
        int count = 0;
        for (ListNode nodes : myHashTable)
        {
            if (nodes == null)
            {
                System.out.println(count + ": ");
            }
            else
            {
                ListNode temp = nodes.getNext();
                System.out.print(count + ": " + nodes.getValue().toString());
                while (temp != null)
                {
                    System.out.print(" | " + temp.getValue().toString());
                    temp = temp.getNext();
                }
                System.out.println();




            }
            count++;
        }




    }




}















