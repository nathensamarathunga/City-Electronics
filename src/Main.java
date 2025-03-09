import java.util.Scanner;

class Main {

    public static boolean loginState = false;

    public static void loginPage() {
        Scanner input = new Scanner(System.in);
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
        String[][] users = { {"Ranil", "Ranil@123"}, {"Kamal", "Kamal@123"}, {"Mahinda", "Mahinda@123"} };

        System.out.println("Customer Login Under Construction");

    }

    public static void employeeCheckLogin(){
        String[][] users = { {"Admin", "Ad@123"}, {"Manager", "Mgr@123"}, {"Employee", "Emp@123"} };

        System.out.println("Employee Login Under Construction");
    }

    public static void customerActions() {

    }

    public static void employeeActions() {

    }

    public static void main(String args[]){

        loginPage();

    }
}