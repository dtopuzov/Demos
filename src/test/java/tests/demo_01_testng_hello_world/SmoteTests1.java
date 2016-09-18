package tests.demo_01_testng_hello_world;

import org.testng.annotations.Test;

public class SmoteTests1 extends BaseTest {

    // test12 has higher priority and will be executed before test11

    @Test(groups = {"android", "ios"}, priority = 20)
    public void test11() {
        System.out.println("Test11 is running...");
    }

    @Test(groups = {"android"}, priority = 10)
    public void test12() {
        System.out.println("Test12 is running...");
    }
}
