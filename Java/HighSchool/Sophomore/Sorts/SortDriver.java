import java.util.*;
public class SortDriver
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);

        System.out.print("Give an postive integer to add to list(-1 or below to end): ");
        int numb = input.nextInt();

        while(numb > -1)
        {
            list.add(numb);
            System.out.print("Give an postive integer to add to list(-1 or below to end): ");
            numb = input.nextInt();
        }

        System.out.print("Created List: ");
        QuadraticSorts.printAll(list);

        MergeSortArrayList.mergeSort(list,0,list.size()-1);
        System.out.println();

        System.out.print("Sorted List: ");
        QuadraticSorts.printAll(list);
        input.close();
    }
}