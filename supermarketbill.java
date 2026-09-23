import java.util.Date;
import java.util.Scanner;
import java.io.*;  // added for file saving

public class supermarketbill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean menu2 = true;
        double unitPrice = 0;
        String itemName = "";
        int quantity = 0;
        double totalPrice = 0;
        double grandTotal = 0;
        double VAT = 0;

        // NEW: a StringBuilder to store the whole receipt as we add items
        StringBuilder receipt = new StringBuilder();

        System.out.println("======OMMY SHOPPERS======");
        boolean menu1 = true;
        while (menu1) {
            System.out.println("******MAIN MENU******");
            System.out.println("1.ADD ITEM ");
            int menuChoice = scanner.nextInt();

            itemName = ""; //initialising a string

            //STAGE 1
            switch (menuChoice) {
                case 1:
                    System.out.print("NUMBER OF ITEMS: ");
                    int itemNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()
                    /*however you only add scanner.nextLine() if you are coming from
                    nextInt(), nextDouble(), nextFloat(), nextBoolean() to nextLine()*/

                    if (itemNumber < 0 || itemNumber == 0) {
                        System.out.println("No items on the list, please check again!");
                    }
                    for (int i = 1; i <= itemNumber; i++) {
                        System.out.println("ITEM " + i + ": ");
                        do {
                            System.out.print("NAME: ");
                            itemName = scanner.nextLine();
                            if (itemName.trim().isEmpty())
                             System.out.println("PLEASE ENTER ITEM NAME!!");
                        } while (itemName.trim().isEmpty());

                        System.out.print("UNIT PRICE: Shs.");
                        unitPrice = scanner.nextDouble();

                        System.out.println("QUANTITY: " );
                        quantity = scanner.nextInt();
                        scanner.nextLine();

                        // --- FIX: add this item's details to the receipt string ---
                        double itemTotal = unitPrice * quantity;
                        totalPrice += itemTotal;   // accumulate subtotal
                        receipt.append(String.format("%-15s %5d %10.2f %12.2f\n",
                                itemName, quantity, unitPrice, itemTotal));
                    }
                    // --- FIX: compute VAT and grand total AFTER all items are entered ---
                    VAT = 0.20 * totalPrice;
                    grandTotal = totalPrice + VAT;

                    menu1 = false; // exiting the while loop so i go to menu 2
                    break;
                default:
                    System.out.print("WRONG CHOICE,PLEASE TRY AGAIN\n\n");
            }
        }

        //STAGE 2
        while (menu2) {
            System.out.println("2.VIEW RECEIPT");
            System.out.println("3.SAVE RECEIPT");
            System.out.println("4.EXIT PROGRAM");
            int choice2 = scanner.nextInt();

            switch (choice2) {
                case 2:
                    System.out.println("======STARRR SHOPPERS======");
                    // --- FIX: print the stored receipt ---
                    System.out.printf("%-15s %5s %10s %12s\n", "Item", "Qty", "Price", "Total");
                    //printf stands for print formatted: prints text but lets, you control the layout
                  
                    System.out.println("--------------------------------------------");
                    System.out.print(receipt.toString());
                    System.out.println("--------------------------------------------");
                    System.out.printf("Subtotal: %40.2f\n", totalPrice);
                    System.out.printf("VAT (20%%): %38.2f\n", VAT);
                    System.out.printf("GRAND TOTAL: %36.2f\n", grandTotal);
                    System.out.println("=====THANK YOU FOR SHOPPING WITH US.=====");
                    System.out.println("*************service beyond**************");
                    break;

                case 3:
                    // --- NEW: save receipt to file ---
                    if (receipt.length() == 0) {
                        System.out.println("No items to save!");
                        break;
                    }
                    try (PrintWriter writer = new PrintWriter(new FileWriter("bill.txt"))) {
                      // FileWriter creates and opens a file called bill.txt.
                      //PrintWriter  gives you easy methods for your system to write directly into the file.
                      /*WRITER  is more like a digital pen that prints work  from the system directle into the file.
                       forexample in Scanner scanner = new Scanner(System.in), "scanner" is it's name and it varies.
                       so for this case, "writer" is the name of the PrintWriter.*/
                        writer.println("======STARRR SHOPPERS======");
                        writer.printf("%-15s %5s %10s %12s\n", "Item", "Qty", "Price", "Total");
                        writer.println("--------------------------------------------");
                        writer.print(receipt.toString());
                        writer.println("--------------------------------------------");
                        writer.printf("Subtotal: %40.2f\n", totalPrice);
                        writer.printf("VAT (20%%): %38.2f\n", VAT);
                        writer.printf("GRAND TOTAL: %36.2f\n", grandTotal);
                        writer.println("=====THANK YOU FOR SHOPPING WITH US.=====");
                        writer.println("*************service beyond**************");
                        System.out.println("Bill saved to bill.txt");
                    } catch (IOException e) {
                        System.out.println("Error saving file: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Exiting program........");
                    scanner.close(); //user to close the scanner tool after taking input from the user
                    menu2 = false; //closing the second while boolean loop
                    return;
                default:
                    System.out.println("WRONG CHOICE, PLEASE TRY AGAIN");
            }
        }
    }
}