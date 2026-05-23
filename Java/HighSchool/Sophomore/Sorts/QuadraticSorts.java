import java.util.*;
public class QuadraticSorts
{
    public static void mergeSort(ArrayList<Integer> list, int first, int last)
    {
        if (last == first)
        {
            return;
        }
        else if (last - first == 1)
        {
            if(last<first)
            {
                int temp = list.get(first);
                list.set(first,list.get(last));
                list.set(last,temp);
            }
        }
        else // recursion, divide list into two halves
        {
            int middle = (first + last)/2;

            mergeSort(list, first, middle);
            mergeSort(list,middle + 1, last);
            merge(list, first, middle, last);
        }

    }

    public static void merge(ArrayList<Integer> list,int first,int middle, int last)
    {
        ArrayList <Integer> copy = new ArrayList <Integer>();
        for( int i = first; i<=last;i++)
        {
            copy.add(list.get(i));
        }

        int index1 = 0;
        int index2 = middle-first+1;

        for( int i = first; i <= last;i++)
        {
            if(index1 > middle-first)
            {
                list.set(i,copy.get(index2));
                index2++;
            }
            else if(index2 > last-first)
            {
                list.set(i,copy.get(index1));
                index1++;
            }
            else
            {
                if(copy.get(index1)<copy.get(index2))
                {
                    list.set( i,copy.get(index1));
                    index1++;
                }
                else
                {
                    list.set(i,copy.get(index2));
                    index2++;
                }
            }
        }
    }
    
    public static void printAll(ArrayList<Integer> list)
    {
    for(int num: list)
    {
    System.out.print(""+num + " ");
    }
    }
}