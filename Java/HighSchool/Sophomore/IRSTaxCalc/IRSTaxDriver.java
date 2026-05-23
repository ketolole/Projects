import java.util.Scanner;
public class IRSTaxDriver
{
   
    
    
    public static void main(String[] args)
   {
     Scanner input = new Scanner(System.in);
     
    
     System.out.print("Enter marital status (1=single, 2=married): ");
     int status = input.nextInt();
     
     System.out.print("Enter taxable income: $");
     double income = input.nextDouble();
     
    input.close();
    IRSTax davisClosedScanner = new IRSTax(status,income);
    System.out.print("Your Federal tax = ");
    System.out.printf("$%,.2f",davisClosedScanner.calcTax());
    }
    
    

}