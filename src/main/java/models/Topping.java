package models;

public class Topping {
    private String name;
    private String type;
    private boolean extra;

    public Topping(String name, String type, boolean extra) {
        this.name = name;
        this.type = type;
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isExtra() {
        return extra;
    }

    public double toppingPrice(String breadLength) {
        double price = 0;
        if (type.equalsIgnoreCase("meat")) {
            if (breadLength.equalsIgnoreCase("4")) {
                price = 1.00;
            } else if (breadLength.equalsIgnoreCase("8")) {
                price = 2.00;
            } else if (breadLength.equalsIgnoreCase("12")) {
                price = 3.00;
            }
            if (extra) {
                if (breadLength.equalsIgnoreCase("4")) {
                    price += 0.50;
                } else if (breadLength.equalsIgnoreCase("8")) {
                    price += 1.00;
                } else if (breadLength.equalsIgnoreCase("12")) {
                    price += 1.50;
                }
            }
            if (type.equalsIgnoreCase("cheese")) {
                if (breadLength.equalsIgnoreCase("4")) {
                    price = 0.75;
                } else if (breadLength.equalsIgnoreCase("8")) {
                    price = 1.50;
                } else if (breadLength.equalsIgnoreCase("12")) {
                    price = 2.25;
                }
                if (extra) {
                    if (breadLength.equalsIgnoreCase("4")) {
                        price += 0.30;
                    } else if (breadLength.equalsIgnoreCase("8")) {
                        price += 0.60;
                    } else if (breadLength.equalsIgnoreCase("12")) {
                        price += 0.90;
                    }
                }
            }
            if (type.equalsIgnoreCase("regular") || type.equalsIgnoreCase("sauce")){
                price = 0;
            }
        } return price;
    }

    @Override
    public String toString() {
        if (extra){
            return name + "+extra";
        } else{
            return name;
        }
    }
}