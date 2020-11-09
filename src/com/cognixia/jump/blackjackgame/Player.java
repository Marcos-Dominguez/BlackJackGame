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
//		int countAce = 0;
		Scanner scanner = new Scanner(System.in);

		for (Card countSum : playerHand) {
			if (countSum.getFace() != 1) {
				totalSum = totalSum + countSum.getFace();
			}
		}
//		if (countAce > 0) {
//			System.out.println(
//					"You have a " + totalSum + " and " + countAce + " Aces. Would you like your Aces to be 1 or 11: ");
//
//			int input = scanner.nextInt();

//			if (input == 11) {
//				System.out.println(totalSum + input);
//			} else {
//				countAce++;
//			System.out.println(totalSum);

//			}
//		}

//		scanner.close();
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