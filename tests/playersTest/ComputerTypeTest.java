package playersTest;

import org.junit.Test;
import players.ComputerType;
import static org.junit.Assert.assertArrayEquals;

public class ComputerTypeTest {

    @Test
    public void testGetTypesAsStrings() {
        String[] types = ComputerType.getTypesAsStrings();

        // Check if the array contains the expected strings
        assertArrayEquals(new String[]{"LOGICAL", "RANDOM", "DUMB", "logical", "random", "dumb"}, types);
    }
}