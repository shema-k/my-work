public class SHEMA {
    public static void main(String[] args){
System.out.println("HELLO BOSSMAN!!!");
System.out.println("Hope you are doing well?! ");
System.out.print("How is the going? ");
System.out.println("All good? ");
//entering values with data types
/*it follows the syntax, dataType variableName = value; */
int cash = 40000000;
double amount =2.999; //those with decimal points are double
String name ="shema"; //text is string
float price = 2.99f;
 /*float is also for decimal points but with less precision than double.
 when writing many decimal places.. that is why we add f;
 to save memory space*/
long population = 1000000000L; //for large numbers we use long and add L at the end ...8bytes
short year = 2024; /*for small numbers we use short ...2bytes
int 4 bytes
long 8 bytes*/
byte age = 22; //for very small numbers we use byte ...1byte -128 to 127
char grade = 'A'; //for single characters we use char and we enclose it in single quotes
boolean isWlaking = true; //true or false is boolean
System.out.println("I need " + cash + " shillings to sort myself out.");}}
