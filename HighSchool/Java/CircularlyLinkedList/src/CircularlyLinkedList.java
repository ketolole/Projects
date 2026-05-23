import java.util.*;
public class CircularlyLinkedList
{
    private DListNode first;  // first element
    private DListNode last;
    /**
     *  Constructor for the SinglyLinkedList object
     *  Generates an empty list.
     */
    public CircularlyLinkedList()
    {
        first = null;   
        last = null;
    }

    public DListNode getFirstNode()
    {
        return first;
    }

    public DListNode getLastNode()
    {
        return last;
    }

    /**
     *  Returns the first element in this list.
     *
     * @return  the first element in the linked list.
     */
    public Object getFirst()
    {
        if (first == null)
        {
            throw new NoSuchElementException();
        }
        else
            return first.getValue();
    }  

    /**
     *  Inserts the given element at the beginning of this list.
     *
     * @param  value  the element to be inserted at the beginning of this list.
     */
    public void addFirst(Object value)
    {
        DListNode toAdd = new DListNode(value, first, last);
        if (first == null)
        {
            first = toAdd;
            last = toAdd;
            first.setNext(first);
            first.setPrevious(first);
        }
        else
        {
            first.setPrevious(toAdd); 
            last.setNext(toAdd);      

            first = toAdd;
        }
    }

    public Object getLast()
    {
        if (first == null)
        {
            throw new NoSuchElementException();
        }
        else
        {
            return last.getValue();
        }
    }  

    public void addLast(Object value)
    {
        DListNode toAdd = new DListNode(value, first, last);
        if (first == null) 
        {
            first = toAdd;
            last = toAdd;
            first.setNext(first);
            first.setPrevious(first);
        } 
        else 
        {
            last.setNext(toAdd);
            first.setPrevious(toAdd);
            last = toAdd;
        }
    }

    public boolean remove(Object toRemove)
    {
        DListNode front = first;
        DListNode back = first;

        if (front == null) 
        {
            return false;
        }
        if(((Item)front.getValue()).equals((Item)toRemove))
        {
            front = front.getNext();
            if(first == front)
            {
                clear();
            }
            else
            {
                first = front;
                first.setPrevious(last);
                last.setNext(first);
            }
            return true;
        }
        front = front.getNext();
        while(front != first && !((Item)front.getValue()).equals((Item)toRemove))
        {
            back = front;
            front = front.getNext();
        }
        if (front != first) 
        {
            back.setNext(front.getNext());
            front.getNext().setPrevious(back);
            if(back == back.getNext())
            {
                first = back;
                last = back;
            }
            else if(back.getNext() == first)
            {
                last = back;
            }
            return true;
        }
        return false;
    }

    /**
     *  Print the contents of the entire linked list
     */
    public void printList()
    {
        DListNode temp = first;
        int count = 1;

        if (first != null) 
        {
            do
            {
                System.out.printf("%-2d", count);
                System.out.println(" " + temp.getValue() + " ");
                count++;
                temp = temp.getNext();
            }
            while(temp != first);
        }

    }

    public void clear() 
    {
        first = null;
        last = null;
    }

    public int size()
    {
        DListNode temp = first;
        int count = 0; 

        if (first == null) 
        {
            return 0;
        }
        do
        {
            count++;
            temp = temp.getNext();
        }
        while(temp != first);

        return count;
    }

    public void insert(Object toInsert)
    {
        DListNode front = first;
        DListNode back = first;

        DListNode toAdd = new DListNode(toInsert, null, null);

        if(first == null)
        {
            addFirst(toInsert);
        }
        else if(((Item)toInsert).compareTo(first.getValue()) < 0)
        {
            addFirst(toInsert);
        }
        else
        {
            front = front.getNext();
            while(front != first && ((Item)toInsert).compareTo(front.getValue()) > 0)
            {
                back = front;
                front = front.getNext();
            }
            if (front == first) 
            {
                addLast(toInsert);
            }
            else
            {
                back.setNext(toAdd);
                toAdd.setPrevious(back);

                toAdd.setNext(front);
                front.setPrevious(toAdd);
            }
        }
    }

    public DListNode find(Item toFind)
    {
        DListNode temp = first;
        if(first == null)
        {
            return null;
        }
        if(((Item)temp.getValue()).equals(toFind))
        {
            return temp;
        }
        temp = temp.getNext();

        while(temp != first && !((Item)temp.getValue()).equals((Item)toFind))
        {
            temp = temp.getNext();
        }
        if(temp == first)
        {
            return null;
        }
        else
        {
            return temp;
        }
    }

    public void printBackwards()
    {
        DListNode temp = last;
        int count = 1;
        if(first != null)
        {
            do
            {
                System.out.printf("%-2d", count);
                System.out.println(" " + temp.getValue() + " ");
                temp = temp.getPrevious();

                count++;
            }
            while(temp != last);
        }

    }

    /**
     *  Returns a string representation of this list. The string
     *  representation consists of the list's elements in order,
     *  enclosed in square brackets ("[]"). Adjacent elements are
     *  separated by the characters ", " (comma and space).
     *
     * @return    string representation of this list
     */
    public String toString()
    {
        String s = "[";

        DListNode temp = first;  // start from the first node

        if(temp != null)
        {
            do
            {
               s += temp.getValue(); // append the data
               temp = temp.getNext();      // go to next node
               s += ", ";
            }
            while(temp != first);
        }
        s += "]";
        return s;
    }  

}
