package blackJack;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import static java.lang.System.out;

public class DeckTestOne
{
	public static void main( String args[] )
	{
		Deck deck = new Deck();	
		for( int i=0; i<Deck.NUMCARDS; i++ ) {
		  out.println(deck.nextCard());
		}
		
		out.println("\n\n");
		
		out.println("num cards left in the deck == " + deck.numCardsLeft());
		
		out.println("\n\nshuffling");
		deck.shuffle();
		out.println("num cards left in the deck == " + deck.numCardsLeft());
		
		
		out.println("\n\ntoString");
		out.println(deck);							
	}
}