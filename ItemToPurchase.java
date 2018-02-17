/**Program: ShoppingCartManager
   Heidi Clinger
   December 2017
                                   
   This program creates an item to purchase which
   will be part of a shopping cart manager. Once
   created, the items can be added, modified, and
   deleted to and from an individual's shopping
   cart. The main method for this final project 
   is located in ShoppingCartManager.java                   
*/

public class ItemToPurchase {
   // The item name
   private String itemName;
   
   //The item description
   private String itemDescription;
   
   //The item price
   private double itemPrice;
   
   //The quantity of items being purchased
   private int itemQuantity;
   
   /**
      Default constructor
   */
   public ItemToPurchase() {
      itemName = "none";
      itemDescription = "none";
      itemPrice = 0.00;
      itemQuantity = 0;
   }
   
   /**
      Standard Constructor
   */
   public ItemToPurchase(String newItemName, String newItemDescription, 
      double newItemPrice, int newItemQuantity) {
      itemName = newItemName;
      itemDescription = newItemDescription;
      itemPrice = newItemPrice;
      itemQuantity = newItemQuantity;
   }
   
   /**
      Mutator method to set the item name
      @param newItemName The name of the item
   */
   public void setName(String newItemName) {
      itemName = newItemName;
   }
   
   /**
      Mutator method to set the item description
      @param newItemDescription The description of the
      item 
   */
   public void setDescription(String newItemDescription) {
      itemDescription = newItemDescription;
   }
   
   /**
      Mutator method to set the item price
      @param newItemPrice The price of the item 
   */
   public void setPrice(double newItemPrice) {
      itemPrice = newItemPrice;
   }
   
   /**
      Mutator method to set the item quantity
      @param newItemQuantity The quantity of the new item
   */
   public void setQuantity(int newItemQuantity) {
      itemQuantity = newItemQuantity;
   }
   
   /**
      Accessor method to the item name
      @return The name of the item
   */
   public String getName() {
      return itemName;
   }
   
   /**
      Accessor method to get item description
      @return The item description
   */
   public String getDescription() {
      return itemDescription;
   }
   
   /**
      Accessor method to get the item price
      @return The price of the item.
   */
   public double getPrice() {
      return itemPrice;
   }
   
   /**
      Accessor method to get the item quantity
      @return The quantity of the item
   */
   public int getQuantity() {
      return itemQuantity;
   }
   
   /**
      Accessor method to output item name followed 
      by quantity, price, and subtotal
   */
   public void printItemCost() {
      System.out.println(this.getName() + " " + this.getQuantity() + 
         " @ $" + this.getPrice() + " = $" + (((double)this.getQuantity()) * 
         this.getPrice()));
   }
   
   /**
      Accessor method to output item name and 
      description
   */
   public void printItemDescription() {
      System.out.println(this.getName() + ": " + this.getDescription() + ".");
   }
}