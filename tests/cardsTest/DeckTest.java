package cardsTest;

import cards.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeckTest {
    private Deck deck;
    @Before
    public void setUp() {
        deck = new Deck("Test", 3);
        deck.addCard(new Card("Test1", "Just a test. Part of a big test.", -99999,
                        new Attribute[]{
                                new Attribute("In god we trust.", "", 3, 10, false, 0, AttributeType.BUFF),
                                new Attribute("To arms!", "", 10, 1, false, 0, AttributeType.INFLICTING),
                                new Attribute("Tax paying", "", 5, 2, false, 0, AttributeType.RESILIANCE)
                        }
                ).setOwner(deck.getOwner())
        );
        deck.addCard(new Card("Test2", "Just a test2. Part of a big test2.", 1,
                        new Attribute[]{
                                new Attribute("In god we trust.", "", 3, 10, false, 0, AttributeType.BUFF),
                                new Attribute("To arms!", "", 10, 1, false, 0, AttributeType.INFLICTING),
                                new Attribute("Tax paying", "", 5, 2, false, 0, AttributeType.RESILIANCE)
                        }
                ).setOwner(deck.getOwner())
        );
        deck.addCard(new Card("Test3", "Yet another test, how many will be there?.", 1,
                        new Attribute[]{
                                new Attribute("In god we trust.", "", 5, 10, false, 0, AttributeType.BUFF),
                                new Attribute("To arms!", "", 0, 1, false, 0, AttributeType.INFLICTING),
                                new Attribute("Tax paying", "", 1, 2, false, 0, AttributeType.RESILIANCE)
                        }
                ).setOwner(deck.getOwner())
        );
    }
    @Test
    public void testGetCardsLef(){
        deck.removeCard();
        assertEquals(2,deck.getCardsLeft());
    }

    @Test
    public void testLoadPresetDecks(){
        deck = Deck.loadPresetDeck(DeckFaction.ELVES);
        assertNotNull(deck);
        assertEquals(5, deck.getCardsLeft());
        for (Card card : deck) {
            assertEquals(DeckFaction.ELVES, card.getOwner().getFaction());
        }
    }
}
