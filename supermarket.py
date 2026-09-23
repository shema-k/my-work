VAT = 0.18
receipt = [] #stacking items on the receipt

while True:
  print("\nMAIN MENU                          ")
  print("1.ADD ITEM")
  print("2.VIEW RECEIPT")
  print("3.EXIT PROGRAM")

  menu_choice = input("\nENTER YOUR CHOICE: ")

  match menu_choice:
     case "1":
       itemName= input("\nENTER ITEM NAME: ")
       unitPrice= float(input("UNIT PRICE: "))
       quantity= int(input("QUANTITY: "))
       itemTotal = unitPrice * quantity
       
       receipt.append({
         "ITEM": itemName,
         "UNITPRICE": unitPrice,
         "QUANTITY": quantity,
         "TOTAL": itemTotal
       })
       print("ITEM ADDED!")

     case "2":
       print("\n                 SHOPPERS BY OMMY                  ")
       print("----------------CUSTOMER'S RECEIPT-----------------\n")
       if not  receipt:
         print(f"{'ITEM':<15} {'UNITPRICE':<12} {'QTY':<7} {'TOTAL'} ")
         print("                         ")
         print("        NO ITEMS ON THE LIST!!!!")
         print("        NO ITEMS ON THE LIST!!!!")
         print("        NO ITEMS ON THE LIST!!!!")
         print("                         ")
         print(f'{'SUBTOTAL: '}')
         print(f'{'VAT: '}')
         print(f'{'GRANDTOTAL: '}') 
         print('                                 ')
      
       else:
        subtotal =0
        print(f"{'ITEM':<15} {'UNITPRICE':<12} {'QTY':<7} {'TOTAL'} ") 
        for item in receipt:
          itemName = item['ITEM']
          unitPrice = item['UNITPRICE']
          quantity = item['QUANTITY']
          itemTotal = item['TOTAL']
          print(f'{itemName:<15} {unitPrice:<12} {quantity:<7} {itemTotal:.2f}')
          
       subtotal += itemTotal
       VAT = subtotal * 0.18
       grandTotal = subtotal + VAT
       print(f'{'SUBTOTAL: '}{subtotal:.2f}')
       print(f'{'VAT: '}{VAT:.2f}')
       print(f'{'GRANDTOTAL: '}{grandTotal:.2f}')  
       print('                                 ')
       print('=================================')
       print('                                 ')
       print('THANK YOU FOR YOUR SUPPORT! COME AGAIN!!')
        

     case "3":
        print("THANK YOU FOR YOUR SUPPORT. COME AGAIN!")
        break

     case _:
        print("INVALID CHOICE! TRY AGAIN")