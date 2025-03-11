import java.util.Objects;
import java.util.Scanner;

class Main {

    public static boolean loginState = false;

    public static String[][] userCredentials = {{"null", "null"}};

    public static Scanner input = new Scanner(System.in);

    public static int i, option;

    public static void loginPage() {
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

            if (Objects.equals(check, "Y"))
                checkLogin(option);
            else
                loginPage();
        }

        System.out.println("Welcome " + userCredentials[0][0] + ", You're Successfully Logged In!");

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

        System.out.println("Welcome Customer");

    }

    public static void employeeActions() {

        System.out.println("Welcome Employee");

    }

    public static void main(String []args){

        loginPage();

        if (option == 1)
            customerActions();
        else
            employeeActions();


    }
}