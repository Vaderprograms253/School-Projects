/*
*
* Xavier Denson
* IT 220
* Coin class
* Coin.java
*
 */
import java.util.Random;

public class Coin implements Comparable<Coin> {

    private boolean orientation; //false
    private double value; //0.0
    private String type; //null
    private String headsDescription;
    private String tailsDescription;

    // there is no default constructor NOW- zero parameters
    // since we put a 5-parameter constructor in the clas

    // This class will only have one parameterized constructor
    public Coin(boolean orientation, double value, String type, String headsDescription, String tailsDescription) {
        this.orientation = orientation;
        this.value = value;
        this.type = type;
        this.headsDescription = headsDescription;
        this.tailsDescription = tailsDescription;
    }

    public boolean getOrientation() {
        return orientation;
    }

    public double getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getHeadsDescription() {
        return headsDescription;
    }

    public String getTailsDescription() {
        return tailsDescription;
    }

    public void flip(){
        this.orientation = new Random().nextBoolean();
    }

    @Override
    public String toString(){
        // if orientation == true
        //String toReturn = ""; // empty string
        if(orientation){
            return "Heads is displayed, you see " + headsDescription +
                    " on the " + type;
        } else {
            return "Tails is displayed, you see " + tailsDescription +
                    " on the " + type;
        }
    }

    @Override
    public int compareTo(Coin other){
        // quarter.compareTo(penny) - returning 1
        if(this.value > other.value)
            return 1;

        // penny.compareTo(quarter) - returning -1
        if(this.value < other.value)
            return -1;


        return 0;
    }

    public static void main(String[] args) {
        Coin penny = new Coin(true,0.01,"Penny",
                "Abraham Lincoln's head", "Lincoln Memorial");
        Coin quarter = new Coin(false,0.25,"Quarter",
                "George Washington","American Eagle");
        // TODO: construct a nickel and a dime
        Coin dime = new Coin(true,0.10,"Dime", "Roosevelt","Torch");
        Coin nickle = new Coin(true,0.05,"Nickel","Jefferson","Monticello");

        // TODO: compareTo test for nickel and dime

        System.out.println("Expected < 0: "+ penny.compareTo(quarter));
        System.out.println("Expected > 0: "+ quarter.compareTo(penny));
        System.out.println("Expected == 0: "+ quarter.compareTo(quarter));
        System.out.println(dime.compareTo(quarter));
        System.out.println(dime.compareTo(nickle));
        System.out.println(dime.compareTo(penny));
        System.out.println(nickle.compareTo(dime));
        System.out.println(nickle.compareTo(penny));

        // Testing the flip
        penny.flip();
        // call toString
        System.out.println(penny);


        // TODO: test the flip on the nickel, dime, and quarter
        nickle.flip();
        dime.flip();
        System.out.println("Dime result: " + dime + "\nNickel result: " + nickle);
    }
}
