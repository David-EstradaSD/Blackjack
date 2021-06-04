package com.skilldistillery.blackjack.common;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
			BlackjackHand hand = new BlackjackHand();
			for (int i = 0; i < numCards; i++) {
				hand.addCard(deck.dealCard());
			}
			int handValue = 0;
			for (int i = 0; i < numCards; i++) {
				deck.shuffle(); 				
				Card card = deck.dealCard();
				handValue += card.getValue(); 	
												
				playerHand.add(card); 			
												
			}
		} catch (InputMismatchException e) {
			System.err.println("Input invalid: enter a valid hand size (ONLY 52 CARD DECK)");
		}
		

		sc.close();
	}
	
		System.out.println("Total hand value: " + value);




}
