package blackJack;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class BlackJackCard extends Card
{
  	//constructors
	public BlackJackCard(int face, String suit) {
		super( suit,face );
	}
	public BlackJackCard( int face) {
		super(face);
	}
	public BlackJackCard() {
		super();
	}

  	public int getValue()
  	{
  		//enables you to build the value for the game into the card
  		//this makes writing the whole program a little easier

		int cardVal = super.getValue();
		if (cardVal >= 2 && cardVal <11) {
			return cardVal;
		}
		if (cardVal > 10 || cardVal ==1 ) {
			return 11;
		}
		return 0;
  	}
  	
 }