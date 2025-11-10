package UI;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    public void displayHomeScreen(){
        System.out.println("Welcome to the Home Screen!");
        System.out.println("Please select an option:");
        System.out.println("Press 1 for a new order");
        System.out.println("Press 0 to exit the application");
        String choice = scanner.nextLine();
        switch (choice){
            case "1":
                displayOrderScreen();
            break;
            case "0":
                return;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void displayOrderScreen(){
        System.out.println("Welcome to the models.Order Screen!");
        System.out.println("Please select an option:");
        System.out.println("Press 1 to add sandwich");
        System.out.println("Press 2 to add drink");
        System.out.println("Press 3 to add chips");
        System.out.println("Press 4 to checkout");
        System.out.println("Press 0 to cancel order");
        String choice = scanner.nextLine();
        switch (choice){
            case "1":

        }
    }

    public void checkOut(){

    }

    public void displayReceipt(){

    }

//        public void meat(){
//            System.out.println("Select meat:");
//            System.out.println("Press 1 for steak");
//            System.out.println("Press 2 for ham");
//            System.out.println("Press 3 for salami");
//            System.out.println("Press 4 for roast beef");
//            System.out.println("Press 5 for chicken");
//            System.out.println("Press 6 for bacon");
//            System.out.println("Press 7 to add extra meat");
//            String choice = scanner.nextLine();
//
//        }
//        public void cheese(){
//            System.out.println("Select cheese:");
//            System.out.println("Press 1 for american");
//            System.out.println("Press 2 for provolone");
//            System.out.println("Press 3 for cheddar");
//            System.out.println("Press 4 for swiss");
//            System.out.println("Press 5 to add extra cheese");
//            String choice = scanner.nextLine();
//        }
//
//        public void lettuce(){
//            System.out.println("Do you want lettuce?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void peppers(){
//            System.out.println("Do you want peppers?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void onions(){
//            System.out.println("Do you want onions?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void tomatoes(){
//            System.out.println("Do you want tomatoes?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void jalapenos(){
//            System.out.println("Do you want jalapeños?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void cucumbers(){
//            System.out.println("Do you want cucumbers?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void pickles(){
//            System.out.println("Do you want pickles?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void guacamole(){
//            System.out.println("Do you want guacamole?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//
//        public void mushrooms(){
//            System.out.println("Do you want mushrooms?");
//            System.out.println("Enter Y or N:");
//            String choice = scanner.nextLine();
//        }
//    }

}
