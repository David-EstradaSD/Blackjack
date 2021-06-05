package com.skilldistillery.blackjack.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	private List<Card> cards = new ArrayList<>();
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public int getHandValue() {
		int value = 0;
		for (Card card : cards) {
			value += card.getValue();

		}
		return value;
	}
	
	public void foldHand() {
		cards.clear(); 			// this method clears a List of its elements (cards)
	}
	
	public void displayHand() {
		if (cards.size() == 0) {
			System.out.print("No cards."); 
		} 
		else {
			for (Card card : cards) {
				System.out.print(card);
				System.out.print(" ");
			}
		}
	}

}