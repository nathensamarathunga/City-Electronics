import java.util.Objects;
import java.util.Scanner;

class Main {

    public static boolean loginState = false;

    public static String[][] userCredentials = {{"null", "null"}};

    public static Scanner input = new Scanner(System.in);

    public static int i;

    public static void loginPage() {
        int valid = 1;
        int option = 0;

        System.out.println("--------------------------------------------------------");
        System.out.println("\t\t\tWelcome to City Electronics!");
        System.out.println("--------------------------------------------------------");
        System.out.println("\nCustomer Login\t- 1 \nEmployee Login\t- 2");

        while (valid == 1) {
            System.out.print("\nSelect Login Option\t: ");
            option = input.nextByte();
            if (option == 1 || option == 2) {
                valid = 2;
                if (option == 1)
                    customerCheckLogin();
                else
                    employeeCheckLogin();
            }
            else
                System.out.println("Invalid Input");
        }
    }

    public static void customerCheckLogin(){

        i = 0;

        String check;

        String[][] users = { {"Ranil", "Ranil@123"}, {"Kamal", "Kamal@123"}, {"Mahinda", "Mahinda@123"} };

        System.out.println("Customer Login Under Construction");

        System.out.print("Enter Username\t: ");
        userCredentials[0][0] = input.next();

        System.out.print("Enter Password\t: ");
        userCredentials[0][1] = input.next();

        while ((loginState == false) && i < 2) {

            if ((Objects.equals(users[i][0], userCredentials[0][0])) && (Objects.equals(users[i][1], userCredentials[0][1]))) {
                loginState = true;
                break;
            }
            else
                i++;
        }

        if (loginState == false) {
            System.out.println("Invalid Login Information");
            System.out.println("Do you want to try again? (Y/N)\t: ");
            check = input.next();

            if (check == "Y")
                customerCheckLogin();
            else
                loginPage();

        } else {
            System.out.println("Successfully Logged In!");
            customerActions();
        }



    }

    public static void employeeCheckLogin(){

        i = 0;

        String check;

        String[][] users = { {"Admin", "Ad@123"}, {"Manager", "Mgr@123"}, {"Employee", "Emp@123"} };

        System.out.println("Employee Login Under Construction");

        System.out.print("Enter Username\t: ");
        userCredentials[0][0] = input.next();

        System.out.print("Enter Password\t: ");
        userCredentials[0][1] = input.next();

        while ((loginState == false) && i < 2) {

            if ((Objects.equals(users[i][0], userCredentials[0][0])) && (Objects.equals(users[i][1], userCredentials[0][1]))) {
                loginState = true;
                break;
            }
            else
                i++;
        }

        if (loginState == false) {
            System.out.println("Invalid Login Information");
            System.out.println("Do you want to try again? (Y/N)\t: ");
            check = input.next();

            if (check == "Y")
                employeeCheckLogin();
            else
                loginPage();

        } else {
            System.out.println("Successfully Logged In!");
            employeeActions();
        }
    }

    public static void customerActions() {

    }

    public static void employeeActions() {

    }

    public static void main(String args[]){

        loginPage();

    }
}