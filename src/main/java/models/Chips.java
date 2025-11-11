package models;

public class Chips implements Product {
    String flavor;
    double price = 2.50;

    public Chips(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        this.price = price;
        return price;
    }

    @Override
    public String getReceipt() {
        String receipt = flavor + " - $" + getPrice();
        return receipt;
    }
}
