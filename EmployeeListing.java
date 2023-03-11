import java.io.*;
import java.util.*;

/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class EmployeeListing
{
    /**
     * This function takes input from employees.csv file and output it to managers.csv and single_name_employees.csv base on the queries
     * @throws Exception - Throws both checked and unchecked exception
     */
    public static void employeeListing() throws Exception
    {
        // Input and Output file paths
        String employeesInputPath = "C:\\Users\\Downloads\\Assignment\\employees.csv";
        String managerOutputPath = "C:\\Users\\Downloads\\Assignment\\managers.csv";
        String singleNameEmployeesPath = "C:\\Users\\Downloads\\Assignment\\single_name_employees.csv";

        try
        {
            // BufferedReader is used to read the contents of the file line by line and also to write into output files
            // We can have used these statements in try block which can give us advantage of flush automatically after the program is over executing
            BufferedReader employeeFile = new BufferedReader(new FileReader(employeesInputPath));
            BufferedWriter managerOutputFile = new BufferedWriter(new FileWriter(managerOutputPath));
            BufferedWriter singleNameEmployeeFile = new BufferedWriter(new FileWriter(singleNameEmployeesPath));

            String line;
            // Reading each line from employees.csv file
            while ((line = employeeFile.readLine()) != null)
            {
                // Splitting the line by using delimiter as ","
                String[] tokens = line.split(",");
                //
                String name = tokens[0].trim();
                String role = tokens[1].trim();
                String division = tokens[2].trim();

                // For Debugging
                //System.out.println(name+", "+role+", "+division);

                // This case is used because the input file contains the heading part and it would have included in any of the below case
                if(name.equalsIgnoreCase("Name") && role.equalsIgnoreCase("Role"))
                {
                    continue;
                }
                // This is the case when we want to collect the details of Employees who are managers in the R&D division.
                if (role.equalsIgnoreCase("Manager") && division.equalsIgnoreCase("R&D"))
                {
                    managerOutputFile.write(line);
                    managerOutputFile.newLine();
                }
                // This is the case when we want to collect the details of the Employees who do not have last names
                if (!name.contains(" "))
                {
                    singleNameEmployeeFile.write(line);
                    singleNameEmployeeFile.newLine();
                }
            }
            // This  we are doing to write in file
            // We can ignore this if the BufferedReader should have used in the try block
            managerOutputFile.flush();
            singleNameEmployeeFile.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // Starting Point of execution of program
    public static void main(String[] args) throws Exception
    {
        employeeListing();
    }
}
