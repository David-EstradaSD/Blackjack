package com.skilldistillery.blackjack.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.app.PlayerHand;
import com.skilldistillery.blackjack.common.Card;
import com.skilldistillery.blackjack.common.Deck;

public class DealingApp {
	
	Deck deck = new Deck();		
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		DealingApp app = new DealingApp();
		app.deal();

	}

	private void deal() {
		int numCards;
		System.out.print("How many cards would you like? ");
		
		try {
			numCards = sc.nextInt();
			if (numCards > 52) {
				throw new RuntimeException("Too many cards requested"); 
			}
			PlayerHand hand = new PlayerHand();
			for (int i = 0; i < numCards; i++) {
				deck.shuffle();
				hand.addCard(deck.dealCard());
			}
			hand.displayHand();
		
			System.out.println("Hand value: " + hand.getHandValue());
												
	
		} catch (InputMismatchException e) {
			System.err.println("Input invalid: enter a valid hand size (ONLY 52 CARD DECK)");
		}
		

		sc.close();
	}
}



