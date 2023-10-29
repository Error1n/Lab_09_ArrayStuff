import java.util.Scanner;

public class getAve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int howMany = getInt(in, "Enter how many values you will be calculating the average of");

        int[] getAverage = new int[howMany];

        System.out.println("Enter " + howMany + " numbers");

        for(int e = 0; e < howMany; e++)
        {
            getAverage[e] = in.nextInt();
        }

        int sum = 0;
        for(int e = 0; e < getAverage.length; e++)
        {
            sum = sum + getAverage[e]; // sum += e
        }
        int ave = sum / getAverage.length;

        System.out.println("The average of your numbers is: " + ave);
    }
    public static int getInt(Scanner pipe, String prompt)
    {
        boolean done = false;
        String trash = "";
        int value = 0;
        do
        {
            System.out.print(prompt + ": ");
            if(pipe.hasNextInt())
            {
                value = pipe.nextInt();
                pipe.nextLine(); // clear the buffer
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a number. You entered: " + trash);
            }

        }while(!done);

        return value;
    }

}
