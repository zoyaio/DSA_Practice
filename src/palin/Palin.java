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

    public String getWord() {
        return word;
    }

    //isPalin method - returns a boolean

    public boolean isPalin() {

        int len = this.getLength();
        if (len > 1) {
            int halfpt = (int) Math.floor(len / 2.0);


            StringBuffer half1 = new StringBuffer(word.substring(0, halfpt));
            if (len % 2 == 1) {
                halfpt++;
            }
            StringBuffer half2 = new StringBuffer(word.substring(halfpt));
            return half1.toString().equals(half2.reverse().toString());
        }
        return false;
    }

    //toString method - returns a String

    public String toString() {
        return this.getWord();
    }
}