package blackJack;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class Card
{
	public static final String[] FACES = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};
	public static final String[] SUITS = {"HEART", "CLUBS", "SPADES", "DIAMONDS"};


	private String suit;
	private int face; //index in faces

  	//constructors

	public Card(String suit, int face) {
		this.suit = suit;
		this.face = face;
	}
	public Card(int face) {
		this.suit = "";
		this.face = face;
	}

	public Card() {
		this.suit = "";
		this.face = 0;
	}

	// modifiers

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}


	public void setFace(int face) {
		this.face = face;
	}


	//accessors

  	public int getValue()
  	{
  		return face;
  	}

	public boolean equals(Object obj)
	{
		try {
			Card test = (Card) obj;
			if (test.face == this.face && test.suit == this.suit) { return true;}
		}
		catch(Exception e) {

		}
		return false;
	}

  	//toString

	@Override
	public String toString() {
		return FACES[face] + " of " + getSuit() + " | value = " + getValue();
	}
}