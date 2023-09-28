package cardsTest;

import cards.AttributeType;
import org.junit.Test;

import static cards.AttributeType.*;
import static org.junit.Assert.assertEquals;

public class AttributeTypeTest {
    @Test
    public void  getFromStringTestMixedCase(){
        //Test if mixed case words are interpreted correctly
        String testMixedCase = "infLicTinG";
        assertEquals(getFromString("INFLICTING"), testMixedCase);

    }
}
