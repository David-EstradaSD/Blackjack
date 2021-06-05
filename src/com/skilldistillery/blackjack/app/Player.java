package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.common.Deck;

public class Player {

	private Deck deck = new Deck();
	private Scanner sc = new Scanner(System.in);
	PlayerHand playerHand = new PlayerHand();
	private int blackjack = 21;

//	private int playerStartingHandValue() {
//	int ripValue = playerHand.getHandValue();
//	if (ripValue == 21) {
//		System.out.println("Whoo-hoo! You got Blackjack off rip! Nice hand!");
//		app.displayPlayerWinner();
//	}
//	return ripValue;
//}

	public void playersAction() {
		Dealer dealer = new Dealer();
		String hitOrNot = "";
		boolean keepHitting = true;

		while (keepHitting) {
			if (playerHand.getHandValue() < blackjack) {
				System.out.println("Would you like to stand or hit?");
				hitOrNot = sc.nextLine();
				if (hitOrNot.equalsIgnoreCase("hit")) {
					playerHits();
					if (playerHand.getHandValue() == 21) {
						System.out.println("You reached 21, nice.");
						keepHitting = false;
					}
					
					if (playerHand.getHandValue() > blackjack) {
						System.out.println("Ah, shucks! You busted over 21.");
						dealer.displayDealerWinner();
						System.exit(0);
					}
					
				} else if (hitOrNot.equalsIgnoreCase("stand")) {
					System.out.println("Player stands on: " + playerHand.getHandValue());
					keepHitting = false;
				}

			}
		}
	}

	public void playerStartingHand() {
		int playerCards = 2;
		for (int i = 0; i < playerCards; i++) {
			deck.shuffle();
			playerHand.addCard(deck.dealCard());
		}
		System.out.println("Your starting hand: ");
		playerHand.displayHand();
		System.out.println();
		System.out.println("Your current hand: " + playerHand.getHandValue());
		if (playerHand.getHandValue() == 21) {
			System.out.println("\nWhoo-hoo! You got Blackjack off rip! Nice hand!");
			displayPlayerWinner();
			System.exit(0);
		}

	}

	public void playerHits() {
		playerHand.addCard(deck.dealCard());
		System.out.println("Your current hand: " + playerHand.getHandValue());

	}

	public void displayPlayerWinner() {
		System.out.println("\nPlayer wins.\n");
	}
	
	

}
