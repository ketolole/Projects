
import java.util.Scanner;
public class Driver
{
    public static void main(String[] args)
    {

        System.out.println(Driver.stringE("hellow"));
    }

    public static boolean stringE(String str) {
        int numbE = 0;
        for(int i = 0; i < str.length(); i++)
        {
            if (str.substring(i,i+1).equals("e"))
            {
                numbE++;
                System.out.println(i);
            }
        }
        
        if (numbE >= 1 && numbE <=3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
