import java.text.NumberFormat;
import java.util.Scanner;

public class mortgagecalc{
    public static void main(String[] args){
Scanner scannerName = new Scanner(System.in);
int principal =0;
  
 while(true){ //we are creating an infinite loop that allows input in that range to continue
    System.out.print("Principal ($1K - $1M): ");
    principal = scannerName.nextInt();
  if( principal >=1000 && principal <=1000000){ 
    break;
    }
   System.out.println("ENTER A VALID AMOUNT");
}
Float interestRate;
Float monthlyInterest;
while (true){ //validation to accept 0-30
 System.out.print("Annual Interest Rate: ");
 interestRate = scannerName.nextFloat();
 monthlyInterest = interestRate / 12;
 if (interestRate >=0 && interestRate <=30)
    break;
System.out.println("ENTER A VALUE (0-30)!");
} 

byte period;
int numberOfPayments;
while(true){
 System.out.print("Period (Years): ");
  period = scannerName.nextByte();
 numberOfPayments = period * 12;
 if (period >=1 && period<= 30)
    break;
System.out.println(" ENTER A VALUE BETWEEN 1-30");
}

Double mortgage = principal
               *( monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
               /(Math.pow(1 + monthlyInterest , numberOfPayments)- 1);
String mortgageFormarted = NumberFormat.getCurrencyInstance().format(mortgage);
 System.out.print("Mortgage: " + mortgageFormarted);


    }
}




