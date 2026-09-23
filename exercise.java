import java.util.Scanner;
public class exercise {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int number;
         System.out.print("Number: ");
         number = scanner.nextInt();
           
         if( number%5 == 0 && number%3 == 0) {
          System.out.println("FIZZBUZZ");} // it's safer to start with the complex combos
         else if(number%5 == 0){System.out.println("FIZZ");
          }
         else if(number%3 == 0){System.out.println("BUZZ");         
          } 
          else if (number%5 !=0 && number%3 !=0) {
            System.out.println(number);
          }   

          for (int i=0; i<5; i++){
            System.out.println("Hello world " + i);
          }
          for (int j=5; j<0; j--){
            System.out.println("Hello world " + j);
          } // printing in decscending order
    }
}