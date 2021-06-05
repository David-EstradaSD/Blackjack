package com.skilldistillery.blackjack.app;

import java.util.Scanner;
import com.skilldistillery.blackjack.common.Deck;

public class BlackjackApp {

	static BlackjackApp app = new BlackjackApp();
	PlayerHand playerHand = new PlayerHand();
	DealerHand dealerHand = new DealerHand();
	Player player = new Player();
	Dealer dealer = new Dealer();

	public static void main(String[] args) {
		app.deal();
	}

	private void deal() {
		boolean keepPlaying = true;
//		boolean hitsCard = true;
		int blackjack = 21;
		app.displayWelcomeMenu();
		dealer.dealerStartingHand();
		player.playerStartingHand();

		while (keepPlaying) {
			
			player.playersAction();
			dealer.dealersAction();
			
			keepPlaying = false;

		}
	}

	private void displayWelcomeMenu() {
		char spade = '\u2660';
		char heart = '\u2665';
		char club = '\u2663';
		char diamond = '\u2666';
		System.out.println(" _______________________________________________");
		System.out.println("|" + spade + heart + diamond + club + " Welcome to David's Virtual Blackjack! " + spade
				+ heart + diamond + club + "|");
		System.out.println("|-----------------------------------------------|");
		System.out.println("| Its the player (you) vs. the dealer (machine) |");
		System.out.println("|  Good luck and may the odds be in your favor! |");
		System.out.println("|  " + spade + " " + heart + " " + diamond + " " + club + " Tips are much appreciated "
				+ spade + " " + heart + " " + diamond + " " + club + "\t|");
		System.out.println("|_______________________________________________|\n");
	}

//	private void dealerStartingHand() {
//
//		int dealerCards = 2;
//		for (int i = 0; i < dealerCards; i++) {
//			deck.shuffle();
//			dealerHand.addCard(deck.dealCard());
//		}
//		System.out.println("Dealer starting hand: ");
//		dealerHand.displayHand();
//		System.out.println();
//		System.out.println("Current dealer hand: " + dealerHand.getHandValue());
//		System.out.println();
//		if (dealerHand.getHandValue() == 21) {
//			System.out.println("\nHoly guacamole! Dealer got Blackjack. Better luck next time.");
//			app.displayDealerWinner();
//			System.exit(0);
//		}
//
//	}
	
//	private void playerStartingHand() {
//		int playerCards = 2;
//		for (int i = 0; i < playerCards; i++) {
//			deck.shuffle();
//			playerHand.addCard(deck.dealCard());
//		}
//		System.out.println("Your starting hand: ");
//		playerHand.displayHand();
//		System.out.println();
//		System.out.println("Your current hand: " + playerHand.getHandValue());
//		if (playerHand.getHandValue() == 21) {
//			System.out.println("\nWhoo-hoo! You got Blackjack off rip! Nice hand!");
//			app.displayPlayerWinner();
//			System.exit(0);
//		}
//	}
	
//	private void playerHits() {
//		playerHand.addCard(deck.dealCard());
//		System.out.println("Your current hand: " + playerHand.getHandValue());
//	}
//	
//	private void dealerHits() {
//		dealerHand.addCard(deck.dealCard());
//		System.out.println("Current dealer hand: " + dealerHand.getHandValue());
//	}
//	
//	private void displayDealerWinner() {
//		System.out.println("\nDealer wins.\n");
//	}
//
//	private void displayPlayerWinner() {
//		System.out.println("\nPlayer wins.\n");
//	}
}
