package models;

import java.util.ArrayList;

public class Sandwich implements Product {

    String breadType;
    String breadLength;
    ArrayList<Topping> toppings = new ArrayList<>();
    boolean toasted;

    public Sandwich(String breadType, String breadLength, boolean toasted) {
        this.breadType = breadType;
        this.breadLength = breadLength;
        this.toasted = toasted;
    }

    public double sandwichBasePrice(String breadLength){
        double price = 0;
        if (breadLength.equalsIgnoreCase("4")){
            price = 5.50;
        } else if (breadLength.equalsIgnoreCase("8")){
            price = 7.00;
        } else if (breadLength.equalsIgnoreCase("12")){
            price = 8.50;
        }
        return price;
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getReceipt() {
        return "";
    }
}
