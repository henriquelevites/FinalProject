package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOpps {

    /*
     #####################################################################
     Method name: getDataObject
     Method description: This method calls 'getDataFromCSV' function.
     Method parameter: none
     Method return: Two dimensional array of objects
     #####################################################################
   */
    @DataProvider(name="data-provider-login")
    public Object[][] getDataObject()
    {
        return getDataFromCSV(getConfigData("DDTFile"));   // ./ means from the relative path I'm now
    }

    /*
     #####################################################################
     Method name: getDataFromCSV
     Method description: This method calls 'readCSV' function.
     Method parameter: String filePath - path of a file.
     Method return: Two dimensional array of objects
     #####################################################################
   */
    public static Object[][] getDataFromCSV (String filePath)
    {
        Object[][] data = new Object[Integer.parseInt(getConfigData("CsvRows"))][Integer.parseInt(getConfigData("CsvColumns"))];
        List<String> csvData = readCSV(filePath);
        for (int i=0; i < csvData.size(); i++)
        {
            data[i][0] = csvData.get(i).split(",")[0]; // separate from all CSV only the 1st word in current line
            data[i][1] = csvData.get(i).split(",")[1]; // separate from all CSV only the 2nd word in current line
        }

        return data;

    }

    /*
     #####################################################################
     Method name: readCSV
     Method description: This method reads all lines from a CSV file.
     Method parameter: String csvFile - path of CSV file (including file name)
     Method return: List of strings 'lines'
     #####################################################################
   */
    public static List<String> readCSV(String csvFile)
    {
        List<String> lines = null;      // the list of strings will represent the lines in file
        File file = new File(csvFile);  // create object from class File that receives the file path
        try                             // try/catch because we read an external file
        {                               // initialize 'lines' that reads all lines and enters them in a list of Strings:
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        }
        catch (IOException e){
            System.out.println("Some Error. See Details: " + e);
        }
        return lines;

    }
}
