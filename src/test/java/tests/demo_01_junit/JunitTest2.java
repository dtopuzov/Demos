package tests.demo_01_junit;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class JunitTest2 {

    //execute only once, in the starting
    @BeforeClass
    public static void beforeClass() {
        System.out.println("in before class");
    }

    //execute only once, in the end
    @AfterClass
    public static void  afterClass() {
        System.out.println("in after class");
    }

    //execute for each test, before executing test
    @Before
    public void before() {
        System.out.println("in before");
    }

    //execute for each test, after executing test
    @After
    public void after() {
        System.out.println("in after");
    }

    // Specify time limit for test execution:
    @Test(timeout = 1000)
    public void testCase21() {
        System.out.println("This test will timeout after 1s");
    }

    // Ignore tests
    @Ignore
    @Test
    public void testCase22() {
        System.out.println("This test will be ignored");
    }
}
