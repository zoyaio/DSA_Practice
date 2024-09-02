package palin;
//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

//define class Palin
class Palin {

    //instance variable - String
    private String word;

    //constructors
    public Palin(String text) {
        word = text;
    }

    //getLength method - returns an int
    public int getLength() {
        return word.length();
    }


    //getWord method - returns a String

    public String getString() {
        return word;
    }

    //isPalin method - returns a boolean

    public boolean isPalin() {
        int halfpt = (int) Math.floor(this.getLength()/2.0);


        StringBuffer half1 = new StringBuffer(word.substring(0, halfpt));
        if (this.getLength() % 2 == 1) {
            halfpt ++;
        }
        StringBuffer half2 = new StringBuffer(word.substring(halfpt));
        return half1.toString().equals(half2.reverse().toString());
    }
    //toString method - returns a String

    public String toString() {
        return this.getString();
    }
}