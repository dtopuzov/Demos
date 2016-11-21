package tests.demo_06_sikuli;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import org.sikuli.script.*;

public class NotepadTests {

    @BeforeClass()
    public static void setUp() throws IOException {
        Runtime.getRuntime().exec("notepad");
    }

    @Test()
    public void HelloWorld() throws FindFailed {
        Screen s = new Screen();
        ImagePath.setBundlePath("src/test/java/tests/demo_06_sikuli/NotepadUI/");
        s.wait("navigation_bar.png"); // Wait notepad to load
        s.type("This is writen by Sikuli!"); // Type text
        s.type("s", KeyModifier.CTRL); // Send Ctrl+S to save file
        s.wait("save_as.png");
        s.type("sikuli.txt");
        s.type(Key.ENTER);
    }

    @AfterClass()
    public static void tearDown() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM notepad.exe");
    }
}
