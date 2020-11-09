package com.cognixia.jump.blackjackgame;

public enum Suit {

	HEARTS(" Hearts"), CLUBS("Clubs"), DIAMONDS("Diamonds"), SPADES(" Spades");

	private final String suitText;

	private Suit(String suitText) {
		this.suitText = suitText;

	}

	public String PrintSuitText() {
		return suitText;
	}

}