import java.util.Random;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        int ARRAY_SIZE = 100;
        int[] data = new int[ARRAY_SIZE]; // index from 0-99
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        // initialize the int values from 1 - 100
        for(int e = 0; e < data.length; e++)
        {
            data[e] = rnd.nextInt(100) + 1; // adding 1 shifts the entire range to be from 1 - 100
        }
        for(int e = 0; e < data.length; e++)
        {
            System.out.printf("%1d | ", data[e]);

        }
        System.out.println(""); // fixes "process finished" line displacement in "e" code


        //average
        // to do average, first you must get the sum of your numbers
        int sum = 0;
        for(int e = 0; e < data.length; e++)
        {
            sum = sum + data[e]; // sum += e
        }
        int ave = sum / data.length;
        System.out.println("The average of the data set is: " + ave);
        System.out.println("The sum of the data set is: " + sum);



        //minimum and maximum
        int min = data[0];
        int max = data[0];
        for(int e = 0; e < data.length; e++)
        {
            if(min > data[e])
            {
                min = data[e];
            }
            if(max < data[e])
            {
                max = data[e];
            }
        }
        System.out.println("\nThe minimum is: " + min);
        System.out.println("The maximum is: " + max);



        // linear (brute force) search Find Last

        int searchTarget = 0;
        int searchCounter = 0;
        boolean foundTarget = false;
        searchTarget = getInt(in, "\nEnter value to search for"); // used safe int method


        for(int e = 0; e < data.length; e++)
        {
            if(data[e] == searchTarget)
            {
                foundTarget = true;
                System.out.println("Found " + searchTarget + " at index " + e); // shows all instances of searchTarget
                searchCounter++;
            }
        }
        System.out.println("Your number was found " + searchCounter + " time(s).");
        if (!foundTarget) // goes after for loop
        {
            System.out.println("Target " + searchTarget + " was not found!");
        }



/*
        // short circuit search with break Find First
        foundTarget = false;

        for(int e = 0; e < data.length; e++)
        {
            if(data[e] == searchTarget)
            {
                foundTarget = true;
                System.out.println("Breaking! Found " + searchTarget + " at index " + e); // shows all instances of searchTarget
                break; // break cuts off the loop early
            }

        }
        if (!foundTarget)
        {
            System.out.println("Target " + searchTarget + " was not found!");
        }
        */

    }

    public static double getAverage(int values[])
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

        return ave;
    }


    // USED FOR GETTING SAFE INT INPUT:
    /**
     * Gets an int val from the user with no constraints
     * @param pipe Scanner to use for the input
     * @param prompt Msg to user for what to enter
     * @return any valid int
     */
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