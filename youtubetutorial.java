import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

public class youtubetutorial {
    public static void main(String[] String.format(args){
    //writing our first code
    System.out.println( "Hello world");
    System.out.println("Learning java");
    byte myAge= 30;
    byte herAge = myAge;
    int views = 123_345_4000;
    long viewsSeen = 3_123_345_4000L;
    float price = 10.99F;
    char letter ='Q';
    boolean isMature = true;
    System.out.println(herAge);
    System.out.println(views);
    System.out.println(viewsSeen);
    System.out.println(price);
    System.out.println(letter);
    Scanner; //this is a scanner package, adds a package that is imported at the top to use the scanner
    Date; //another package
    Date now = new Date(); // creates a new date object containing the current date and time
    //sout + TAB key gives System.out.println();
    String message = "HELLO";
    System.out.println(message); //returns the message value
    System.out.println(message.endsWith("o")); // returns a boolean value; true or false as output, depending on the logic
    message.startsWith();
    message.length(); // returns number of characters in the value of the message variable
    message.indexOf();// returns the index of a certain letter or character or words in that value (starts from 0++)
    message.replace(" ", " "); // replace certain content with new one, to return a new output
    message.toLowerCase(); //converts all values of the message variable to lowercase
    message.toUpperCase();
    message.trim(); //trims extra spaces in the value 
     System.out.println("c:\\Windows\\...."); //returns c:\Windows\....
     //implicit casting 
     /* where there is aurithmetic logic between different data types,
     however the data types should be related e/g only numbers*/
     //byte> short > int > long >float> double
     short x = 1;
     int y = x + 2;
     System.out.println(y); // returns the result as 3 even when the data types are different
    
    int result = Math.round(1.1F); //rounding off
    System.out.println(result); // returns 1
    
    int result = int()Math.ceil(1.1F); /*returns the smallest integer greater than 1 (ceil);
     normally it returns a double, so we add (int) to return an integer */
    System.out.println(result); //returns 2
    
    int result = int()Math.floor(1.1F); // thr floor of a no. is the largest integer smaller or equal to that number
    System.out.println(result); //returns 1
    
    int result = Math.max(1, 2); // returns thr greater no
    int result = Math.min(1, 2);
    
    double result = Math.random();// returns a random number between 0 to 1
    double result = Math.random() *100; // returns a random number between 0 to 100
    double result = Math.round(Math.random() *100); // rounding it off
    int result = int()(Math.random() *100); // or you can use explicit casting to eliminate the decimal points
    // if you dont include the round method,  it returns a 0. 
    
    
    //FORMATING NUMBERS DISPLAYED AS OUT PUT
    NumberFormat currency =NumberFormat.getCurrencyInstance();
    String result = currency.format(1234567.891);
//OR YOU CAN USE THIS ONE BELOW
    String result = NumberFormat.getCurrencyInstance().format(1234567.891);
System.out.println(result); //returns $1,234,567,89

NumberFormat percent =NumberFormat.getPercentInstance();
String result = percent.format(0.1);
//OR USE THE ONE BELOW
String result = NumberFormat.getPercentInstance().format(result);
System.out.println(result);// returns 10%


Scanner scanner = new Scanner(System.in); //receive input from keyboard
Scanner scanner = new Scanner(System.out); //display output on the console/ termiinal eg System.out.println();




    }
}