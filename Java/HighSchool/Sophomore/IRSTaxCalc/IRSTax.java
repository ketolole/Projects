public class IRSTax
{
    private int myStatus;
    private double myIncome;
    public IRSTax(int maritalStatus,double taxableIncome)
    {
         myStatus = maritalStatus;
         myIncome = taxableIncome;
    }

     public double calcTax()  
   {
      if (myStatus == 1)
         return calcSingleTax();  
      else
         return calcMarriedTax();
   }
    
    public double calcSingleTax()
    {
        double tax = 0.0;
        
        if (0 < myIncome && myIncome <= 27050)
        {
            tax = 0.15 * myIncome;
        }
        else if (27050 < myIncome && myIncome <= 65550)
        {
            tax = 4057.50 + 0.275*(myIncome-27050);
        }
        else if (65550 < myIncome && myIncome <= 136750)
        {
            tax = 14645.00 + 0.305*(myIncome-65550);
        }
        else if (136750 < myIncome && myIncome <= 297350)
        {
            tax = 36361.00 + 0.355*(myIncome-136750);
        }
        else
        {
            tax = 93374.00 + 0.391*(myIncome-297350);
        }
        return tax;
    }

    public double calcMarriedTax()
    {
        double tax = 0.0;
         if (0 < myIncome && myIncome <= 45200)
        {
            tax = 0.15 * myIncome;
        }
        else if (45200 < myIncome && myIncome <= 109250)
        {
            tax = 6780.00 + 0.275*(myIncome-45200);
        }
        else if (109250 < myIncome && myIncome <= 166500)
        {
            tax = 24393.75 + 0.305*(myIncome-109250);
        }
        else if (166500 < myIncome && myIncome <= 297350)
        {
            tax = 41855.00 + 0.355*(myIncome-166500);
        }
        else
        {
            tax = 88306.00 + 0.391*(myIncome-297350);
        }
        return tax;
    }
}