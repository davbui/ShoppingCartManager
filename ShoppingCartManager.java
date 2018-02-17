/* Program: ShoppingCartManager                  
   Heidi Clinger                                        
   December 2017                                 
   This program has the project's main method.   
   The main method creates the user menu and     
   calls the methods of the ItemsToPurchase and  
   ShoppingCart programs.                        
*/

import java.util.Scanner;

public class ShoppingCartManager {
   
   public static void main(String args[]) {
      //Input entered by the user
      Scanner usrInput = new Scanner(System.in);
      
      //The option from the menu that the user selects
      String userMenuSelection = "-";
      
      //The flag to continue printing the menu
      Boolean repeat = true;
      
      //The name of the shopping cart owner
      String newCustomerName = "";
      
      //The date the shopping cart is created
      String newCartDate = "";
      
      //Initial prompt to screen to create new shopping cart
      System.out.println("Enter Customer's Name:");
      newCustomerName = usrInput.nextLine();
      System.out.println("Enter Today's Date:");
      newCartDate = usrInput.nextLine();
      
      //creat shopping cart using user entered data
      ShoppingCart cart1 = new ShoppingCart(newCustomerName, newCartDate);
      
      //Display received data to the screen
      System.out.println("");
      System.out.println("Customer Name: " + cart1.getCustomerName());
      System.out.println("Today's Date: " + cart1.getDate());
      
      //create the menu for the user to select options
      while(repeat)
      {
         System.out.println("");
         System.out.println("MENU");
         System.out.println("a - Add item to cart");
         System.out.println("d - Delete item from cart");
         System.out.println("c - Change item quantity");
         System.out.println("i - Output items' descriptions");
         System.out.println("p - Print shopping cart");
         System.out.println("o - Order items in cart");
         System.out.println("q - Quit");
         System.out.println("");
         System.out.println("Choose an option:");
         
         userMenuSelection = usrInput.next();
         userMenuSelection = userMenuSelection.toLowerCase();
         
         //switch statement based on user selection - each options calls methods created
         //in ItemToPurchase and ShoppingCart programs.
         if(userMenuSelection.equals("a") || userMenuSelection.equals("d") ||
            userMenuSelection.equals("c") || userMenuSelection.equals("i") ||
            userMenuSelection.equals("p") || userMenuSelection.equals("o") ||
            userMenuSelection.equals("q"))
         {
            switch(userMenuSelection)
            {
               case "q":
                  System.out.println("Exiting Shopping Cart Manager");
                  repeat = false;
                  break;
               case "p":
                  System.out.println("PRINT SHOPPING CART");
                  cart1.printTotal();
                  break;
               case "i":
                  System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
                  cart1.printDescriptions();
                  break;
               case "a":
                  usrInput.nextLine();
                  System.out.println("ADD ITEM TO CART");
                  System.out.println("Enter the item name:");
                  String newItemName = usrInput.nextLine();
                  System.out.println("Enter the item description:");
                  String newItemDescrip = usrInput.nextLine();
                  System.out.println("Enter the item price:");
                  double newItemPrice = usrInput.nextDouble();
                  System.out.println("Enter the item quantity:");
                  int newItemQuant = usrInput.nextInt();
                  
                  ItemToPurchase newItem = new ItemToPurchase(newItemName, newItemDescrip, newItemPrice, newItemQuant);
                  cart1.addItem(newItem);
                  break;
               case "d":
                  usrInput.nextLine();
                  System.out.println("REMOVE ITEM FROM CART");
                  System.out.println("Enter name of item to remove:");
                  cart1.removeItem(usrInput.nextLine());
                  break;
               case "c":
                  usrInput.nextLine();
                  System.out.println("CHANGE ITEM QUANTITY");
                  System.out.println("Enter the item name:");
                  String itemName = usrInput.nextLine();
                  System.out.println("Enter the new quantity:");
                  int newQuantity = usrInput.nextInt();
                  cart1.changeQuantity(itemName, newQuantity);
                  break;
               case "o":
                  System.out.println("ORDER ITEMS IN CART");
                  cart1.processOrder();
                  repeat = false;
                  break;        
            }
         }
         else
         {
            System.out.println("Choose an option:");
         }
      }   
   
   return;
   }
}