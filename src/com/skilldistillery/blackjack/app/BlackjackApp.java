package com.skilldistillery.blackjack.app;

import java.util.Scanner;
import com.skilldistillery.blackjack.entity.Deck;

public class BlackjackApp {
	
	private Deck deck = new Deck();
	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.deal();
	}
	
	private void deal() {
		
	}
	
	

}
