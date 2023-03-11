import java.util.ArrayList;
import java.util.Scanner;

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class ShortestDistance
{
    /**
     * This function is used to find the shortest distance of Manhattan Path from the starting point and ending point after following the path
     * The approach is if N and E, then adding 1 and if S and W, then subtracting 1 from the x and y coordinate
     * @param startPointArr - Contains the x and y coordinate from where we need to start
     * @param pathStr - Path string which we need to follow to find the
     * @return - String which is a double number formatted up to 1 decimal place
     * @throws Exception - Throws both checked and unchecked exception
     */
    public static String findShortestDistance(int[] startPointArr, String pathStr) throws Exception
    {
        try
        {
            // Input or Starting x and y coordinates
            int xCoordinate = startPointArr[0];
            int yCoordinate = startPointArr[1];

            // Ending x and y coordinates
            int finalXCoordinate = 0;
            int finalYCoordinate = 0;
            //
            for(int index=0;index<pathStr.length();index++)
            {
                char ch = pathStr.charAt(index);
                // If N, then adding 1 to final x coordinate
                if(ch == 'N')
                {
                    finalXCoordinate++;
                }
                // If E, then adding 1 to final y coordinate
                else if(ch == 'E')
                {
                    finalYCoordinate++;
                }
                // If W, then subtracting 1 from final y coordinate
                else if(ch == 'W')
                {
                    finalYCoordinate--;
                }
                // If S, then subtracting 1 from final x coordinate
                else
                {
                    finalXCoordinate--;
                }
            }
            //
            double ans;
            // If both are less than input x and y, then retuning 0 as no output for
            if(finalXCoordinate < xCoordinate && finalYCoordinate < yCoordinate)
            {
                return "0";
            }
            // If final x coordinate is less than x, then calculating only for y coordinate
            else if(finalXCoordinate < xCoordinate)
            {
                ans = Math.sqrt(Math.pow((finalYCoordinate - yCoordinate),2));
            }
            // If final y coordinate is less than x, then calculating only for x coordinate
            else if(finalYCoordinate < yCoordinate)
            {
                ans = Math.sqrt(Math.pow((finalXCoordinate-xCoordinate), 2));
            }
            // Taking both x and y coordinate in result
            else
            {
                ans = Math.sqrt(Math.pow((finalXCoordinate-xCoordinate), 2) + Math.pow((finalYCoordinate-yCoordinate), 2));
            }
            // This is used to format the double to 1 decimal place
            return String.format("%.1f", ans);
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
        /* Uncomment to take user input

            Scanner scan = new Scanner(System.in);

            int[] inputArr = new int[2];

            for(int index=0;index<2;index++)
            {
                inputArr[index] = scan.nextInt();
            }
            //
            String inputStr = scan.next();

        */

        int inputArr[] = {0,0};
        String inputStr = "NNNNEEENE";
        //
        System.out.println(findShortestDistance(inputArr, inputStr));
    }
}
