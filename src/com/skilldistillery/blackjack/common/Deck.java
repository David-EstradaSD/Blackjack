package com.skilldistillery.blackjack.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> deckOfCards;

	public Deck() {
		deckOfCards = new ArrayList<>(52); 		// (1) we set our ArrayList to 52 cards
		for (Rank r : Rank.values()) { 			// we use our .values method to establish arrays for Suit and Rank
			for (Suit s : Suit.values()) {
				deckOfCards.add(new Card(r, s)); // add a new Card(Rank, Suit) of type rank r and suit s to our ArrayList (deckOfCards)
			}									// Alas, our ArrayList deckOfCards has all 52 cards
		}		
	}
	
	public int checkDeckSize() {	
		if (deckOfCards == null) {
			return -1;					// this avoids a null pointer exception
		}
		return deckOfCards.size();
		
	}
	
	public Card dealCard() {				// we just use our deckOfCards to call its remove() method
		return deckOfCards.remove(0);		// we return the size of the deck which is object Card
	}
	
	public void shuffle() {					
		Collections.shuffle(deckOfCards);	
	}
}
