package models;

import java.util.ArrayList;

public class Sandwich implements Product {

    String breadType;
    String breadLength;
    boolean toasted;
    ArrayList<Topping> toppings;
    ArrayList<Topping> meats;
    ArrayList<Topping> cheeses;
    ArrayList<Topping> sauces;
    double basePrice;
    double totalSandwichPrice;
    public Sandwich(String breadType, String breadLength, boolean toasted, ArrayList<Topping> toppings, ArrayList<Topping> meats, ArrayList<Topping> cheeses, ArrayList<Topping> sauces) {
        this.breadType = breadType;
        this.breadLength = breadLength;
        this.toasted = toasted;
        this.toppings = toppings;
        this.meats = meats;
        this.cheeses = cheeses;
        this.sauces = sauces;
        this.basePrice = sandwichBasePrice(this.breadLength);
        this.totalSandwichPrice = getPrice();
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
    @Override
    public double getPrice() {
        return basePrice + getMeatPrice() + getCheesePrice();
    }

    public String isToasted() {
        if(toasted){
            return "toasted";
        } else {
            return "not toasted";
        }
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
        return String.format("%s%s|%s%s|%s|%s|%s|%s|%s|%s%s","Sandwich - ", breadType, breadLength, "\"", isToasted(), toppings, meats, cheeses, sauces, "$",totalSandwichPrice);
    }
}
