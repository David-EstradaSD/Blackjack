package com.skilldistillery.blackjack.common;

public enum Suit {
	
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	
	private String name;
	
	 Suit(String suitName) {		
		this.name = suitName;			
	}								
	 
	 @Override
	 public String toString() {
		 return name;
	 }


}
