**tests.demo_01_junit**

Show basics of JUnit testing.

Add JUnit dependency to pom.xml:
```
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
```   
     
Test methods are annotated with @Test:
```
    @Test
    public void testAdd() {
        String str = "Junit is working fine";
        assertEquals("Junit is working fine",str);
    }
```

See demos in:
- tests.demo_01_junit.JunitTest
