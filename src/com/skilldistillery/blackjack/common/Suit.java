package com.skilldistillery.blackjack.common;

public enum Suit {
	
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	
	private String name;
	
	 Suit(String suitName) {		// once we define any constructor, we don't get no arg constructor
		this.name = suitName;			// so we supply the name parameter (suitName) for each of the CONSTANTS.
	}								// just make sure that the CONSTANT is written first and then followed by (suitName)
	 
	 @Override
	 public String toString() {
		 return name;
	 }


}
