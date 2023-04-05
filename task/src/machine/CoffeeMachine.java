package machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        CoffeeMachine cMachine1 = new CoffeeMachine();
        Boolean exit = false;
        while (!exit) {
            System.out.println();
            String input = cMachine1.askingAction();
            System.out.println();
            switch (input) {
                case "buy" -> cMachine1.buy();
                case "fill" -> cMachine1.refillSupplies();
                case "take" -> cMachine1.takeMoney();
                case "remaining" -> cMachine1.printStats();
                case "exit" -> exit = true;
            }
        }
    }
}

public class CoffeeMachine {
    //WATER, MILK, COFFEE, COST, CUPS
    int[] espresso = {250, 0, 16, 4, 1};
    int[] latte = {350, 75, 20, 7, 1};
    int[] cappuccino = {200, 100, 12, 6, 1};

    private int waterInMachine = 400;
    private int milkInMachine = 540;
    private int coffeeInMachine = 120;
    private int moneyInMachine = 550;
    private int cupsInMachine = 9;


    Scanner scanner = new Scanner(System.in);

    public String askingAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        return scanner.next();
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String typeCoffee = scanner.next();
        switch (typeCoffee) {
            case "1" -> {
                if (waterInMachine < espresso[0]) System.out.println("Sorry, not enough water!");
                else if (milkInMachine < espresso[1]) System.out.println("Sorry, not enough milk!");
                else if (coffeeInMachine < espresso[2]) System.out.println("Sorry, not enough coffee!");
                else if (cupsInMachine < espresso[4]) System.out.println("Sorry, not enough cups!");
                else {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterInMachine -= 250;
                    coffeeInMachine -= 16;
                    moneyInMachine += 4;
                    cupsInMachine -= 1;
                }
            }
            case "2" -> {
                if (waterInMachine < latte[0]) System.out.println("Sorry, not enough water!");
                else if (milkInMachine < latte[1]) System.out.println("Sorry, not enough milk!");
                else if (coffeeInMachine < latte[2]) System.out.println("Sorry, not enough coffee!");
                else if (cupsInMachine < latte[4]) System.out.println("Sorry, not enough cups!");
                else {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterInMachine -= 350;
                    milkInMachine -= 75;
                    coffeeInMachine -= 20;
                    moneyInMachine += 7;
                    cupsInMachine -= 1;
                }

            }
            case "3" -> {
                if (waterInMachine < cappuccino[0]) System.out.println("Sorry, not enough water!");
                else if (milkInMachine < cappuccino[1]) System.out.println("Sorry, not enough milk!");
                else if (coffeeInMachine < cappuccino[2]) System.out.println("Sorry, not enough coffee!");
                else if (cupsInMachine < cappuccino[4]) System.out.println("Sorry, not enough cups!");
                else {
                    System.out.println("I have enough resources, making you a coffee!");
                    waterInMachine -= 200;
                    milkInMachine -= 100;
                    coffeeInMachine -= 12;
                    moneyInMachine += 6;
                    cupsInMachine -= 1;
                }

            }
        }
    }

    public void refillSupplies() {
        System.out.println("Write how many ml of water you want to add:");
        waterInMachine += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milkInMachine += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeInMachine += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cupsInMachine += scanner.nextInt();
    }

    public void takeMoney() {
        System.out.println("I gave you $" + moneyInMachine);
        moneyInMachine = 0;
    }

    public void printStats() {
        System.out.println(waterInMachine + " ml of water");
        System.out.println(milkInMachine + " ml of milk");
        System.out.println(coffeeInMachine + " g of coffee beans");
        System.out.println(cupsInMachine + " disposable cups");
        System.out.println("$" + moneyInMachine + " of money");
    }

    /*public void totalIngredients(int nCups) {
        System.out.println(nCups * waterForCoffee + " ml of water");
        System.out.println(nCups * milkForCoffee + " ml of milk");
        System.out.println(nCups * coffeeForCoffee + " g of coffee beans");
    }

    public void isItEnough() {

        System.out.println("Write how many ml of water the coffee machine has:");
        int totalWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int totalMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int totalCoffee = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int nCups = scanner.nextInt();

        int nCupsAvailable = Math.min(Math.min(totalWater / waterForCoffee, totalMilk / milkForCoffee), totalCoffee / coffeeForCoffee);

        if (nCups > nCupsAvailable) {
            System.out.println("No, I can make only " + nCupsAvailable + " cup(s) of coffee");
        } else if (nCups < nCupsAvailable) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (nCupsAvailable - nCups) + " more than that)");
        } else {
            System.out.println("Yes, I can make that amount of coffee");
        }
    }*/

}



