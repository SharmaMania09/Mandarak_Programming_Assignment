import java.io.*;
import java.util.*;

/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(n)
 */
public class CombinationSort
{
    /**
     * This function is used to print L1 and L2 strings which are sorted based on the condition given in the question
     * @param uniqueStringList - ArrayList containing the strings which needs to be sorted
     * @throws Exception - Throws both checked and unchecked exception
     */
    public static void findCombination(ArrayList<String> uniqueStringList) throws Exception
    {
        try
        {
            /* ------------------------------------------- For L1 ------------------------------------------------ */

            // This is used to sort the arraylist based on the first character of each string
            // Here we are using comparator which is used for comparing objects of different classes
            Collections.sort(uniqueStringList, (s1, s2) -> s1.charAt(0) - s2.charAt(0));

            String l1Str = "L1 : ";
            // This loop is used to create output string for L1 case
            for(int index=0;index<uniqueStringList.size();index++)
            {
                l1Str += uniqueStringList.get(index) + ", ";
            }

            /* ------------------------------------------- For L2 ------------------------------------------------ */

            /**
             * The approach for L2 is
                * 1) LinkedHashmap(To maintain the order of insertion) with key as character and value as an arraylist
                * 2) Taking the first character from the string and checking if map contains that key or not
                    * a) If map contains key, then get the arraylist and parse the integer and add in arraylist
                    * b) If not, then create new arraylist and parse the integer and add in arraylist
                * 3) Now traverse in teh hashmap and take the list and sort the arraylist using Collections in reverse order and then create the output string
             */
            HashMap<Character, ArrayList<Integer>> characterVsIntegerListMap = new LinkedHashMap<>();
            //
            for(int index=0;index<uniqueStringList.size();index++)
            {
                String str = uniqueStringList.get(index);
                // Taking first character of string as it will always be character
                char ch = str.charAt(0);

                // The remaining string contains number. So, parsing using Integer.parseInt()
                int parsedNumber = Integer.parseInt(str.substring(1));

                // Checking if map contains the key or not
                // If contains, then taking the arraylist and if not then creating new arraylist
                ArrayList<Integer> mapList = characterVsIntegerListMap.containsKey(ch) ? characterVsIntegerListMap.get(ch) : new ArrayList<>();

                mapList.add(parsedNumber);

                characterVsIntegerListMap.put(ch, mapList);
            }
            //
            String l2Str = "L2 : ";
            //
            for(Map.Entry<Character, ArrayList<Integer>> mapEle : characterVsIntegerListMap.entrySet())
            {
                char ch = mapEle.getKey();
                ArrayList<Integer> numberList = mapEle.getValue();
                // TO sort the arraylist in reverse order
                Collections.sort(numberList, Collections.reverseOrder());
                //
                for(int index=0;index<numberList.size();index++)
                {
                    String outputStr = "" + ch + numberList.get(index);
                    //
                    l2Str += outputStr + ", ";
                }
            }
            //
            System.out.println(l1Str.substring(0, l1Str.length()-1));
            System.out.println(l2Str.substring(0, l2Str.length()-1));
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
        ArrayList<String> list = new ArrayList<>();

        /* Uncomment this code to take user input

            Scanner scan = new Scanner(System.in);

            int n = scan.nextInt();

            for(int index=0;index<n;index++)
            {
                int temp = scan.nextInt();
                list.add(temp);
            }

        */

        list.add("d34");
        list.add("g54");
        list.add("d12");
        list.add("b87");
        list.add("g1");
        list.add("c65");
        list.add("g40");
        list.add("g5");
        list.add("d77");

        findCombination(list);
    }
}
