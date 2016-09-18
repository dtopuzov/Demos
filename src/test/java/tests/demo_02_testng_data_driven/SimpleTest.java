package tests.demo_02_testng_data_driven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleTest {

    // This method will provide data to any test method that
    // declares that its Data Provider is named "simpleDataProvider"
    @DataProvider(name = "simpleDataProvider")
    public Object[][] createData() {
        return new Object[][]{
                {"Dimitar", 31},
                {"Vasil", 27},
        };
    }

    // This test method declares that its data
    // should be supplied by the Data Provider named "simpleDataProvider"
    @Test(dataProvider = "simpleDataProvider")
    public void verifyNameAndAge(String name, Integer age) {
        System.out.println(name + " age is " + age);
    }
}
