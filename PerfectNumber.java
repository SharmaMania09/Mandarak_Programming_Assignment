import java.io.*;
import java.util.Scanner;

/**
 * Time Complexity - O(logN)
 * Space Complexity - O(1)
 */
public class PerfectNumber
{
    /**
     * This function is used to find if a number is perfect or not
     * A perfect number is a positive integer that is equal to the sum of its proper divisors (excluding itself)
     * @param number - Input number
     * @return - boolean true or false - Returns true if number is perfect number and false if not
     * @throws Exception - Throws both checked and unchecked exception
     */
    public static boolean isPerfect(int number) throws Exception
    {
        try
        {
            int sum = 1;
            // Loop until the square root of the number
            for(int index=2;index<=Math.sqrt(number);index++)
            {
                // If remainder is 0, that means found a divisor
                if (number%index == 0)
                {
                    sum += index;
                    // This is used to add the Quotient also
                    if(index != number/index)
                    {
                        sum += number/index;
                    }
                }
            }
            // If the sum is equal to number than returning true else false
            return (sum == number && number != 1);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    // Starting Point of execution of program
    public static void main(String[] args) throws Exception
    {
        int number = 496;

        /* Uncomment this to take user input

            Scanner scan = new Scanner(System.in);

            number = scan.nextInt();

        */

        System.out.println(isPerfect(number));
    }
}
