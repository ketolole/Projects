import java.util.NoSuchElementException;

public class PriorityQueue<E>
{
  private ArrayList<E> myArray;


  public PriorityQueue()
  {
    myArray = new ArrayList<E>();
    myArray.add(null);
  }


  public void add(E item)
  {
    myArray.add(item);
    heapUp(item);
  }


  private void heapUp(E item)
  {

    int index = myArray.size()-1;
    while (index > 1 && ((Comparable) myArray.get(index / 2)).compareTo((Comparable) myArray.get(index)) > 0)
    {
    int parentIndex = index / 2;
      myArray.set(index, myArray.get(parentIndex));
      myArray.set(parentIndex, item);
      index = parentIndex;
    }
  }


  public E remove()
  {
    if(isEmpty())
    {
      throw new NoSuchElementException("java.util.NoSuchElementException: null");
    }
    E root = myArray.get(1);
    if(myArray.size() > 2)
    {
    myArray.set(1, myArray.remove(myArray.size()-1));
    heapDown(myArray.get(1));
    }
    else
    {
      myArray.remove(1);
    }
    return root;


  }


  private void heapDown(E item)
  {
    int index = 1;
    while (index < myArray.size())
    {
      int leftChildIndex = index * 2;
      int rightChildIndex = leftChildIndex + 1;

      if (rightChildIndex < myArray.size())
      {
        if (((Comparable) myArray.get(leftChildIndex)).compareTo((Comparable) myArray.get(rightChildIndex)) <= 0 && ((Comparable) myArray.get(index)).compareTo((Comparable) myArray.get(leftChildIndex)) > 0)
        {
          // if left <= right & check if top is greater than child
          myArray.set(index, myArray.get(leftChildIndex));
          myArray.set(leftChildIndex, item);
          index = leftChildIndex;
        }
        else if (((Comparable) myArray.get(index)).compareTo((Comparable) myArray.get(rightChildIndex)) > 0)
        {
          // if left > right
          myArray.set(index, myArray.get(rightChildIndex));
          myArray.set(rightChildIndex, item);
          index = rightChildIndex;
        }
        else
        {
          return;
        }
      }
      else if (leftChildIndex < myArray.size() && ((Comparable) myArray.get(leftChildIndex)).compareTo((Comparable) myArray.get(index)) < 0)
      {
        myArray.set(index, myArray.get(leftChildIndex));
        myArray.set(leftChildIndex, item);
        index = leftChildIndex;
      }
      else
      {
        return;
      }
    }
  }


  public boolean isEmpty()
  {
    return myArray.size() == 1;
  }


  public E peek()
  {
    if (isEmpty())
    {
      return null;
    }
    else
    {
      return myArray.get(1);
    }
  }


}
/*
 * PriorityQueue<E> class will have:
 *
 * private ArrayList<E> (yours from scratch)
 *
 * Constructor will add null to ArrayList
 *
 * Methods void add(E item) boolean isEmpty() E peek() E remove()
 *
 * add will have a heapUp helper method remove will have a heapDown helper method
 *
 *
 * Remember that index 0 is null, so isEmpty and peek will be looking at/for index 1 (meaning size)
 *
 * You'll have a menu that allows the user to call add, isEmpty, peek, and remove. It will also have a loadFile method, which will load file20.
 */



