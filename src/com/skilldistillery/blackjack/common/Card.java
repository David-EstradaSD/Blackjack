package com.skilldistillery.blackjack.common;

public class Card {
	
	private Rank rank;
	private Suit suit;
	
	public Card( Rank rank, Suit suit) {	// (1) make sure to put rank first like 
		this.rank = rank;					// 	we're reading a deck of cards
		this.suit = suit;
	}

	@Override
	public String toString() {			// (3) simple toString
		return rank + " of " + suit;
	}

	public int getValue() {			// (4) we use rank.getValue() bc we know in our rank class
		return rank.getValue();		// 	thats where we assigned numeric values to each rank
	}

	@Override
	public int hashCode() {			// (2) simple source auto generated
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}
	
	

}
