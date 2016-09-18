package tests.demo_00_junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({JunitTest1.class, JunitTest2.class})
public class JunitSuite {

    @BeforeClass
    public static void runBeforeClass() {
        System.out.println("JunitSuite Suite @BeforeClass");
    }

    @AfterClass
    public static void runAfterClass() {
        System.out.println("JunitSuite Suite @AfterClass");
    }
}
