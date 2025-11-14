package models;

import java.util.ArrayList;

public class Sandwich implements Product {

    String breadType;
    String breadLength;
    ArrayList<Topping> toppings;
    boolean toasted;
    double totalSandwichPrice = getTotalSandwichPrice();
    double basePrice;
    ArrayList<Topping> meats;
    ArrayList<Topping> cheeses;
    ArrayList<Topping> sauces;
    public Sandwich(String breadType, String breadLength, boolean toasted, ArrayList<Topping> toppings, ArrayList<Topping> meats, ArrayList<Topping> cheeses, ArrayList<Topping> sauces) {
        this.breadType = breadType;
        this.breadLength = breadLength;
        this.toasted = toasted;
        this.toppings = toppings;
        this.meats = meats;
        this.cheeses = cheeses;
        this.sauces = sauces;
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
    public double getMeatPrice(){
        double meatPrice = 0;
        for (Topping meat: meats){
           meatPrice = meat.toppingPrice(breadLength);
        }
        return meatPrice;
    }
    public double getCheesePrice(){
        double cheesePrice = 0;
        for (Topping cheese: cheeses){
            cheesePrice = cheese.toppingPrice(breadLength);
        }
        return cheesePrice;
    }
    public double getTotalSandwichPrice() {
        return basePrice + getMeatPrice() + getCheesePrice();
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
        return String.format("%s|%s%s|%s%s|%s|%s|%s|%s|%s%s", breadType, breadLength, "\"", "toasted: ", toasted, toppings, meats, cheeses, sauces, "$",totalSandwichPrice);
    }
}
