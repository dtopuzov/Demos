package tests.demo_02_testng_hello_world;

import org.testng.annotations.Test;

public class SmoteTests2 extends BaseTest {

    // Test 21 has higher priority, but it depends on Test 22, so 22 will be executed first

    @Test(
            description = "This test will test something...",
            enabled = true,
            groups = {"android", "ios"},
            priority = 15,
            timeOut = 1000,
            dependsOnMethods = "test22"
    )
    public void test21() {
        System.out.println("Test21 is running...");
    }

    @Test(groups = {"ios"}, priority = 30)
    public void test22() {
        System.out.println("Test22 is running...");
    }
}
