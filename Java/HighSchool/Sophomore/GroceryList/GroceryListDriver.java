
import java.util.Scanner;
public class GroceryListDriver
{
    public static void main(String[] args)
    {
        
        
    Scanner input = new Scanner(System.in);
    
    System.out.printf("%20s","Enter item #1 cost: ");
    double itemOneCost = input.nextDouble();
    
        System.out.printf("%20s","Enter item #2 cost: ");
    double itemTwoCost = input.nextDouble();
    
        System.out.printf("%20s","Enter item #3 cost: ");
    double itemThreeCost = input.nextDouble();
    
        System.out.printf("%20s","Enter item #4 cost: ");
    double itemFourCost = input.nextDouble();
    
        System.out.printf("%20s","Enter item #5 cost: ");
    double itemFiveCost = input.nextDouble();
    
    System.out.println();
    
    GroceryList groceries = new GroceryList(itemOneCost,itemTwoCost,itemThreeCost,itemFourCost,itemFiveCost);
    groceries.output();
    

    }
}
