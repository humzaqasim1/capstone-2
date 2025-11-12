package models;

public class Drink implements Product {
    String size;
    String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        double price = 0 ;
        if (size.equalsIgnoreCase("small")) {
            price = 2.00;
        } else if (size.equalsIgnoreCase("medium")) {
            price = 2.50;
        } else if (size.equalsIgnoreCase("large")) {
            price =  3.00;
        }
        return price;
    }

    @Override
    public String getReceipt() {
        return String.format("%s|%s|%s%.2f", flavor, size, "$", getPrice());
    }

}
