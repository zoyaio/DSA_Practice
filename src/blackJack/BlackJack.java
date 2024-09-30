package blackJack;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack
{

//	public Player player;
	private ArrayList<Player> players = new ArrayList<Player>();

	public Dealer dealer;


	public BlackJack()
	{
		players.add(new Dealer());
	}
	public BlackJack(int numPlayers)
	{
		players.add(new Dealer());
		for (int i = 0; i < numPlayers; i++) {
			players.add(new Player());
		}
	}
	private void init(Player p, Dealer dealer) {
		p.resetHand();
		p.addCardToHand(dealer.deal());
		p.addCardToHand(dealer.deal());
	}

	public void playGame() {
		Dealer dealer = (Dealer) players.get(0);
		dealer.initializeDeck();
		dealer.shuffle();
		Player player;
		//init
		for (int p = 1; p < players.size(); p++) {
			player = players.get(p);
			init(player, dealer);
		}
		init(players.get(0), dealer);

		Scanner keyboard = new Scanner(System.in);
		char choice = 0;

		//player
		for (int p = 1; p < players.size(); p++) {
			player = players.get(p);
			System.out.println("PLAYER #" + p);
			System.out.println(player);

			while(player.getHandValue() < 21) {
				System.out.print("Would you like to hit? [Y/N]: ");
				choice = keyboard.next().charAt(0);
				if (choice == 'N') {
					break;
				}
				player.addCardToHand(dealer.deal());
				System.out.println("\nPLAYER\n" + player.toString());
			}
		}

		// dealer
		System.out.println("\nDEALER\n" + dealer.toString());
		boolean result = true; // true if dealer has not busted yet
		while(result) {
			System.out.print("Would you like to hit? [Y/N]: ");
			choice = keyboard.next().charAt(0);
			if (choice == 'N') {
				break;
			}
			result = dealer.hit();
			System.out.println("\nDEALER\n" + dealer.toString());
		}

		int maxScore = 0;
		int ind = -1;
		int playerScore = 0;
		for (int p = 0; p < players.size(); p++) {

			playerScore = players.get(p).getHandValue();

			if (playerScore <= 21 && playerScore > maxScore) {
				maxScore = playerScore;
				ind = p;
			}
		}
		if (ind >=0) {
			players.get(ind).incrementWins();
			System.out.println("Player " + ind + " won!"); // Player 0 = dealer
		}
		else {
			System.out.println("No one won!");
		}


	}

//	public void playGameOld()
//	{
//		player.resetHand();
//		dealer.resetHand();
//		dealer.shuffle();
//
//		player.addCardToHand(dealer.deal());
//		player.addCardToHand(dealer.deal());
//
//		dealer.addCardToHand(dealer.deal());
//		dealer.addCardToHand(dealer.deal());
//
//		System.out.println("PLAYER");
//		System.out.println(player);
//
//		Scanner keyboard = new Scanner(System.in);
//		char choice = 0;
//		while(player.getHandValue() < 21) {
//			System.out.print("Would you like to hit? [Y/N]: ");
//			choice = keyboard.next().charAt(0);
//			if (choice == 'N') {
//				break;
//			}
//			player.addCardToHand(dealer.deal());
//			System.out.println("\nPLAYER\n" + player.toString());
//		}
//		System.out.println("\nDEALER\n" + dealer.toString());
//		boolean result = true; // true if dealer has not busted yet
//		while(result) {
//			System.out.print("Would you like to hit? [Y/N]: ");
//			choice = keyboard.next().charAt(0);
//			if (choice == 'N') {
//				break;
//			}
//			result = dealer.hit();
//			System.out.println("\nDEALER\n" + dealer.toString());
//		}
//		int playerHand = player.getHandValue();
//		int dealerHand = dealer.getHandValue();
//		if (playerHand > 21 && dealerHand < 21) {
//			System.out.println("Player loses!");
//			dealer.incrementWins();
//		}
//		if (dealerHand > 21 && playerHand < 21) {
//			System.out.println("Dealer loses!");
//			player.incrementWins();
//		}
//		else {
//			if (playerHand > dealerHand) {
//				System.out.println("Player wins!");
//				player.incrementWins();
//			}
//			if (dealerHand > playerHand) {
//				System.out.println("Dealer wins!");
//				dealer.incrementWins();
//			} else {
//				System.out.println("Tie!");
//				dealer.incrementWins();
//				player.incrementWins();
//			}
//		}
//
//	}
	
	public static void main(String[] args)
	{
		BlackJack game = new BlackJack(2);
		boolean newGame = false;
		Scanner keyboard2 = new Scanner(System.in);
		do {
			game.playGame();
			System.out.print("New game? [Y|N]: ");
			newGame = keyboard2.next().charAt(0) != 'N';
		} while(newGame);



	}
}