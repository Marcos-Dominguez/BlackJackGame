package com.cognixia.jump.blackjackgame;

public class Card {

	private Face face;// face of card, i.e "king & queen"

	private Suit suit; // Suit of card, i.e "Spades & Hearts";

	int total = 0;

	// constructor which initializes suits and faces of cards
	public Card(Face cardFace, Suit cardSuit) {

		this.face = cardFace;
		this.suit = cardSuit;

	}

	/**
	 * @return the face
	 */
	public int getFace() {
		return face.getFaceValue();
	}

	/**
	 * @return the suit
	 */
	public String getSuit() {
		return suit.PrintSuitText();
	}

	public String toString() {
		return face + " of " + suit;
	}

}