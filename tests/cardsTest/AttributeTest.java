package cardsTest;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import cards.*;
import utility.Util;

public class AttributeTest {
    private Card activator;
    private Card target;

    @Before
    public void setUp() {
        Attribute[] attributesActivator = new Attribute[0];
        Attribute[] attributesTarget = new Attribute[0];

        activator = new Card("Activator", "Activator description", 5, attributesActivator);
        target = new Card("Target", "Target description", 4, attributesTarget);
        activator.setResiliance(5);
        target.setResiliance(3);
    }

    @Test
    public void testActivateInflictingAttribute() {
        // Create an inflicting attribute with a value of 3
        Attribute inflictingAttribute = new Attribute("Inflict", "Inflict description", 3, 1, false, 0, AttributeType.INFLICTING);

        // Activate the inflicting attribute
        inflictingAttribute.activate(activator, target);

        // Check if the target's resiliance is reduced and power is increased
        assertEquals(0, target.getResiliance());
        assertEquals(13, target.getPower());
    }

    @Test
    public void testActivateBuffAttribute() {
        // Create a buff attribute with a value of 2
        Attribute buffAttribute = new Attribute("Buff", "Buff description", 2, 1, false, 0, AttributeType.BUFF);

        // Activate the buff attribute
        buffAttribute.activate(activator, target);

        // Check if the target's power is increased
        assertEquals(8, target.getResiliance());
        assertEquals(10, target.getPower());
    }

    @Test
    public void testActivateResilianceAttribute() {
        // Create a resiliance attribute with a value of 4
        Attribute resilianceAttribute = new Attribute("Resiliance", "Resiliance description", 4, 1, false, 0, AttributeType.RESILIANCE);

        // Activate the resiliance attribute
        resilianceAttribute.activate(activator, target);

        // Check if the target's resiliance is increased
        assertEquals(7, target.getResiliance());
        assertEquals(8, target.getPower());
    }

    @Test(expected = IllegalStateException.class)
    public void testActivateInvalidAttributeType() {
        // Create an invalid attribute type
        Attribute invalidAttribute = new Attribute("Invalid", "Invalid description", 1, 1, false, 0, AttributeType.BUFF);

        // This should throw an IllegalStateException
        invalidAttribute.activate(activator, target);
    }
}
