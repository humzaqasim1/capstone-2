package models;

import java.util.ArrayList;

public class Sandwich implements Product {

    String breadType;
    String breadLength;
    ArrayList<Topping> toppings;
    boolean toasted;
    double totalPrice;
    double basePrice;
    ArrayList<Topping> meats;
    ArrayList<Topping> cheeses;

    public Sandwich(String breadType, String breadLength, boolean toasted, ArrayList<Topping> toppings, ArrayList<Topping> meats, ArrayList<Topping> cheeses) {
        this.breadType = breadType;
        this.breadLength = breadLength;
        this.toasted = toasted;
        this.toppings = toppings;
        this.meats = meats;
        this.cheeses = cheeses;
        this.basePrice = sandwichBasePrice(this.breadLength);
    }

    public double sandwichBasePrice(String breadLength){
        double basePrice = 0;
        if (breadLength.equalsIgnoreCase("4")){
            basePrice = 5.50;
        } else if (breadLength.equalsIgnoreCase("8")){
            basePrice = 7.00;
        } else if (breadLength.equalsIgnoreCase("12")){
            basePrice = 8.50;
        }
        return basePrice;
    }

//    public void addTopping(Topping topping){
//        toppings.add(topping);
//    }

    @Override
    public double getPrice() {
        return 0;
    }

    public ArrayList<Topping> getCheeses() {
        return cheeses;
    }

    public ArrayList<Topping> getMeats() {
        return meats;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isToasted() {
        return toasted;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public String getBreadLength() {
        return breadLength;
    }

    public String getBreadType() {
        return breadType;
    }

    @Override
    public String getReceipt() {
        return "";
    }

    public String toString(){
        return String.format("%s|%s|%b|%.2f", breadType, breadLength, toasted, basePrice);
    }
//    public Sandwich(String breadType, String breadLength, boolean toasted) {

    // store bread type (white, wheat, rye, wrap)
    // store sandwich size (4, 8, or 12 inches)
    // store if sandwich is toasted
    // store meats, cheeses, toppings, sauces
    // keep track of total price

    // constructor: takes bread type, size, toasted
    //   - initialize properties
    //   - set base price based on size

    // addMeat method:
    //   - add meat(s)
    //   - what is the price based on size and whether it's extra?

    // addCheese method:
    //   - add cheese(s)
    //   - add price depending on size and whether it's extra

    // addTopping method:
    //   - add topping(s)
    //   - no charge

    // addSauce method:
    //   - add sauce(s)
    //   - no charge

    // getPrice method:
    //   - return current total price

    // getSummary method:
    //   - return a string with all sandwich details and price
}
