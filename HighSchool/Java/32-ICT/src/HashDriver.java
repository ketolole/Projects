import java.util.Scanner;


public class HashDriver
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        Hashing hashBrown = new Hashing();
        String input = "";
        do
        {
            System.out.println("\nHash Menu\n");
            System.out.println("(1) Load file and print file");
            System.out.println("(2) Search");
            System.out.println("(3) Print Stats");
            System.out.println("(-1) exit");
            System.out.print("Input number: ");
            input = console.nextLine();
            System.out.println();


            switch (input)
            {
                case "1":
                    hashBrown.loadFile();
                    break;
                case "2":
                    hashBrown.search();
                    break;
                case "3":
                    hashBrown.stats();
                    break;
            }
        } while (!input.equals("-1"));
        console.close();
    }


}
