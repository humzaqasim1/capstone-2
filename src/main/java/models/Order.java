package models;

import java.util.ArrayList;

public class Order {
    private ArrayList<Product> products = new ArrayList<>();


    public void addProduct(Product product){
        products.add(product);
    }

    public double totalPrice(){
        double total = 0;
        for (Product p : products){
            total += p.getPrice();
        }
        return total;
    }
}
