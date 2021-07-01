package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.common.Deck;

public class Player {

	private Deck deck = new Deck();
	PlayerHand playerHand = new PlayerHand();
	private int blackjack = 21;
	Dealer dealer = new Dealer();

	public void playersAction() { // we pass the Dealer object to ensure
		Scanner sc = new Scanner(System.in);
		String hitOrStand = ""; // our reference to Dealer is consistent
		boolean playersTurn = true;
		while (playersTurn) {
			System.out.print("Would you like to stand or hit? ");
			hitOrStand = sc.nextLine();
			if (hitOrStand.equalsIgnoreCase("hit")) {
				playerHits();
				if (playerHand.getHandValue() == blackjack) {
					System.out.println("You reached 21, nice.");
					System.out.println("House rules: Dealer surrenders!");
					displayPlayerWinner();
					playersTurn = false;
				}
				if (playerHand.getHandValue() > blackjack) {
					System.out.println("Ah, shucks! You busted over 21.");
					dealer.displayDealerWinner();
					playersTurn = false;
				}
			} else if (hitOrStand.equalsIgnoreCase("stand")) {
				System.out.println("Player stands on: " + playerHand.getHandValue());
				playersTurn = false;
			}
		}
		sc.close();
	}

// add labels and fix this system.exit intentional crash

	public void playerStartingHand() {
		boolean keepPlaying = true;
		int startingHand = 2;
		for (int i = 0; i < startingHand; i++) {
			deck.shuffle();
			playerHand.addCard(deck.dealCard());
		}

		while (keepPlaying) {

			System.out.println("Your starting hand: ");
			playerHand.displayHand();
			System.out.println("\nYour hand value: " + playerHand.getHandValue());

			if (playerHand.getHandValue() == blackjack) {
				System.out.println("\nWhoo-hoo! You got Blackjack off rip! Nice hand!");
			displayPlayerWinner();
				keepPlaying = false;
//			break InstantBlackJack;	

			} else if (playerHand.getHandValue() > blackjack) {
				System.out.println("Player busts from two Aces!");
				dealer.displayDealerWinner();
				keepPlaying = false;
//			break PlayerBusts;

			} else if (dealer.dealerHand.getHandValue() == blackjack) {
				System.out.println("\nHoly guacamole! Dealer got Blackjack. Better luck next time.");
				dealer.displayDealerWinner();
				keepPlaying = false;
//			break DealerBlackJack;

			} else if (dealer.dealerHand.getHandValue() > blackjack) {
				System.out.println("Dealer busts from two Aces!");
				displayPlayerWinner();
				keepPlaying = false;
//			break DealerBusts; 
			} else {
				keepPlaying = false;
				playersAction();
			}
		}

	}

	public void playerHits() {
		playerHand.addCard(deck.dealCard());
		playerHand.displayHand();
		System.out.println("\nYour current hand: " + playerHand.getHandValue());

	}

	public void displayPlayerWinner() {
		System.out.println("\nPlayer wins.\n");
	}
	
	

}
