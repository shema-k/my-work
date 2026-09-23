
import java.util.Scanner; //utilities tool that allows us to read input from the user (using the scanner class)
import java.time.Year; //importing the Year class from the java.time package to work with dates and years

public class TEST {
    public static void main(String[] args) {
        System.out.println("========CLASS REGISTER========");
        System.out.println("PLEASE FILL IN THE FOLLOWING DETAILS: ");

        Scanner input = new Scanner(System.in);
        String firstName;
       do { System.out.print("FIRST NAME: ");
         firstName = input.nextLine();
        if (firstName.trim().isEmpty()) {
            System.out.println("You left it blank, Please enter your first name!!");
        }
    } 
    while (firstName.trim().isEmpty());

        String secondName;
        do{System.out.print("SECOND NAME: ");
         secondName = input.nextLine();
         if (secondName.trim().isEmpty()) {
            System.out.println("You left it blank, Please enter your second name!!");
        }
        } while (secondName.trim().isEmpty());


        String fullName;
        Boolean fullNameBoolean;
       do{ 
       System.out.print("IS YOUR FULL NAME " + firstName + " " + secondName + "(yes/no)? ");
        fullName = input.nextLine().trim().toLowerCase(); // to accept all input even when a user mixes casing.(capital and lowercase
        // .trim() removes extra spaces at the start or end
        if (fullName.trim().isEmpty()) {
        System.out.println("You left it blank, Please enter your response!!");
        }
        } while (fullName.trim().isEmpty());

        fullNameBoolean = fullName.equalsIgnoreCase("yes") || fullName.equalsIgnoreCase("y");
    if (fullNameBoolean){
        System.out.print("OKAY,PRESS ENTER TO CONTINUE.... ");
        String enterKey = input.nextLine();
    }


        System.out.println("=====AGE SECTION=====");
        System.out.print("YEAR OF BIRTH : ");
        int yearOfBirth = input.nextInt(); //nextInt() is used to read an integer value from the input ans store it as yearOfBirth
        input.nextLine(); //consume the newline character left by nextInt() to avoid input issues when reading the next line of text

        int currentYear = 2026;
        int age = currentYear - yearOfBirth;
        System.out.print("ARE YOU " + age + " YEARS OLD? ");
        String ageConfirm = input.nextLine();
        
        boolean ageConfirmBoolean = ageConfirm.equalsIgnoreCase("yes") || ageConfirm.equalsIgnoreCase("y");
        if (ageConfirmBoolean){ 
            System.out.println("YOU ARE RIGHT " + firstName + " " + secondName + "!");
        } else {
            System.out.println("PLEASE CHECK WELL " + firstName + " " + secondName + "!");
        }
    /* ageConfirm.equalsIgnoreCase("yes")  allows all inputs of yes/no regardless of case */
     boolean isAdult = ageConfirmBoolean && age >= 18; 
     /*isAdult is true if the user confirms their age and is 18 or older,
      otherwise it's false*/
        if (isAdult) {
        System.out.println("YOU ARE AN ADULT BY THE WAY.");
        } else {
      System.out.println(" YOU ARE STILL YOUNG BRO!!");} 

    }
}  

