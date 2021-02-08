import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 This program allows a user to order pizza(s)
 */

public class PizzaOrder {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);    //Create a Scanner object to read input
        boolean discount = false;            // flag, true if user is eligible for discount
        char choice;                        // user's choice
        String input;                        // user input
        String[] orders = new String[10];    // full info about order(s)
        int numOfOrders = 0;                // number of pizzas ordered

        // Welcome message
        System.out.println("====================================");
        System.out.println("Welcome to \"Eat&Chat\" Pizza Order!");
        System.out.println("====================================");

        System.out.print("Today is: ");
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date today = new Date();
        System.out.print(formatter.format(today));// prints current date (today)
        System.out.println();
        System.out.print("> Is it your BIRTHDAY? (10% discount available on presenting ID)  (Y/N):  ");
        input = keyboard.nextLine();

// TASK-1: Discount	Eligibility
        // Determine if user is eligible for discount by having birthday today
        // ADD LINES HERE
        if (input.equalsIgnoreCase("Y"))
            discount = true;

        orders[numOfOrders++] = orderPizza();    // get first order
        previewOrder(orders);    // view order info

// TASK-2: Repeated Menu Options
        // Keep displaying the menu options until user is done
        // ADD LINES HERE, modify the code below if necessary

        printMenu();    // print action menu options

        input = keyboard.nextLine();
        choice = input.charAt(0);
        String yanki = "A";
        String gringo = "A";
        while (yanki.equals("A")) {
            if (gringo.equals("B")) {
                printMenu();
                input = keyboard.nextLine();
                choice = input.charAt(0);

            }
            switch (choice) {
                // Complete order
                case '1':
                    confirmOrder(orders, discount);            // complete order
                    yanki = "B";
                    break;

                // Add another pizza
                case '2':
                    orders[numOfOrders++] = orderPizza();    // save new order
                    previewOrder(orders);                    // view order info
                    break;

                // Exit
                case '3':
                    System.out.println("Good bye!");
                    System.exit(0);                            // exit program

                default:
                    System.exit(0);

            }
            gringo = "B";
        }

    }

    /**
     * Prints the action menu
     */
    public static void printMenu() {
        //prompt user for the next operation
        System.out.println("------------MENU-------------");
        System.out.println("1 - Complete");
        System.out.println("2 - Add another order");
        System.out.println("3 - Exit");
        System.out.print("> Choose one of the above (Enter a number): ");
    }

    /**
     * The method is used to order one single pizza.
     * Gets user preferences, saves all the detailed info as one String, and returns it.
     */
    public static String orderPizza() {
        Scanner keyboard = new Scanner(System.in);
        String input;                    //user input
        char choice;                    //user's choice
        int size;                    //size of the pizza
        int cost = 0;                    //cost of the pizza
        int numberOfToppings = 0;        //number of toppings
        String toppings = "Cheese";    //list of toppings
        String result = "";                // resultant String object to be returned
        final int toppingCost = 200;    // cost for one topping

        //prompt user and get pizza size choice
        System.out.println("-----------------------------");
        System.out.println("Pizza Size (cm)      Cost");
        System.out.println("       20            1000 T");
        System.out.println("       30            1500 T");
        System.out.println("       40            2000 T");
        System.out.println("What size pizza would you like?");
        System.out.print("> 20, 30, or 40 (enter the number only): ");
        size = keyboard.nextInt();
        int razm = size;
        if (razm == 20) {
            cost = 1000;
        } else if (razm == 30) {
            cost = 1500;
        } else if (razm == 40) {
            cost = 2000;
        }

// TASK-3: Set Price
        // Set the price based on the size of pizza ordered
        // ADD LINES HERE

        //consume the remaining newline character
        keyboard.nextLine();

        //prompt user and get topping choices one at a time
        System.out.println("-----------------------------");
        System.out.println("All pizzas come with cheese.");
        System.out.println("Additional toppings are 200T each," + " choose from:");
        System.out.println("- Meat, Sausage, Vegetables, Mushroom");

        //if topping is desired, add to topping list and number of toppings
        System.out.print("> Do you want Meat?  (Y/N):  ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings += 1;
            toppings = toppings + " + Meat";
        }
        System.out.print("> Do you want Sausage?  (Y/N):  ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings += 1;
            toppings = toppings + " + Sausage";
        }
        System.out.print("> Do you want Vegetables?  (Y/N):  ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings += 1;
            toppings = toppings + " + Vegetables";
        }
        System.out.print("> Do you want Mushroom?  (Y/N):  ");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'Y' || choice == 'y') {
            numberOfToppings += 1;
            toppings = toppings + " + Mushroom";
        }

// TASK-4: Toppings Cost
        // Add additional toppings cost to cost of pizza
        // ADD LINES HERE
        cost = cost + (numberOfToppings * 200);
        //save the order information
        result += size + "cm pizza, " + toppings;
        // add the cost to result
        result += ":" + cost;
        return result;
    }

    /**
     * Processes the orders array, prints full info about each order and the total cost at the end
     */
    public static void previewOrder(String[] orders) {
        System.out.println("-----------------------------");
        System.out.println("Your order: ");

// TASK-5: Order Info
        // Print individual order info
        // ADD LINES HERE, modify the code below

        for (int zakaz = 0; zakaz < orders.length && orders[zakaz] != null; zakaz++) {
            System.out.println(zakaz + 1 + ") " + orders[zakaz]);
        }
        // print total cost
        System.out.println("Total: " + getTotalCost(orders) + " T");
    }

// TASK-6: Total Cost
    // Implement the method below

    /**
     * Parses the orders array to calculate the total cost
     */
    public static int getTotalCost(String[] orders) {
        // return total cost

        String ZakazTOT = "";
        int ZakTOT = 0;
        for (int zakaz = 0; zakaz < orders.length && orders[zakaz] != null; zakaz++) {
            ZakazTOT = "";
            for (int zakazNom = orders[zakaz].length() - 4; zakazNom < orders[zakaz].length(); zakazNom++) {
                ZakazTOT = ZakazTOT + orders[zakaz].charAt(zakazNom);
            }
            ZakTOT = ZakTOT + Integer.parseInt(ZakazTOT);
        }
        return ZakTOT;
    }

    /**
     * Order confirmation: prints full order info, calculates discount (if applicable),
     * and displays other details like date, time and order ID
     */
    public static void confirmOrder(String[] orders, boolean discount) {
        final int DISCOUNT_AMOUNT = 10;    // discount amount in percentage

        //display order confirmation
        System.out.println("#############################################");
        previewOrder(orders);

        // calculate total cost
        int cost = getTotalCost(orders);

// TASK-7: Discount Calculation
        // Apply discount only if user is eligible
        // update and print the cost with discount
        // ADD LINES HERE
        int TotalCost = cost - cost / DISCOUNT_AMOUNT;
        if (discount) {
            System.out.println("-----------------------------");
            System.out.println("TOTAL with DISCOUNT (on presenting ID only!): ");
            System.out.println(TotalCost + " T");
        }
        System.out.println("-----------------------------");
        System.out.println("Your order will be ready for pickup in 30 minutes.");

        System.out.print("Date: ");
        printCurrentDate();                // prints current date

        System.out.print("\tTime: ");
        printCurrentTime();                // prints current time
        System.out.println();

        System.out.println("Order ID: " + generateCode());    // generates random ID
    }

// TASK-8: Current Date
    // Implement the method below

    /**
     * Prints the current system date in DD.MM.YYYY format
     * HINT: https://www.javatpoint.com/java-get-current-date
     */
    public static void printCurrentDate() {
        // print current date
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date today = new Date();
        System.out.print(formatter.format(today));

    }

// TASK-9: Current Time
    // Implement the method below

    /**
     * Prints the current system time in HH:MM format
     */
    public static void printCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date today = new Date();
        System.out.print(formatter.format(today));

    }

// TASK-10: Generate Code
    // Implement the method below

    /**
     * Generates a random 4-digit number and returns as a String consisting of 4 digits fills with leading zeros if necessary
     * Ex: "1097", "0083"
     */
    public static int generateCode() {
        // return 4-digit random code
        int UOOP = 0;
        String IOP = "";
        int dop = 1;
        while (dop <= 4) {

            UOOP = (int) (Math.random() * 10);
            IOP = IOP + UOOP;
            dop++;

        }
        int YEP = 0;
        YEP = Integer.parseInt(IOP);

        return YEP;
    }
}