import java.util.Scanner;
public class calculator {
    public static void
main(String[] args){
Scanner myScanner = new Scanner(System.in);

System.out.println("FIRST NUMBER: ");
double num1 = myScanner.nextDouble();

System.out.println("SECOND NUMBER: ");
double num2 =myScanner.nextDouble();

System.out.println("OPERATION SIGN (+-/*): ");
char sign = myScanner.next().charAt(0);

double answer = 0 ;


switch(sign){
    case '+':
    answer = num1 + num2;
    break;

    case '-':
    answer = num1 - num2;
    break;

    case '/':
    answer =  num1/num2;
    break;

    case '*':
    answer = num1*num2;
    break;

    default:
        System.out.println("INVALID OPERATOR CHECK AGAIN!");
    }
    System.out.println("ANSWER: " + answer);
    System.out.println("THANK YOU!");

    }
 }