package com.skilldistillery.blackjack.app;

public class BlackjackApp {

	static BlackjackApp app = new BlackjackApp();
	Player player = new Player();
	Dealer dealer = new Dealer();

	public static void main(String[] args) {
		app.printWelcomeMenu();
		app.deal();
	}

	private void deal() {
		dealer.dealerStartingHand(player);
		player.playerStartingHand(dealer);
		player.playersAction(dealer);
		dealer.dealersAction(player);
	}

	private void printWelcomeMenu() {
		char spade = '\u2660';
		char heart = '\u2665';
		char club = '\u2663';
		char diamond = '\u2666';
		System.out.println(" _______________________________________________");
		System.out.println("| " + spade + heart + diamond + club + " Welcome to BestBet's Blackjack App! " + spade
				+ heart + diamond + club + " |");
		System.out.println("|-----------------------------------------------|");
		System.out.println("| Its the player (you) vs. the dealer (machine) |");
		System.out.println("|  Good luck and may the odds be in your favor! |");
		System.out.println("|  " + spade + " " + heart + " " + diamond + " " + club + " Tips are much appreciated "
				+ spade + " " + heart + " " + diamond + " " + club + "\t|");
		System.out.println("|_______________________________________________|\n");
	}

}
