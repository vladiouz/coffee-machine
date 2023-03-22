package coffee;

import java.util.*;

public class CoffeeMachine {
    private Double balance;
    private Resources resources;
    private ArrayList<Beverage> beverages;

    public CoffeeMachine() {
        this.balance = 0.0;
        this.beverages = new ArrayList<Beverage>();
        this.resources = new Resources();

        boolean machine_is_on = true;

        System.out.println("Welcome to the Coffee Machine!\n");
        System.out.println("Here are the actions you can do:");
        System.out.println("1. See amount of money");
        System.out.println("2. See resources");
        System.out.println("3. See the drinks menu");
        System.out.println("4. Order a drink");
        System.out.println("5. Add a drink to the menu");
        System.out.println("6. Add resources to the machine");
        System.out.println("7. Close the machine");

        while(machine_is_on) {

            Scanner in = new Scanner(System.in);
            int action = in.nextInt();

            switch (action) {
                case 1 -> this.displayBalance();
                case 2 -> this.displayResources();
                case 3 -> this.displayBeverages();
                case 4 -> this.buyDrink();
                case 5 -> {
                    this.addBeverage();
                    System.out.println(this.beverages.get(0));
                }
                case 6 -> this.addResources();
                default -> machine_is_on = false;
            }
        }
    }

    //add a beverage to the list
    public void addBeverage() {
        Scanner in = new Scanner(System.in);
        System.out.println("How should this drink be called?");
        String name = in.nextLine();
        System.out.println("How much milk? (in ml)");
        double milk = in.nextDouble();
        System.out.println("How much water? (in ml)");
        double water = in.nextDouble();
        System.out.println("How much coffee? (in g)");
        double coffee = in.nextDouble();
        Double price = milk/100 + water/200 + coffee/50;
        Beverage newBeverage = new Beverage(name, price, milk, water, coffee);
        System.out.println(newBeverage.getName());
        this.beverages.add(newBeverage);
        System.out.println("New beverage added: " + name);
    }

    //add money to the machine
    public void pay(Double amount) {
        this.balance += amount;
        System.out.println("Transaction approved!");
    }

    //display amount of money
    public void displayBalance() {
        System.out.println("The coffee machine has $" + this.balance);
    }

    //display beverages
    public void displayBeverages() {
        if(this.beverages.isEmpty()) {
            System.out.println("No beverages. We are sorry!");
        }else {
            for(int i = 0; i < this.beverages.size(); i++) {
                System.out.println((i + 1) + ". " + this.beverages.get(i).getName());
                System.out.println("$" + this.beverages.get(i).getPrice());
            }
        }
    }

    //buy a drink
    public void buyDrink() {
        System.out.println("\nType the number of the drink you want");
        Scanner in = new Scanner(System.in);
        int typeOfDrink = in.nextInt() - 1;
        if(typeOfDrink >= this.beverages.size() || typeOfDrink < 0) {
            System.out.println("Sorry, we do not have that drink");
        } else {
            Double milkNeeded = this.beverages.get(typeOfDrink).getMilkAmount();
            Double waterNeeded = this.beverages.get(typeOfDrink).getWaterAmount();
            Double coffeeNeeded = this.beverages.get(typeOfDrink).getCoffeeAmount();
            Double price = this.beverages.get(typeOfDrink).getPrice();
            if (this.resources.checkEnoughResources(milkNeeded, waterNeeded, coffeeNeeded)) {
                System.out.println("That will be $" + price);
                this.pay(price);
                this.resources.useResources(milkNeeded, waterNeeded, coffeeNeeded);
                System.out.println("Here is your drink, enjoy it!");
            } else {
                System.out.println("Sorry, we do not have enough resources for this drink");
            }
        }
    }

    //display resources
    public void displayResources() {
        System.out.println("Resources:\n" + this.resources.getMilk() + "ml of milk");
        System.out.println(this.resources.getWater() + "ml of water\n" + this.resources.getCoffee() + "g of coffee");
    }

    //add resources
    public void addResources() {
        System.out.println("What do you want to add?\n1. milk\n2. water\n3. coffee");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if(choice > 3 || choice < 0){
            System.out.println("Sorry, wrong choice!");
        }else {
            System.out.println("How much do you want to add?");
            double amount = in.nextDouble();
            if(choice == 1) {
                this.resources.addMilk(amount);
            } else if(choice == 2) {
                this.resources.addWater(amount);
            } else {
                this.resources.addCoffee(amount);
            }
            System.out.println("Thank you!");
        }
    }
}
