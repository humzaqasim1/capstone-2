package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    public ArrayList<Product> products = new ArrayList<>();
    private double totalPrice;


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
    public Order(){};

    public Order(ArrayList<Product> products, double totalPrice) {
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void getOrderSummary(){
        for (Product product: products){
            System.out.println(product.getReceipt());
        }
//        return String.format("%s%s%.2f", products, " total price: $", totalPrice);
    }
    public double getTotalPrice(){
        for (Product product: products){
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public String receiptStringBuilder(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nYour order: \n");
        for (Product product: products){
            stringBuilder.append(product.getReceipt()).append("\n");
        }
        return stringBuilder.toString();
    }
//    public String toString(){
//        return String.format("%s%s%.2f", products, " total price: $", totalPrice);
//    }
    // create List for order items (sandwiches, drinks, and chips)
    // store total price

    // constructor:
    //   - initialize the class propeties

    // addSandwich method:
    //   - add sandwich to list

    // addDrink method:
    //   - add drink to list

    // addChips method:
    //   - add chips to list

    // getTotal method:
    //   - return total price of order

    // getSandwiches, getDrinks, getChips:
    //   - return the orders items

    // getOrderSummary method:
    //   - return formatted string of all items and total
}
