package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.common.Deck;

public class Dealer {

	private Deck deck = new Deck();
	DealerHand dealerHand = new DealerHand();
	private int blackjack = 21;
	private int hitValue = 17;

	public void dealersAction(Player player) {		// rather than instantiating a new Player
		boolean dealersTurn = true;					// we can reference the same player object throughout all classes
		while (dealersTurn) {
			if (dealerHand.getHandValue() <= hitValue) {
				dealerHits();
				if (dealerHand.getHandValue() > blackjack) {
					System.out.println("Dealer busts!");
					player.displayPlayerWinner();
					dealersTurn = false;
				}
				if (player.playerHand.getHandValue() == dealerHand.getHandValue()) {
					dealerPlayerTied();
					dealersTurn = false;
				}
			} else if (dealerHand.getHandValue() > hitValue && dealerHand.getHandValue() <= blackjack) {
				if (dealerHand.getHandValue() > player.playerHand.getHandValue()) {
					displayDealerWinner();
					dealersTurn = false;
				} else if (player.playerHand.getHandValue() == dealerHand.getHandValue()) {
					dealerPlayerTied();
					dealersTurn = false;
				} else if (dealerHand.getHandValue() < player.playerHand.getHandValue()){
					player.displayPlayerWinner();
					dealersTurn = false;
				}
			}
		}
	}

	public void dealerStartingHand(Player player) {

		int dealerCards = 2;
		for (int i = 0; i < dealerCards; i++) {
			deck.shuffle();
			dealerHand.addCard(deck.dealCard());
		}
		System.out.println("Dealer starting hand: ");
		dealerHand.displayHand();
		System.out.println("\nCurrent dealer hand: " + dealerHand.getHandValue() + "\n");
	}

	public void dealerHits() {
		System.out.println("Dealer hits!");
		dealerHand.addCard(deck.dealCard());
		dealerHand.displayHand();
		System.out.println();
		System.out.println("Current dealer hand: " + dealerHand.getHandValue());
	}

	public void displayDealerWinner() {
		System.out.println("\nDealer wins.\n");
	}

	public void dealerPlayerTied() {
		System.out.println("\nOh wow! We pushed!");
		System.out.println("It's a tie: No winner.\n");
	}
}
