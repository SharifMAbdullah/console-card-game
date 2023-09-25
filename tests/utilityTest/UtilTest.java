package utilityTest;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import utility.Util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UtilTest {

    private Util util;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        // Initialize the Util instance or any setup required
        util = new Util();

        // Redirect System.out to capture the output
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testPrintInBoxWithStrings() {
        // Test when providing strings as arguments
        String msg = "Hello, World!";
        util.printInBox(msg);

        String expectedOutput = "||||||||||||||||||||||||||||||\n" +
                "||| Hello, World! |||\n" +
                "||||||||||||||||||||||||||||||\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintInBoxWithNumbers() {
        // Test when providing numbers as arguments
        int num = 42;
        util.printInBox(String.valueOf(num));

        String expectedOutput = "|||||||||||\n" +
                "||| 42 |||\n" +
                "|||||||||||\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintInBoxWithMultipleArguments() {
        // Test when providing multiple arguments
        String msg = "Hello";
        int num = 123;
        util.printInBox(msg, num);

        String expectedOutput = "||||||||||||||||||\n" +
                "||||||||||||||||||\n" +
                "||| Hello |||\n" +
                "||| 123 |||\n" +
                "||||||||||||||||||\n" +
                "||||||||||||||||||\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}
