public class State implements Comparable<State>
{
    /**    The name of the State   */
    private String name;

    /**    The number of Electoral Votes allotted to the State   */
    private int electoralVotes;

    /**    The number of votes cast for Donald Trump   */
    private int trumpVotes;

    /**    The number of votes cast for Hillary Clinton   */
    private int clintonVotes;

    /**    The number of votes cast for candidates other than Donald Trump or Hillary Clinton   */
    private int otherVotes;

    /**
     *  Constructor for the State object
     *
     * @param  n  name of State
     * @param  e  number of electoral votes for the State
     * @param  t  number of Trump votes
     * @param  c  number of Clinton votes
     * @param  oth  number of "other" votes
     */
    public State(String n, int e, int t, int c, int oth)
    {
        name = n;
        electoralVotes = e;
        trumpVotes = t;
        clintonVotes = c;
        otherVotes = oth;
    }

    /**
     *  You will need to write getter methods, and other methods to compare States
     *  according to a variety of attributes.  The comparison methods will be used
     *  in the sorting algorithms.
     */

    /**
     *  Compares the names of the States, returning a negative number if
     *  the calling State is less than the State passed as an argument.  A
     *  positive number is returned if the calling State is greater than
     *  the State passed as an argument.
     *  @param other      The State to be compared
     *  @return           a negative integer, zero, or a positive integer
     *                    as this State is less than, equal to, or greater than the State to be compared
     */
    public int compareTo(State other)
    {
        return this.name.compareTo(other.name);
    }

    public int compareToElectoralVotes(State other){
        Integer thisElectoralVotes = this.electoralVotes;
        Integer otherElectoralVotes = other.electoralVotes;

        return thisElectoralVotes.compareTo(otherElectoralVotes);
    }

    public int compareToClintonPercentage(State other){
        Float thisPercentage = (float)this.clintonVotes/(this.clintonVotes + this.trumpVotes + this.otherVotes);
        Float otherPercentage = (float)other.clintonVotes/(other.clintonVotes + other.trumpVotes + other.otherVotes);

        return thisPercentage.compareTo(otherPercentage);
    }

    public int compareToTrumpPercentage(State other){
        Float thisPercentage = (float)this.trumpVotes/(this.clintonVotes + this.trumpVotes + this.otherVotes);
        Float otherPercentage = (float)other.trumpVotes/(other.clintonVotes + other.trumpVotes + other.otherVotes);

        return thisPercentage.compareTo(otherPercentage);
    }

    public int compareToOtherPercentage(State other){
        Float thisPercentage = (float)this.otherVotes/(this.clintonVotes + this.trumpVotes + this.otherVotes);
        Float otherPercentage = (float)other.otherVotes/(other.clintonVotes + other.trumpVotes + other.otherVotes);

        return thisPercentage.compareTo(otherPercentage);
    }

    /**
     *  Returns all of the information for this State as a String.
     *  @return        The String representing the State
     */
    /*public String toString()
    {
        String winner = new String("CLINTON");
        if(trumpVotes > clintonVotes)
        {
            winner = new String("TRUMP");
        }

        winner = new String("UNKNOWN");     //  This line will need to be removed.

        double total = 100.0 / (trumpVotes + clintonVotes + otherVotes);
        return String.format("%-15s %2d  %6.1f    %6.1f    %4.1f  %-7s",name,electoralVotes,0.0,0.0,0.0,winner);
    }*/

    public String toString(){

        float trumpPercentage = (float)this.trumpVotes/(this.clintonVotes + this.trumpVotes + this.otherVotes)*100;
        float clintonPercentage = (float)this.clintonVotes/(this.clintonVotes + this.trumpVotes + this.otherVotes)*100;
        float otherPercentage = (float)this.otherVotes/(this.clintonVotes + this.trumpVotes + this.otherVotes)*100;

        return String.format("%-15s %2d  %6.1f    %6.1f    %4.1f",name,electoralVotes,trumpPercentage,clintonPercentage,otherPercentage);


    }
}
