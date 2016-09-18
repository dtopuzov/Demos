**tests.demo_03_testng_data_driven**

Simple data drivn test:
tests.demo_03_testng_data_driven.SimpleTest

Data driven from CSV file:
tests.demo_03_testng_data_driven.ComplexTest

Notes: 

If data provider is in other class, then class name should be specified in annotation:
```
@Test(dataProviderClass = CsvDataProvider.class, dataProvider = "csvDataProvider")
```
and data provider method must be static:
```
@DataProvider(name = "csvDataProvider")
public static Object[][] createData() throws IOException {
```