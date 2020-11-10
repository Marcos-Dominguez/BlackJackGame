package com.cognixia.jump.blackjackgame;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

	private String nickName;

	private int playerNumOfCards;
	ArrayList<Card> playerHand;

	public Player(String name) {
		this.nickName = name;
		playerHand = new ArrayList<Card>();

	}

	public String getNickName() {
		return nickName;

	}

	public void addCard(Card aCard) {
		playerHand.add(aCard);
		this.playerNumOfCards++;

	}

	public int getHandSum() {
		int totalSum = 0;
		Scanner scanner = new Scanner(System.in);

		for (Card countSum : playerHand) {
			if (countSum.getFace() != 1) {
				totalSum = totalSum + countSum.getFace();
			}
		}

		return totalSum;

	}

	public void getPlayerHand(boolean hideCard) {
		System.out.println(this.nickName + "'s current hand.");
		for (int hand = 0; hand < playerNumOfCards; hand++) {

			if (hand == 0 && !hideCard) {
				System.out.println("[Hidden card]");

			} else {
				System.out.println(playerHand.get(hand).toString());
			}
		}
	}
}