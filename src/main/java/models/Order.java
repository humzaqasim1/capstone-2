package models;

import java.util.ArrayList;

public class Order {
    private ArrayList<Product> products = new ArrayList<>();
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

    public String getOrderSummary(){
        return "";
    }
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
