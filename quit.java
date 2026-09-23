import java.util.Scanner;
public class quit {
    public static void main(String[] args) { //a system that displays the input of the user until they type "quit"
        Scanner scanner = new Scanner(System.in);
        String input =""; //initialising the string
        while (!input.equalsIgnoreCase("quit")){ // we cannot use "!=" because this is a string
            System.out.print("input: ");
            input = scanner.nextLine();
            System.out.println(input);
        }
    }
}
