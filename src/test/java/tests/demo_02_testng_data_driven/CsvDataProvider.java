package tests.demo_02_testng_data_driven;

import au.com.bytecode.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvDataProvider {

    // This method will provide data to any test method that
    // declares that its Data Provider is named "csvDataProvider"
    @DataProvider(name = "csvDataProvider")
    public static Object[][] createData() throws IOException {

        // Read CSV file
        FileReader file = new FileReader("src/test/java/tests/demo_02_testng_data_driven/TestData.csv");
        CSVReader csvReader = new CSVReader(file);
        List<String[]> dataList = csvReader.readAll();
        csvReader.close();

        // Generate Object[][] and return it
        Object[][] data = new Object[dataList.size()][2];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                String[] line = dataList.get(i);
                data[i][j] = line[j];
            }
        }

        return data;
    }
}
