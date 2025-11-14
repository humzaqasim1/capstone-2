package UI;

import models.*;

import java.util.ArrayList;
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
            System.out.println("Press 0 to exit order screen");
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
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private void addSandwich() {
        ArrayList<Topping> meats = new ArrayList<>();
        ArrayList<Topping> cheeses = new ArrayList<>();
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<Topping> sauces = new ArrayList<>();
        System.out.println("What kind of bread would you like? White, Wheat, Rye, or Wrap");
        String breadType = scanner.nextLine().toLowerCase().trim();
        System.out.println("What bread length would you like? 4\", 8\", or 12\"");
        String breadLength = scanner.nextLine().toLowerCase().trim();
        System.out.println("Would you like it toasted? Y or N");
        String toastedChoice = scanner.nextLine().toLowerCase().trim();
        boolean toasted = false;
        if (toastedChoice.equalsIgnoreCase("y")){
            toasted = true;
        } else if (toastedChoice.equalsIgnoreCase("n")){
            toasted = false;
        }
        System.out.println("Would you like meat (premium) on your sandwich? Y or N");
        String meatChoice = scanner.nextLine().toLowerCase().trim();
        if (meatChoice.equalsIgnoreCase("y")){
            meats = addMeatMenu();
        }
        System.out.println("Would you like cheese (premium) on your sandwich? Y or N");
        String cheeseChoice = scanner.nextLine().toLowerCase().trim();
        if (cheeseChoice.equalsIgnoreCase("y")){
            cheeses = addCheeseMenu();
        }
        System.out.println("Would you like add regular (included) toppings? Y or N");
        String toppingsChoice = scanner.nextLine().toLowerCase().trim();
        if (toppingsChoice.equalsIgnoreCase("y")){
            toppings = addRegularToppingMenu();
        }
        System.out.println("Would you like add sauce (included)? Y or N");
        String sauceChoice = scanner.nextLine().toLowerCase().trim();
        if (sauceChoice.equalsIgnoreCase("y")){
            sauces = addSauceMenu();
        }
        Sandwich sandwich = new Sandwich(breadType, breadLength, toasted, toppings, meats, cheeses, sauces);
        order.addProduct(sandwich);
        System.out.println(sandwich.getReceipt());
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
        order.getOrderSummary();
        System.out.println("Order total: $" + order.getTotalPrice());
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

    public ArrayList<Topping> addMeatMenu() {
        ArrayList<Topping> toppings = new ArrayList<>();
        boolean running = true;
        while (running) {
            System.out.println("Select meat to add:");
            System.out.println("Enter 1 to add steak");
            System.out.println("Enter 2 to add ham");
            System.out.println("Enter 3 to add salami");
            System.out.println("Enter 4 to add roast beef");
            System.out.println("Enter 5 to add chicken");
            System.out.println("Enter 6 to add bacon");
            System.out.println("Enter 0 to exit meat menu");
            String choice = scanner.nextLine().trim();
            if (choice.equals("0")){
                return toppings;
            }
            System.out.println("Would you like extra? Enter Y or N");
            String extraChoice = scanner.nextLine().toLowerCase().trim();
            switch (choice) {
                case "1":
                    toppings.add(new Topping("steak", "meat", extraChoice.equals("y")));
                    running = false;
                    break;
                case "2":
                    toppings.add(new Topping("ham", "meat", extraChoice.equals("y")));
                    running = false;
                    break;
                case "3":
                    toppings.add(new Topping("salami", "meat", extraChoice.equals("y")));
                    running = false;
                    break;
                case "4":
                    toppings.add(new Topping("roast beef", "meat", extraChoice.equals("y")));
                    running = false;
                    break;
                case "5":
                    toppings.add(new Topping("chicken", "meat", extraChoice.equals("y")));
                    running = false;
                    break;
                case "6":
                    toppings.add(new Topping("bacon", "meat", extraChoice.equals("y")));
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        return toppings;
    }

    public ArrayList<Topping> addCheeseMenu() {
        ArrayList<Topping> toppings = new ArrayList<>();
        boolean running = true;
        while (running) {
            System.out.println("Select cheese to add:");
            System.out.println("Enter 1 to add american");
            System.out.println("Enter 2 to add provolone");
            System.out.println("Enter 3 to add cheddar");
            System.out.println("Enter 4 to add swiss");
            System.out.println("Enter 0 to exit cheese menu");
            String choice = scanner.nextLine().trim();
            if (choice.equals("0")){
                return toppings;
            }
            System.out.println("Would you like extra? Enter Y or N");
            String extraChoice = scanner.nextLine().toLowerCase().trim();
            switch (choice) {
                case "1":
                    toppings.add(new Topping("american", "cheese", extraChoice.equals("y")));
                    running = false;
                    break;
                case "2":
                    toppings.add(new Topping("provolone", "cheese", extraChoice.equals("y")));
                    running = false;
                    break;
                case "3":
                    toppings.add(new Topping("cheddar", "cheese", extraChoice.equals("y")));
                    running = false;
                    break;
                case "4":
                    toppings.add(new Topping("swiss", "cheese", extraChoice.equals("y")));
                    running = false;
                    break;
            }
        }
        return toppings;
    }

    public ArrayList<Topping> addRegularToppingMenu() {
        ArrayList<Topping> toppings = new ArrayList<>();
        boolean running = true;
        while (running) {
            System.out.println("Select toppings to add:");
            System.out.println("Enter 1 to add lettuce");
            System.out.println("Enter 2 to add peppers");
            System.out.println("Enter 3 to add onions");
            System.out.println("Enter 4 to add tomatoes");
            System.out.println("Enter 5 to add jalapeños");
            System.out.println("Enter 6 to add cucumbers");
            System.out.println("Enter 7 to add pickles");
            System.out.println("Enter 8 to add guacamole");
            System.out.println("Enter 9 to add mushrooms");
            System.out.println("Enter 0 when finished adding toppings");
            String choice = scanner.nextLine().trim();
            if (choice.equals("0")){
                return toppings;
            }
            switch (choice) {
                case "1":
                    toppings.add(new Topping("lettuce", "regular", false));
                    break;
                case "2":
                    toppings.add(new Topping("peppers", "regular", false));
                    break;
                case "3":
                    toppings.add(new Topping("onions", "regular", false));
                    break;
                case "4":
                    toppings.add(new Topping("tomatoes", "regular", false));
                    break;
                case "5":
                    toppings.add(new Topping("jalapeños", "regular", false));
                    break;
                case "6":
                    toppings.add(new Topping("cucumbers", "regular", false));
                    break;
                case "7":
                    toppings.add(new Topping("pickles", "regular", false));
                    break;
                case "8":
                    toppings.add(new Topping("guacamole", "regular", false));
                    break;
                case "9":
                    toppings.add(new Topping("mushrooms", "regular", false));
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        return toppings;
    }

    public ArrayList<Topping> addSauceMenu() {
        ArrayList<Topping> toppings = new ArrayList<>();
        boolean running = true;
        while (running) {
            System.out.println("Select sauce to add:");
            System.out.println("Enter 1 to add mayo");
            System.out.println("Enter 2 to add mustard");
            System.out.println("Enter 3 to add ketchup");
            System.out.println("Enter 4 to add ranch");
            System.out.println("Enter 5 to add thousand islands");
            System.out.println("Enter 6 to add vinaigrette");
            System.out.println("Enter 0 when finished adding sauces");
            String choice = scanner.nextLine().trim();
            if (choice.equals("0")){
                return toppings;
            }
            switch (choice) {
                case "1":
                    toppings.add(new Topping("mayo", "sauce", false));
                    break;
                case "2":
                    toppings.add(new Topping("mustard", "sauce", false));
                    break;
                case "3":
                    toppings.add(new Topping("ketchup", "sauce", false));
                    break;
                case "4":
                    toppings.add(new Topping("ranch", "sauce", false));
                    break;
                case "5":
                    toppings.add(new Topping("thousand islands", "sauce", false));
                    break;
                case "6":
                    toppings.add(new Topping("vinaigrette", "sauce", false));
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        return toppings;
    }
}