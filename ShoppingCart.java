/* 
   Program: ShoppingCartManager                  
   Heidi Clinger                                         
   December 2017
                                    
   This program creates the shopping cart, using 
   an array list, to hold the items created by
   the itemToPurchase class. The main method for 
   this final project is located in 
   ShoppingCartManager.java                   
*/

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
   //The shopping cart owner's name
   private String customerName;
   
   //The current date entered by the shopping cart creator
   private String currentDate;
   
   //The array list to hold the item that the cart
   //owner will purchase
   private ArrayList<ItemToPurchase> cartItems = 
      new ArrayList<ItemToPurchase>();
   
   /**
      Default Constructor
   */
   public ShoppingCart() {
      customerName = "none";
      currentDate = "January 1, 2016";
   }
   
   /**
      Standard Constructor
      @param newCustomerName The name of the cart owner
      @param newCurrentDate The date of the shopping cart 
      creation
   */
   public ShoppingCart(String newCustomerName, String newCurrentDate) {
      customerName = newCustomerName;
      currentDate = newCurrentDate;
   }
   
   /**
      Accessor method to get customer name
      @return The customer's name
   */
   public String getCustomerName() {
      return customerName;
   }
   
   /**
      Accessor method to get current date
      @return The date of the shopping cart
   */
   public String getDate() {
      return currentDate;
   }
   
   /**
      The addItem method adds a specified item to
      the arrayList, aka the shopping cart
      @param selectedItem The item object to add to 
      the list
   */
   public void addItem(ItemToPurchase selectedItem) {
      cartItems.add(selectedItem);
   }
   
   /**
      The removeItem method removes a specified item
      from the arrayList, aka the shopping cart
      @param selectedItem The item object to remove
      from the list
   */
   public void removeItem(String selectedItem) {
      int i = 0;
      Boolean itemFound = false;
      while(!itemFound && i<cartItems.size()) {
         if(cartItems.get(i).getName().equals(selectedItem)) {
            itemFound = true;
         }
         else
         {
            i++;
         }
      }
      if(!itemFound) {
         System.out.println("Item not found in cart. Nothing deleted.");
      }
      else {
         cartItems.remove(i);
      }
   }
   
   /**
      The modifyItem method reviews the arrayList for the
      specified item. The item description, price, and
      quantity are then validated. If any fields are missing
      data, the user is prompted to update the information.
      @param itemTag The name of the item to search and review.
   */
   public void modifyItem(ItemToPurchase itemTag)
   {
      int i = 0;
      Boolean itemFound = false;
      String searchItem = itemTag.getName();      
      Scanner usrInput = new Scanner(System.in);
      
      while((!itemFound) && (i<cartItems.size()))
      {
         if(cartItems.get(i).getName().equals(searchItem))
         {
            itemFound = true;
         }
         else
         {
            i++;
         }
      }
      if(!itemFound) 
      {
         System.out.println("Item not found in cart. Nothing" 
            + " modified.");
      }
      else 
      {
         if(cartItems.get(i).getDescription().equals("none")) 
         {
            System.out.println("Enter the new description:");
            cartItems.get(i).setDescription(usrInput.nextLine());
         }
         if(cartItems.get(i).getPrice() == 0) 
         {
            System.out.println("Enter the new price:");
            cartItems.get(i).setPrice(usrInput.nextInt());
         }
         if(cartItems.get(i).getQuantity() == 0)
         {
            System.out.println("Enter the new quantity:");
            cartItems.get(i).setQuantity(usrInput.nextInt());
         }
      }
   }
   
   /**
      The getNumItemsInCart returns the number of items in 
      the shopping cart.
      @return The total quantity of items in the shopping
      cart.
   */
   public int getNumItemsInCart()
   {
      int totalQuantity = 0;
      int i = 0;
      
      for(i = 0; i < cartItems.size(); i++)
      {
         int itemQuantity = cartItems.get(i).getQuantity();
         totalQuantity = totalQuantity + itemQuantity;
      }
      return totalQuantity;
   }
   
   /**
      The getCostOfCart method adds and returns the total
      cost of all the items in a customer's shopping cart.
      @return The total cost of the shopping cart.
   */
   public double getCostOfCart()
   {
      double totalCost = 0;
      int i = 0;
      
      for(i = 0; i < cartItems.size(); i++)
      {
         double itemCost = cartItems.get(i).getPrice() * 
            ((double)cartItems.get(i).getQuantity());
         totalCost = totalCost + itemCost;
      }
      return totalCost;
   }
   
   /**
      The printTotal method prints the total cost of the shopping
      cart, calculated by the getCostOfCart method.
   */
   public void printTotal()
   {
      int i = 0;
      
      System.out.println(this.getCustomerName() + "'s Shopping Cart - " + 
         this.getDate());
      System.out.println("Number of Items: " + this.getNumItemsInCart());
      System.out.println("");
      for(i = 0; i < cartItems.size(); i++) //prints the name, quant, price, 
                                            //and total for each item in 
      {                                     //the cart
         cartItems.get(i).printItemCost();
      }
      if(cartItems.size() == 0)
      {
         System.out.println("SHOPPING CART IS EMPTY");
      }
      System.out.println("");
      System.out.println("Total: $" + this.getCostOfCart());    
   }
   
   /**
      The printDescription method prints the item
      description for each item in the customer's
      shopping cart.
   */
   public void printDescriptions()
   {
      int i = 0;
      
      System.out.println(this.getCustomerName() + "'s Shopping Cart - " 
         + this.getDate());
      System.out.println("");
      System.out.println("Item Descriptions");
      for(i = 0; i < cartItems.size(); i++) //print the name and description  
      {                                     //for each item in the cart
         System.out.println(cartItems.get(i).getName() + ": " + 
            cartItems.get(i).getDescription());
      }
   }
   
   /**
      The changeQuantity method searches for an item in the
      shopping cart and propts the user to change the quantity
      for purchase.
      @param itemName The name of the item to search for
      @param newQuantity The new quantity to set for the item
   */
   public void changeQuantity(String itemName, int newQuantity)
   {
      int i = 0;
      Boolean itemFound = false;      
      Scanner usrInput = new Scanner(System.in);
      
      while((!itemFound) && (i<cartItems.size()))
      {
         if(cartItems.get(i).getName().equals(itemName))
         {
            itemFound = true;
         }
         else
         {
            i++;
         }
      }
      if(!itemFound) 
      {
         System.out.println("Item not found in cart. Nothing modified.");
      }
      else
      {
         cartItems.get(i).setQuantity(newQuantity);
      }
   }
   
   /**
      The processOrder method writes the shopping cart data
      to a file. The name, description, and quantity for
      each item are written.
   */
   public void processOrder() 
   {
      //create a variable to hold the file name that we will write to
      String fileName = "shoppingcartorder.txt";
      
      //create new PrintWriter wrapped in a BufferedWriter
      PrintWriter outputStream = null;
                     
      //create a try catch for exceptions if the file cannot be opened
      try {
         outputStream = new PrintWriter(fileName);
      }
      catch(FileNotFoundException e) {
         System.out.println("Unable to process order. Please contact support.");
         System.exit(0);
      }
      
      //if no exception - write to file
      String userData = (this.getCustomerName() + "\r\n" + this.getDate() +
                         "\r\n\r");
      outputStream.println(userData);
                  
      int i = 0;
      for(i=0; i<cartItems.size(); i++)
      {
         String cartItem = (cartItems.get(i).getName() + ": " + 
            cartItems.get(i).getDescription() + ", Order quantity: " + 
            cartItems.get(i).getQuantity());
         outputStream.println(cartItem + "\r");
      }
      System.out.println("Your order has been processed.");
      System.out.println("Exiting shopping cart manager.");     
      outputStream.close();   
   }
}