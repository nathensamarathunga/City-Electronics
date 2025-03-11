import java.util.Objects;
import java.util.Scanner;


class Products {

    public static Scanner input = new Scanner(System.in);
    public static String[] productName = {"Refrigerator", "Washing Machine", "Electric Kettle", "Electric Mixer", "Electric Stove"};
    public static int[] productPrice = {175000, 60000, 74000, 12000,  25000};

    public static int[] productsChosen = {0, 0, 0, 0, 0, 0, 0, 0};

    public static int productCount = 5, productNumber = 1, position = 0, totalPrice = 0;

    public static void productsTable() {

        System.out.println("\n\n\n\n\n\n\n\n\n\n--------------------------------------------------------");
        System.out.println("\t\t\tProduct List");
        System.out.println("--------------------------------------------------------");
        System.out.println("Product\t\t \t\t|\tPrice");
        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < productCount; i++) {

            System.out.println((i+1) + ". " + productName[i] + "\t\t-\t" + productPrice[i]);

        }

    }

    public static void cartFunction() {

        int i = 0, y = 0;

        System.out.println("Add products to cart");
        System.out.println("--------------------------------------------------------");

        System.out.println("Enter 1 product number at a time and hit enter \nTo exit enter '0'");

        while ((productNumber != 0) || (y < productCount)) {

            System.out.print("Selection " + ++i + " : ");
            productNumber = input.nextInt();

            if (productNumber == 0)
                break;
            else {

                productsChosen[productNumber - 1] = 1;

            }

            y++;

        }

    }

    public static void priceCalculation() {

        for (int i = 0; i < productCount; i++) {

            totalPrice += (productPrice[i] * productsChosen[i]);

        }

        System.out.println("--------------------------------------------------------");
        System.out.println("Your bill is,");

        for (position = 0; position < productCount; position++) {

            if (productsChosen[position] == 1 ) {

                System.out.println((position+1) + ". " + productName[position] + "\t\t-\t" + productPrice[position]);

            }

        }

        System.out.println("LKR." + totalPrice);


    }

}
class Main {

    public static boolean loginState = false;

    public static String[][] userCredentials = {{"null", "null"}};

    public static Scanner input = new Scanner(System.in);

    public static int i;

    public static int loginPage() {
        int option;
        String check;

        System.out.println("--------------------------------------------------------");
        System.out.println("\t\t\tWelcome to City Electronics!");
        System.out.println("--------------------------------------------------------");
        System.out.println("\nCustomer Login\t- 1 \nEmployee Login\t- 2");

        while (true) {

            System.out.print("\nSelect Login Option\t: ");
            option = input.nextByte();

            if (option == 1 || option == 2) {
                break;
            }
            else
                System.out.println("Invalid Input");
        }

        checkLogin(option);

        while (!loginState) {

            System.out.println("Invalid Login Information");
            System.out.println("Do you want to try again? (Y/N)\t: ");
            check = input.next();

            if (check.equalsIgnoreCase("Y"))
                checkLogin(option);
            else
                loginPage();
        }

        System.out.println("Welcome " + userCredentials[0][0] + ", You're Successfully Logged In!");

        return option;
    }

    public static void checkLogin(int option) {
        i = 0;

        String[][] customersCredentials = { {"Ranil", "Ranil@123"}, {"Kamal", "Kamal@123"}, {"Mahinda", "Mahinda@123"} };
        String[][] employeeCredentials = { {"Admin", "Ad@123"}, {"Manager", "Mgr@123"}, {"Employee", "Emp@123"} };

        System.out.println("\n--------------------------------------------------------");
        System.out.print("Enter Username\t: ");
        userCredentials[0][0] = input.next();

        System.out.print("Enter Password\t: ");
        userCredentials[0][1] = input.next();
        System.out.println("--------------------------------------------------------");


        while ((!loginState) && i < 3) {

            if (option == 1) {
                if ((Objects.equals(customersCredentials[i][0], userCredentials[0][0])) && (Objects.equals(customersCredentials[i][1], userCredentials[0][1]))) {
                    loginState = true;
                    break;
                } else
                    i++;
            } else {
                if ((Objects.equals(employeeCredentials[i][0], userCredentials[0][0])) && (Objects.equals(employeeCredentials[i][1], userCredentials[0][1]))) {
                    loginState = true;
                    break;
                }
                else
                    i++;
            }

        }

    }

    public static void customerActions() {

        Products.productsTable();
        Products.cartFunction();
        Products.priceCalculation();

    }

    public static void employeeActions() {

        System.out.println("Welcome Employee");

    }

    public static void main(String []args){

        int option = loginPage();

        if (option == 1)
            customerActions();
        else
            employeeActions();


    }
}