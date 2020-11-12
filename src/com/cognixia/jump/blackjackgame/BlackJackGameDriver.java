package com.cognixia.jump.blackjackgame;

import java.util.Scanner;

public class BlackJackGameDriver {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean stay = false;

		System.out.println("What would you like to be called? ");
		String answer = scanner.nextLine();
		Player me = new Player(answer);
		Player dealer = new Player("Dealer");

		System.out.println("Would you like to start a new game? 'Yes/No' :");
		answer = scanner.nextLine();

		if (answer.equalsIgnoreCase("Yes")) {

			DeckOfCards deck1 = new DeckOfCards();
			Card card1 = new Card(Face.JACK, Suit.SPADES);
			deck1.shuffleDeck();

			// Player

			me.addCard(deck1.dealNextCard());
			me.addCard(deck1.dealNextCard());

			me.getPlayerHand(true);
			System.out.println(" ");

			// Dealer

			dealer.addCard(deck1.dealNextCard());
			dealer.addCard(deck1.dealNextCard());
			dealer.getPlayerHand(false);

			// Player
			do {
				System.out.println("Would " + me.getNickName() + " like to Hit or Stay? 'Hit / Stay'");
				answer = scanner.nextLine();

				// Hit

				if (answer.equalsIgnoreCase("Hit")) {
					me.addCard(deck1.dealNextCard());
					System.out.println(me.getHandSum());

					if (me.getHandSum() == 21) {
						System.out.println("Black Jack!  With a hand of " + me.getHandSum());
						System.exit(0);
					}

					if (me.getHandSum() > 21) {
						System.out.println(
								"You busted and got a Total of " + me.getHandSum() + ". Dealer wins this hand!");
						System.exit(0);
					}
				}

				// Stay
				if (answer.equalsIgnoreCase("stay")) {
					System.out.println("You have chosen to stay. Your hand: " + me.getHandSum());
				}

			} while (answer.equalsIgnoreCase("Hit"));

			// Dealer

			stay = false;

			do {
				System.out.println("");

				System.out.println(" - Dealers turn - ");

				// Dealer Draws card;

				if (dealer.getHandSum() <= 16) {

					int totalPlayerHand = me.getHandSum();

					dealer.addCard(deck1.dealNextCard());

					System.out.println("Dealer hand is: " + dealer.getHandSum());

					if (dealer.getHandSum() == 21) {
						System.out.println("Black Jack! Dealer wins. With a hand of " + dealer.getHandSum());
						System.exit(0);
					}

					if (dealer.getHandSum() > 21) {
						System.out.println("Dealer busted and got a total of " + dealer.getHandSum() + ". "
								+ me.getNickName() + " is the Winner, with a total of " + totalPlayerHand + ".");
						System.exit(0);
					}
				} else {

					System.out.println("Dealer has chosen to stay!");

					int totalDealerHand = dealer.getHandSum();
					int totalPlayerHand = me.getHandSum();

					if (totalDealerHand > totalPlayerHand) {
						System.out.println("Both players have decided to stay. The Winner is " + dealer.getNickName()
								+ " with a total of " + totalDealerHand + ".");

					} else if (totalDealerHand == totalPlayerHand) {
						System.out.println(totalDealerHand);
						System.out.println("Push, Try again");
						System.exit(0);

					} else {

						System.out.println("Both players have decided to stay. The Winner is " + me.getNickName()
								+ " with a total of " + totalPlayerHand + ".");
					}

					stay = true;

				}

			} while (!stay);

		}
		scanner.close();
	}

}
