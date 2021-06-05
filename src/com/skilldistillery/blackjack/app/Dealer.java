package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.common.Deck;

public class Dealer {

	private Deck deck = new Deck();
	private Scanner sc = new Scanner(System.in);
	static BlackjackApp app = new BlackjackApp();
	DealerHand dealerHand = new DealerHand();
	private int blackjack = 21;

//	private int dealerStartingHandValue() {
//	int ripValue = dealerHand.getHandValue();
//	if (ripValue == 21) {
//		System.out.println("Holy guacamole! Dealer got Blackjack. Better luck next time.");
//		app.displayDealerWinner();
//	}
//	return ripValue;
//}

	public void dealersAction() {
		Player player = new Player();
		boolean keepHitting = true;
		if (player.playerHand.getHandValue() <= blackjack) {
			while (keepHitting) {
				if (dealerHand.getHandValue() <= 17) {
					dealerHits();
					if (dealerHand.getHandValue() > blackjack) {
						System.out.println("Dealer busts!");
						player.displayPlayerWinner();
						keepHitting = false;
					}
					if (player.playerHand.getHandValue() == dealerHand.getHandValue()) {
						dealerPlayerTied();
						keepHitting = false;
					}
//					if (dealerHand.getHandValue() < blackjack &&
//							dealerHand.getHandValue() > player.playerHand.getHandValue()) {
//						displayDealerWinner();
//					}
					if (dealerHand.getHandValue() == blackjack) {
						displayDealerWinner();
						keepHitting = false;
					}
				}
			}
		}
	}

	public void dealerStartingHand() {

		int dealerCards = 2;
		for (int i = 0; i < dealerCards; i++) {
			deck.shuffle();
			dealerHand.addCard(deck.dealCard());
		}
		System.out.println("Dealer starting hand: ");
		dealerHand.displayHand();
		System.out.println();
		System.out.println("Current dealer hand: " + dealerHand.getHandValue());
		System.out.println();
		if (dealerHand.getHandValue() == 21) {
			System.out.println("\nHoly guacamole! Dealer got Blackjack. Better luck next time.");
			displayDealerWinner();
			System.exit(0);
		}

	}

	public void dealerHits() {
		System.out.println("Dealer hits!");
		dealerHand.addCard(deck.dealCard());
		System.out.println("Current dealer hand: " + dealerHand.getHandValue());
	}

	public void displayDealerWinner() {
		System.out.println("\nDealer wins.\n");
	}
	
	public void dealerPlayerTied() {
		System.out.println("Oh wow! We pushed!");
	}
}
