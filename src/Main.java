import java.util.Objects;
import java.util.Scanner;

class Orders {
    public static String[] userNames = {"null", "null", "null", "null"};
    public static int[][][] userProductRelation = {{{1, 0, 0, 0, 0, 0, 0, 0}, {2, 0, 0, 0, 0, 0, 0, 0}}, {{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}}, {{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}}, {{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}}};
    public static int loginCount = 0;

    public static void assignUsers() {

        userNames[loginCount] = Main.userCredentials[0][0];

        for (int count = 0; count < 8; count++) {

            userProductRelation[loginCount][0][count] = Products.productsChosen[count];
            userProductRelation[loginCount][1][count] = Products.quantities[count];


        }

        loginCount++;


    }


    public static void viewOrders() {

        int[] totalPrice = {0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < loginCount; i++) {

            System.out.println("--------------------------------------------------------");
            System.out.println("Order ID\t: " + i);
            System.out.println("User\t: " + userNames[i]);
            System.out.println("--------------------------------------------------------");
            System.out.println("Product\t\t\t\t|Unit Price\t|\tQuantity");

            for(int y = 0; y < 8; y++) {

                if(userProductRelation[i][0][y] == 1){

                    System.out.println(Products.productName[y] + "\t\t|\t" + Products.productPrice[y] + "\t|\t" + userProductRelation[i][1][y]);

                    totalPrice[i] += (Products.productPrice[y] * userProductRelation[i][1][y]);


                }

            }

            System.out.println("Total Price\t: " + totalPrice[i]);
            System.out.println("--------------------------------------------------------\n");

        }

    }

}


class Products {

    public static Scanner input = new Scanner(System.in);
    public static String[] productName = {"Refrigerator", "Washing Machine", "Electric Kettle", "Electric Mixer", "Electric Stove", "null", "null"};
    public static int[] productPrice = {175000, 60000, 74000, 12000,  25000, 0, 0};
    public static int[] productsChosen = {0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] quantities = {0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] backupProductsChosen = {0, 0, 0, 0, 0, 0, 0, 0};
    public static int[] backupQuantities = {0, 0, 0, 0, 0, 0, 0, 0};
    public static int productCount = 5, position = 0, totalPrice = 0;
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

        int selectionNumber = 0, y = 0, productNumber = 0;

        System.out.println("Add products to cart");
        System.out.println("--------------------------------------------------------");

        System.out.println("Enter 1 product number at a time and hit enter \nTo exit enter '0'");

        while ((productNumber != 0) || (y < productCount)) {

            System.out.print("Selection " + (++selectionNumber) + " : ");
            productNumber = input.nextInt();

            if (productNumber == 0)
                break;
            else
                productsChosen[productNumber - 1] = 1;

            System.out.print("Select quantity of " + productName[productNumber-1] + "\t: ");
            quantities[productNumber-1] = input.nextInt();

            y++;


        }

    }

    public static void priceCalculation() {

        int billNumber = 1;

        for (int i = 0; i < productCount; i++) {

            totalPrice += (productPrice[i] * productsChosen[i] * quantities[i]);

        }

        System.out.println("--------------------------------------------------------");
        System.out.println("Your bill is,");

        for (position = 0; position < productCount; position++) {

            if (productsChosen[position] == 1 ) {

                System.out.println((billNumber) + ". " + productName[position] + "\t\t-\t" + "LKR." +productPrice[position] + " x " + quantities[position]);
                billNumber++;

            }

        }

        System.out.println("LKR." + totalPrice);
        System.out.println("--------------------------------------------------------");


    }

    public static void changeProducts() {

        productsTable();

        System.out.println("--------------------------------------------------------");
        System.out.println("Update Product List");
        System.out.println("--------------------------------------------------------");

        System.out.println("Select Option,");
        System.out.println("1 - Add");
        System.out.println("2 - Modify");
        System.out.println("3 - Remove");

        System.out.print("Your selection: ");
        int option = input.nextInt();

        switch(option) {
            case 1:
                addProduct();
                break;
            case 2:
                modifyProduct();
                break;
            case 3:
                removeProduct();
                break;
            default:
                System.out.println("Invalid Selection");
        }

        productsTable();
    }

    public static void addProduct() {

        System.out.print("New Product Name\t: ");
        productName[productCount] = input.next();

        System.out.print("New Product Price\t: ");
        productPrice[productCount] = input.nextInt();

        System.out.println("Successfully added product " + productName[productCount]);

        productCount++;

    }

    public static void modifyProduct() {

        System.out.println("Select product number to modify\t: ");
        position = input.nextInt();

        System.out.print("Enter new product name\t: ");
        productName[position-1] = input.next();

        System.out.print("Enter product price\t: ");
        productPrice[position-1] = input.nextInt();

    }

    public static void removeProduct() {

        String[] tempProductName = productName;
        int[] tempProductPrice = productPrice;
        int tempPosition;

        System.out.print("Select product to remove\t: ");
        position = input.nextInt();
        position--;

        System.out.println("Are you sure? (Y/N)\t: ");
        String choice = input.next();

        if (choice.equalsIgnoreCase("Y")) {

            for (tempPosition = position; tempPosition < (productCount-1); tempPosition++) {

                tempProductName[tempPosition] = productName[tempPosition+1];
                tempProductPrice[tempPosition] = productPrice[tempPosition+1];

            }

            productName = tempProductName;
            productPrice = tempProductPrice;

            productCount--;

        }
        else
            System.out.println("Aborted....");


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

        String[][] customersCredentials = { {"Ranil", "Ranil@123"}, {"Anura", "Anura@123"}, {"Mahinda", "Mahinda@123"} };
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
        Orders.assignUsers();
        Products.priceCalculation();
        Products.productsChosen = Products.backupProductsChosen;
        Products.quantities = Products.backupQuantities;


    }

    public static void employeeActions() {

        System.out.println("Which Action do you want to perform?,");
        System.out.println("Modify Products\t\t- 1");
        System.out.println("View Customer Orders\t\t- 2");

        System.out.print("Your selection: ");
        int activityOption = input.nextInt();

        switch(activityOption) {
            case 1:
                Products.changeProducts();
                break;
            case 2:
                Orders.viewOrders();
                break;
            default:
                System.out.println("Invalid Selection");
        }

    }

    public static void main(String []args){

        System.out.println(Orders.userProductRelation[0][0][0]);
        System.out.println(Orders.userProductRelation[0][1][0]);

        boolean exitApp = false;

        while (!exitApp) {

            int userOption = loginPage();

            if (userOption == 1)
                customerActions();
            else
                employeeActions();

            System.out.println("Do you want to exit App?");
            String choice = input.next();

            if (choice.equalsIgnoreCase("Y"))
                exitApp = true;
        }
    }
}