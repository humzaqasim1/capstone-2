# Capstone 2: Humza's Deli
![img_1.png](img_1.png)
## by Humza Qasim

### Description:
A Java command-line application for a sandwich shop that allows customers to build custom orders with sandwiches, drinks, and chips.
This project is a point-of-sale system for a deli/sandwich shop. Users can customize sandwiches with different breads, meats, cheeses, toppings, and sauces. The system calculates prices based on sandwich size and premium ingredients, then generates a receipt for the order.

### Features:
- Build custom sandwiches with multiple topping options
- Add drinks and chips to orders
- Automatic price calculation based on size and premium toppings
- Receipt generation and file storage
- Interactive command-line interface

### Class Diagram: 
![img_3.png](img_3.png)
### Interesting Code:
The most challenging part of this project was implementing the pricing system. Each sandwich size has a different base price, and premium toppings (meats and cheeses) also scale with size. I used a Topping class that calculates its own price based on the sandwich size, which keeps the code clean and follows object-oriented principles.
Another interesting feature is the receipt system. The ReceiptWriter class saves each order to a timestamped file, so the shop can keep track of all transactions. It was also very interesting figuring out how to ask the user for the individual sandwich toppings.

### Code Example:
````java
private void addSandwich() {
        ArrayList<Topping> meats = new ArrayList<>();
        ArrayList<Topping> cheeses = new ArrayList<>();
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<Topping> sauces = new ArrayList<>();
        System.out.println("What kind of bread would you like? White, Wheat, Rye, or Wrap");
        String breadType = scanner.nextLine().toLowerCase().trim();
        System.out.println("What bread length would you like? 4\", 8\", or 12\"");
        String breadLength = scanner.nextLine().toLowerCase().trim();
        System.out.println("Would you like it toasted? Y or N");
        String toastedChoice = scanner.nextLine().toLowerCase().trim();
        boolean toasted = false;
        if (toastedChoice.equalsIgnoreCase("y")){
            toasted = true;
        } else if (toastedChoice.equalsIgnoreCase("n")){
            toasted = false;
        }
        System.out.println("Would you like meat (premium) on your sandwich? Y or N");
        String meatChoice = scanner.nextLine().toLowerCase().trim();
        if (meatChoice.equalsIgnoreCase("y")){
            meats = addMeatMenu();
        }
        System.out.println("Would you like cheese (premium) on your sandwich? Y or N");
        String cheeseChoice = scanner.nextLine().toLowerCase().trim();
        if (cheeseChoice.equalsIgnoreCase("y")){
            cheeses = addCheeseMenu();
        }
        System.out.println("Would you like add regular (included) toppings? Y or N");
        String toppingsChoice = scanner.nextLine().toLowerCase().trim();
        if (toppingsChoice.equalsIgnoreCase("y")){
            toppings = addRegularToppingMenu();
        }
        System.out.println("Would you like add sauce (included)? Y or N");
        String sauceChoice = scanner.nextLine().toLowerCase().trim();
        if (sauceChoice.equalsIgnoreCase("y")){
            sauces = addSauceMenu();
        }
        Sandwich sandwich = new Sandwich(breadType, breadLength, toasted, toppings, meats, cheeses, sauces);
        order.addProduct(sandwich);
        System.out.println(sandwich.getReceipt());
    }
````
### Picture Example:
![img.png](img.png)
![img_2.png](img_2.png)
### Future Improvements

- Make signature sandwich options
- More DRY code
