package models;

public class Chips implements Product {
    String flavor;

    public Chips(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String getReceipt() {
        return String.format("%s|%s|%s%.2f", flavor, "chips", "$", getPrice());
    }
}
