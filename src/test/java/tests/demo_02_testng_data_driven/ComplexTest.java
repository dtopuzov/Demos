package tests.demo_02_testng_data_driven;

import org.testng.annotations.Test;

public class ComplexTest {

    // This test method declares that its data
    // should be supplied by the Data Provider named "simpleDataProvider"
    @Test(dataProviderClass = CsvDataProvider.class, dataProvider = "csvDataProvider")
    public void verifyNameAndAgeFromCsv(String name, String age) {
        System.out.println(name + " age is " + age);
    }
}