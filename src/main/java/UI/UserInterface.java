package UI;

import models.*;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    Order order = new Order();
    ReceiptWriter receiptWriter = new ReceiptWriter();

    public void displayHomeScreen() {
        while (true) {
            System.out.println("Welcome to the Home Screen!");
            System.out.println("Please select an option:");
            System.out.println("Press 1 for a new order");
            System.out.println("Press 0 to exit the application");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    displayOrderScreen();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void displayOrderScreen() {
        while (true) {
            System.out.println("Welcome to the Order Screen!");
            System.out.println("Please select an option:");
            System.out.println("Press 1 to add sandwich");
            System.out.println("Press 2 to add drink");
            System.out.println("Press 3 to add chips");
            System.out.println("Press 4 to checkout");
            System.out.println("Press 0 to cancel order");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addSandwich();
                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addChips();
                    break;
                case "4":
                    checkOut();
                    break;
                case "0":
                    System.out.println("Cancelling order...");
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private void addSandwich() {
        System.out.println("What kind of bread would you like? White, Wheat, Rye, or Wrap");
        String breadType = scanner.nextLine().toLowerCase().trim();
        System.out.println("What bread length would you like? 4\", 8\", or 12\"");
        String breadLength = scanner.nextLine().toLowerCase().trim();
        System.out.println("Would you like it toasted? true or false");
        boolean toasted = scanner.nextBoolean();
        Sandwich sandwich = new Sandwich(breadType, breadLength, toasted);

        System.out.println("Would you like meat on your sandwich?");
    }

    private void addChips() {
        System.out.println("Which flavor would you like? Regular, Jalapeño, or BBQ");
        String flavor = scanner.nextLine().toLowerCase().trim();
        Chips chips = new Chips(flavor);
        order.addProduct(chips);
        System.out.println(chips.getReceipt());
    }

    private void addDrink() {
        System.out.println("Which size would you like? Small, Medium, or Large");
        String size = scanner.nextLine().toLowerCase().trim();
        System.out.println("Which flavor would you like? Coke, Sprite, or Dr. Pepper");
        String flavor = scanner.nextLine().toLowerCase().trim();
        Drink drink = new Drink(size, flavor);
        order.addProduct(drink);
        System.out.println(drink.getReceipt());
    }

    public void checkOut() {
        System.out.println("Checkout:");
        order.getTotalPrice();
        order.getOrderSummary();
        System.out.println("Enter 1 to confirm");
        System.out.println("Enter 0 to cancel");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.println("Saving receipt...");
                receiptWriter.saveReceipt(order);
                break;
            case "0":
                System.out.println("Cancelling order...");
                order.products.clear();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public void addToppingsMenu(Sandwich sandwich) {
        System.out.println("Select topping to add:");
        System.out.println("Enter 1 to add meat (premium)");
        System.out.println("Enter 2 to add cheese (premium)");
        System.out.println("Enter 3 to add regular topping (included)");
        System.out.println("Enter 4 to add sauce (included)");
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "1":
                addMeatMenu(sandwich);
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
        }

    }

    private void addMeatMenu(Sandwich sandwich) {
        boolean running = true;
        while (running) {
            System.out.println("Select meat to add");
            System.out.println("Enter 1 to add steak");
            System.out.println("Enter 2 to add ham");
            System.out.println("Enter 3 to add salami");
            System.out.println("Enter 4 to add roast beef");
            System.out.println("Enter 5 to add chicken");
            System.out.println("Enter 6 to add bacon");
            System.out.println("Enter 7 to add extra meat");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    sandwich.addTopping(new Topping("steak", "meat", false));
                    break;
                case "2":
                    sandwich.addTopping(new Topping("ham", "meat", false));
                    break;
                case "3":
                    sandwich.addTopping(new Topping("salami", "meat", false));
                    break;
                case "4":
                    sandwich.addTopping(new Topping("roast beef", "meat", false));
                    break;
                case "5":
                    sandwich.addTopping(new Topping("chicken", "meat", false));
                    break;
                case "6":
                    sandwich.addTopping(new Topping("bacon", "meat", false));
                    break;
                case "7":
                    extraMeatMenu(sandwich);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println("Would you like extra meat?");
            System.out.println("Enter 1 for yes");
            System.out.println("Enter 0 for no");
            String extraMeatChoice = scanner.nextLine().trim();
            if(extraMeatChoice.equals("1")){

            }
        }

    }

    private void extraMeatMenu(Sandwich sandwich) {
        System.out.println("Select meat to add");
        System.out.println("Enter 1 to add steak");
        System.out.println("Enter 2 to add ham");
        System.out.println("Enter 3 to add salami");
        System.out.println("Enter 4 to add roast beef");
        System.out.println("Enter 5 to add chicken");
        System.out.println("Enter 6 to add bacon");
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "1":
                sandwich.addTopping(new Topping("steak", "meat", true));
                break;
            case "2":
                sandwich.addTopping(new Topping("ham", "meat", true));
                break;
            case "3":
                sandwich.addTopping(new Topping("salami", "meat", true));
                break;
            case "4":
                sandwich.addTopping(new Topping("roast beef", "meat", true));
                break;
            case "5":
                sandwich.addTopping(new Topping("chicken", "meat", true));
                break;
            case "6":
                sandwich.addTopping(new Topping("bacon", "meat", true));
                break;
        }
    }
}


//        public void meat(){
//            System.out.println("Select meat:");
//            System.out.println("Press 1 for steak");
//            System.out.println("Press 2 for ham");
//            System.out.println("Press 3 for salami");
//            System.out.println("Press 4 for roast beef");
//            System.out.println("Press 5 for chicken");
//            System.out.println("Press 6 for bacon");
//            System.out.println("Press 7 to add extra meat");
//            String choice = scanner.nextLine();
//
//        }
//        public void cheese(){
//            System.out.println("Select cheese:");
//            System.out.println("Press 1 for american");
//            System.out.println("Press 2 for provolone");
//            System.out.println("Press 3 for cheddar");
//            System.out.println("Press 4 for swiss");
//            System.out.println("Press 5 to add extra cheese");
//            String choice = scanner.nextLine();
//        }
//
//        public void lettuce(){
//            System.out.println("Do you want lettuce?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void peppers(){
//            System.out.println("Do you want peppers?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void onions(){
//            System.out.println("Do you want onions?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void tomatoes(){
//            System.out.println("Do you want tomatoes?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void jalapenos(){
//            System.out.println("Do you want jalapeños?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void cucumbers(){
//            System.out.println("Do you want cucumbers?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void pickles(){
//            System.out.println("Do you want pickles?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void guacamole(){
//            System.out.println("Do you want guacamole?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void mushrooms(){
//            System.out.println("Do you want mushrooms?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//    }