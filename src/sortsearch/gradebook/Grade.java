package sortsearch.gradebook;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

//create the Grade class here


public class Grade
{
    private double value;
    public Grade( double v )
    {
        value = v;
    }

    public double getNumericGrade()
    {
        return value;
    }

    public String getLetterGrade()
    {
        if (value >= 90) {return "A";}
        if (value >= 80) {return "B";}
        if (value >= 70) {return "C";}
        if (value >= 60) {return "D";}
        else{
            return "F";
        }

    }
    public String toString()
    {
        return String.format("%.2f %s", getNumericGrade(), getLetterGrade());
    }
}