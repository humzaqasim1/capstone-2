import UI.UserInterface;
import models.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Order order = new Order();
//        Drink drink = new Drink("Large", "cola");
//        Drink drink1 = new Drink("Large", "cola");
//        Drink drink2 = new Drink("Large", "cola");
//        Drink drink3 = new Drink("Large", "cola");
//        Drink drink4 = new Drink("Large", "cola");
//        order.addProduct(drink);
//        order.addProduct(drink1);
//        order.addProduct(drink2);
//        order.addProduct(drink3);
//        order.addProduct(drink4);
//        System.out.println(order.totalPrice());
//
//        Sandwich sandwich = new Sandwich("wheat", "4", true);
//        sandwich.addTopping(new Topping("Salami", "Meat" ));
//        sandwich.addTopping(new Topping("Salami", "Meat" ));
//        order.addProduct(sandwich);
//        System.out.println(sandwich.toString());
        UserInterface userInterface = new UserInterface();
        userInterface.displayHomeScreen();

    }
}
