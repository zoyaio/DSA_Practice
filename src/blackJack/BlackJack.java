package blackJack;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.Scanner;

public class BlackJack
{
	//add in Player instance variable
	public Player player;
	//add in Dealer instance variable
	public Dealer dealer;

	public BlackJack()
	{
		player = new Player();
		dealer = new Dealer();
	}



	public void playGame()
	{
		player.resetHand();
		dealer.resetHand();
		dealer.shuffle();

		player.addCardToHand(dealer.deal());
		player.addCardToHand(dealer.deal());

		dealer.addCardToHand(dealer.deal());
		dealer.addCardToHand(dealer.deal());

		System.out.println("PLAYER");
		System.out.println(player);

		Scanner keyboard = new Scanner(System.in);
		char choice = 0;
		while(player.getHandValue() < 21) {
			System.out.print("Would you like to hit? [Y/N]: ");
			choice = keyboard.next().charAt(0);
			if (choice == 'N') {
				break;
			}
			player.addCardToHand(dealer.deal());
			System.out.println("\nPLAYER\n" + player.toString());
		}
		System.out.println("\nDEALER\n" + dealer.toString());
		boolean result = true; // true if dealer has not busted yet
		while(result) {
			System.out.print("Would you like to hit? [Y/N]: ");
			choice = keyboard.next().charAt(0);
			if (choice == 'N') {
				break;
			}
			result = dealer.hit();
			System.out.println("\nDEALER\n" + player.toString());
		}
		int playerHand = player.getHandValue();
		int dealerHand = dealer.getHandValue();
		if (playerHand > 21 && dealerHand < 21) {
			System.out.println("Player loses!");
			dealer.incrementWins();
		}
		if (dealerHand > 21 && playerHand < 21) {
			System.out.println("Dealer loses!");
			player.incrementWins();
		}
		else {
			if (playerHand > dealerHand) {
				System.out.println("Player wins!");
				player.incrementWins();
			}
			if (dealerHand > playerHand) {
				System.out.println("Dealer wins!");
				dealer.incrementWins();
			} else {
				System.out.println("Tie!");
				dealer.incrementWins();
				player.incrementWins();
			}
		}

	}
	
	public static void main(String[] args)
	{
		BlackJack game = new BlackJack();
		boolean newGame = false;
		Scanner keyboard2 = new Scanner(System.in);
		do {
			game.playGame();
			System.out.print("New game? [Y|N]: ");
			newGame = keyboard2.next().charAt(0) != 'N';
		} while(newGame);



	}
}