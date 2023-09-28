package cardsTest;

import cards.Attribute;
import cards.Card;
import cards.Hand;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class HandTest {
    private Hand hand;
    private Card card1;
    private Card card2;
    private Card removedCard;

    @Before
    public void setUp() {
        // Create a new hand and cards to hand before each test
        hand = new Hand();
        card1 = new Card("Card 1", "Description 1", 5, new Attribute[3]);
        card2 = new Card("Card 2", "Description 2", 4, new Attribute[3]);
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);

        // Remove the first card (index 0) from the hand
        removedCard = hand.removeCardFromHand(0);
    }

    @Test
    public void testRemoveCardFromHand() {
        // Check if the removed card matches the expected card
        assertEquals(card1, removedCard);
    }

    @Test
    public void testRemoveCardFromEmptyHand() {
        // Try to remove a card from an empty hand, should throw an exception
        assertThrows(IllegalStateException.class, () -> {
            hand.removeCardFromHand(0);
        });
    }

    @Test
    public void testRemoveCardFromHandNull() {
        // Check if the number of cards in hand has decreased
        assertEquals(1, hand.getCardsInHand());
    }
}
