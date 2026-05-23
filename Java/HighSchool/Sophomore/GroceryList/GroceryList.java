
public class GroceryList
{
    
    private double myItem1;
    private double myItem2;
    private double myItem3;
    private double myItem4;
    private double myItem5;
    public GroceryList(double one,double two,double three,double four,double five)
    {
        myItem1 = one;
        myItem2 = two;
        myItem3 = three;
        myItem4 = four;
        myItem5 = five;
    }

    public void output()
    { 
        
        double subtotal = 0.0;
        
        System.out.printf("%10s","Item:");
        System.out.printf("%10s","Cost:");
        System.out.printf("%10s","Total:");
        System.out.println();

        subtotal += myItem1;
        System.out.printf("%10s","#1");
        System.out.printf("%10.2f",myItem1);
        System.out.printf("%10.2f",subtotal);
        System.out.println();

        subtotal += myItem2;
        System.out.printf("%10s","#2");
        System.out.printf("%10.2f",myItem2);
        System.out.printf("%10.2f",subtotal);
        System.out.println();

        subtotal += myItem3;
        System.out.printf("%10s","#3");
        System.out.printf("%10.2f",myItem3);
        System.out.printf("%10.2f",subtotal);
        System.out.println();

        subtotal += myItem4;
        System.out.printf("%10s","#4");
        System.out.printf("%10.2f",myItem4);
        System.out.printf("%10.2f",subtotal);
        System.out.println();

        subtotal += myItem5;
        System.out.printf("%10s","#5");
        System.out.printf("%10.2f",myItem5);
        System.out.printf("%10.2f",subtotal);


    }
}
