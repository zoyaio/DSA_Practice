package blackJack;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -
import java.util.ArrayList;
import java.util.Collections;

public class Dealer extends Player
{
	//define a deck of cards
	private ArrayList<Card> deck;

	public Dealer() {
		super();
		deck = new ArrayList<>();
		initializeDeck();
		shuffle();
	}

	public void initializeDeck() {
		String[] suits = Card.SUITS;
		deck = new ArrayList<>();
		for (int suitNum= 0; suitNum < 4; suitNum++) {
			for (int face = 1; face < Card.FACES.length; face ++) {
				deck.add(new BlackJackCard(face, suits[suitNum]));
			}
		}
	}

	public void  shuffle()
	{
		Collections.shuffle(deck);
	}

	public Card deal(){
		if (deck.isEmpty()) {
			return null;  // No cards left to deal
		}
		return deck.remove(deck.size() - 1);
	}

	public int numCardsLeftInDeck()
	{
		return deck.size();
	}

	public boolean hit()
	{
		boolean ret = getHandValue() < 17;
		if (ret) {
			this.addCardToHand(this.deal());
		}
		return ret;
	}

	public String toString() {
		return super.toString() + " | Cards left in deck: " + numCardsLeftInDeck();
	}
}








