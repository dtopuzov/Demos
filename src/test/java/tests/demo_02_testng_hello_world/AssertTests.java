package tests.demo_02_testng_hello_world;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTests {

    @Test()
    public void test11() {
        // assertEquals(boolean actual, boolean expected)
        Assert.assertEquals(true, true, "Ups, something went wrong!");
        Assert.assertNotEquals("value1", "value2", "Ups, something went wrong!");
        Assert.assertNotNull("this object is not null", "Ups, something went wrong!");
        Assert.assertTrue(2 > 1, "Ups, something went wrong!");
        Assert.assertFalse(2 < 1, "Ups, something went wrong!");
    }
}
