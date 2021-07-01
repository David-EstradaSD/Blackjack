package com.skilldistillery.blackjack.app;

import java.util.Scanner;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		boolean keepPlaying = true;
		int input = 1;

		app.printWelcomeMenu();
		while (keepPlaying) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Would you like to play?");
			System.out.println("Enter 1 to play or 0 to quit");
			input = sc.nextInt();
			sc.nextLine();

			switch (input) {
			case 0:
				System.out.println("Thanks for visiting BestBet Virtual Blackjack!");
				keepPlaying = false;
				break;
			case 1:
				app.play();
				break;
			default:
				System.err.println("Invalid entry. Enter \"1\" or \"0\"");
			}

			sc.close();
		}
	}

	private void play() {
		Player player = new Player();
		Dealer dealer = new Dealer();
		dealer.dealerStartingHand();
		player.playerStartingHand();
//		player.playersAction();
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