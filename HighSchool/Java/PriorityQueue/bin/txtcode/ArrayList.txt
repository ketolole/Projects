public class ArrayList<E>
{
    private E[] myArray;
    private int mySize;


    public ArrayList()
    {
        myArray = (E[]) new Object[10];
        mySize = 0;
    }


    public ArrayList(int capacity)
    {
        if (capacity == 0)
        {
            capacity = 10;
        }
        else if (capacity < 0)
        {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        myArray = (E[]) new Object[capacity];
        mySize = 0;
    }


    public int size()
    {
        return mySize;
    }


    public boolean isEmpty()
    {
        return mySize == 0;
    }


    public boolean add(E element)
    {
        if (mySize == myArray.length)
        {
            int newLen = myArray.length * 2;


            E[] temp = myArray;


            myArray = (E[]) new Object[newLen];
            for (int i = 0; i < temp.length; i++)
            {
                myArray[i] = temp[i];
            }
        }
        myArray[mySize] = element;
        mySize++;
        return true;
    }


    public void add(int i, E element)
    {
        if (i > mySize || i < 0)
        {
            throw new IndexOutOfBoundsException("java.lang.IndexOutOfBoundsException, Index: " + i + " Size: " + mySize);
        }
        else
        {
            if (mySize == myArray.length)
            {
                int newLen = myArray.length * 2;


                E[] tempArr = myArray;


                myArray = (E[]) new Object[newLen];
                for (int j = 0; j < tempArr.length; j++)
                {
                    myArray[j] = tempArr[j];
                }
            }
            for (int index = mySize - 1; index >= i; index--)
            {
                myArray[index + 1] = myArray[index];
            }
            myArray[i] = element;
            mySize++;
        }
    }


    public E set(int i, E element)
    {
        if (i >= mySize)
        {
            throw new IndexOutOfBoundsException("java.lang.IndexOutOfBoundsException, Index: " + i + " Size: " + mySize);
        }
        else if (i < 0)
        {
            throw new ArrayIndexOutOfBoundsException("java.lang.ArrayIndexOutOfBoundsException, " + i + " not in bounds");
        }
        else
        {
            E temp = myArray[i];
            myArray[i] = element;
            return temp;
        }
    }


    public E get(int i)
    {
        if (i >= mySize)
        {
            throw new IndexOutOfBoundsException("java.lang.IndexOutOfBoundsException, Index: " + i + " Size: " + mySize);
        }
        else if (i < 0)
        {
            throw new ArrayIndexOutOfBoundsException("java.lang.ArrayIndexOutOfBoundsException, " + i + " not in bounds");
        }
        return myArray[i];
    }


    public E remove(int i)
    {
        if (i >= mySize)
        {
            throw new IndexOutOfBoundsException("java.lang.IndexOutOfBoundsException, Index: " + i + " Size: " + mySize);
        }
        else if (i < 0)
        {
            throw new ArrayIndexOutOfBoundsException("java.lang.ArrayIndexOutOfBoundsException, " + i +  " not in bounds");
        }
        else
        {
            E removed = myArray[i];
            for (int index = i; index < mySize - 1; index++)
            {
                myArray[index] = myArray[index + 1];
            }


            mySize--;
            myArray[mySize] = null;
            return removed;


        }


    }
    /*
     *
     *
     *
     * ; // Returns the number of elements // currently stored in the list boolean isEmpty(); // Returns true if the list is empty, // otherwise returns false boolean add(E element); // Appends element at
     * the end of the list; // returns true void add(int i, E element); // Inserts element before the i-th element; // increments the indices of the // subsequent elements by 1 E set(int i, E element); //
     * Replaces the i-th element with element; // returns the old value E get(int i); // Returns the value of the i-th element E remove(int i); // Removes the i-th element from the // list and returns its
     * old value; // decrements the indices of the // subsequent elements by 1
     *
     *
     *
     *
     * for the add methods, if size == capacity (myArray.length), create new array w/ double capacity, copy vals over, and then add the object to be added
     *
     * add/remove methods may have to have loops to shift values (not a swap, but a shift)
     *
     * in remove, since the size changes, but not the capacity, the number of slots in the array doesn't change. SO, be sure to replace the last slot with a null
     *
     * add, get, set, remove need to throw the appropriate exception AND MESSAGE if out of bounds
     *
     * if pass in 0 for capacity, have add method create new array of length 1
     */
}


/*
 * 0 1 2 3 4 5 6 7 8 9 5 1 2 null null null null null null null
 *
 *
 * size() --> 4
 *
 * .remove(1)
 */





