package by.javaTr.financeAccounting.view;

import by.javaTr.financeAccounting.controller.Controller;
import by.javaTr.financeAccounting.controller.ControllerGetter;

import java.util.Scanner;

public class View {

    Controller controller = ControllerGetter.getInstance();

    public static void main(String[] args) {

        View view = new View();

        view.startMenu();

    }


    public void startMenu() {

        int choice = 0;


        while (choice != 4) {

            String[] loginAndPassword = null;
            String result;

            System.out.println("\n\n1. Registration\n2. Sign in as a user\n3. Sign in as an administrator\n4.Exit: ");
            choice = inputNumber();


            switch (choice) {
                case 1:
                    loginAndPassword = inputLoginAndPassword();
                    result = (controller.executeTask("USER_REGISTRATIONS "
                            + loginAndPassword[0] + " " + loginAndPassword[1]));
                    System.out.println(result);

                    break;

                case 2:
                    loginAndPassword = inputLoginAndPassword();
                    result = (controller.executeTask("USER_SIGN_IN "
                            + loginAndPassword[0] + " " + loginAndPassword[1]));
                    System.out.println(result);

                    if (result.equals("welcome")) {
                        userMenu(loginAndPassword[0]);
                    }

                    break;
                case 3:
                    loginAndPassword = inputLoginAndPassword();
                    result = (controller.executeTask("ADMIN_SIGN_IN "
                            + loginAndPassword[0] + " " + loginAndPassword[1]));
                    System.out.println(result);

                    if (result.equals("welcome")) {
                        adminMenu();

                    }

                    break;

                case 4:
                    break;
                default:
                    System.out.println("wrong number");
                    break;

            }
        }
    }

    public String[] inputLoginAndPassword() {

        String[] result = new String[2];
        System.out.print("Input login: ");
        result[0] = inputText();
        System.out.print("Input password: ");
        result[1] = inputText();
        return result;
    }

    public void userMenu(String login) {

        int choice = 0;


        while (choice != 11) {
            System.out.println("\n\n1. Add bill\n2. Add today bill\n3. Get bills for month\n4. Get bills by period\n" +
                    "5. Find bills by category\n6. Find fills by name\n7. Sort bills by name\n8. Sort bills by balance" +
                    "\n9. Sort bills by category\n10. Sort bills by date\n11. Sigh out: ");


            choice = inputNumber();
            String[] parameters;

            switch (choice) {

                case 1:
                    parameters = new String[4];

                    System.out.print("Input name: ");
                    parameters[0] = inputText();
                    System.out.print("Input category: ");
                    parameters[1] = inputText();
                    System.out.print("Input balance: ");
                    parameters[2] = inputText();
                    System.out.print("Input date: ");
                    parameters[3] = inputText();

                    System.out.println(controller.executeTask("ADD_BILL "
                            + parameters[0] + " " + parameters[1] + " " + parameters[2] + " " + parameters[3] + " " + login));
                    break;

                case 2:
                    parameters = new String[3];

                    System.out.print("Input name: ");
                    parameters[0] = inputText();
                    System.out.print("Input category: ");
                    parameters[1] = inputText();
                    System.out.print("Input balance: ");
                    parameters[2] = inputText();

                    System.out.println(controller.executeTask("ADD_BILL "
                            + parameters[0] + " " + parameters[1] + " " + parameters[2] + " " + "0" + " " + login));
                    break;

                case 3:
                    parameters = new String[1];

                    System.out.print("Input date: ");
                    parameters[0] = inputText();

                    System.out.println(controller.executeTask("GET_BILLS_FOR_MONTH "
                            + login + " " + parameters[0]));
                    break;

                case 4:
                    parameters = new String[2];

                    System.out.print("Input start date: ");
                    parameters[0] = inputText();
                    System.out.print("Input finish date: ");
                    parameters[1] = inputText();

                    System.out.println(controller.executeTask("GET_BILLS_FOR_PERIOD "
                            + login + " " + parameters[0] + " " + parameters[1]));
                    break;

                case 5:
                    parameters = new String[1];

                    System.out.print("Input category: ");
                    parameters[0] = inputText();

                    System.out.println(controller.executeTask("BILLS_FIND_BY_CATEGORY "
                            + parameters[0]));
                    break;

                case 6:
                    parameters = new String[1];

                    System.out.print("Input name: ");
                    parameters[0] = inputText();

                    System.out.println(controller.executeTask("BILLS_FIND_BY_NAME "
                             + parameters[0]));
                    break;

                case 7:

                    System.out.println(controller.executeTask("BILLS_SORT_BY_NAME "));
                    break;

                case 8:

                    System.out.println(controller.executeTask("BILLS_SORT_BY_BALANCE "));
                    break;

                case 9:

                    System.out.println(controller.executeTask("BILLS_SORT_BY_CATEGORY "));
                    break;

                case 10:

                    System.out.println(controller.executeTask("BILLS_SORT_BY_DATE "));
                    break;

                case 11:

                    System.out.println(controller.executeTask("USER_SIGN_OUT "));
                    break;

                default:
                    System.out.println("wrong number");
                    break;
            }


        }

    }

    public void adminMenu() {
        int choice = 0;


        while (choice != 6) {
            System.out.println("\n\n1. Add admin\n2. Delete admin\n3. Delete user\n4. Print admin list\n" +
                    "5. Print user list\n6. Sign out");


            choice = inputNumber();
            String parameter;

            switch (choice) {

                case 1:
                    String[] loginAndPassword = inputLoginAndPassword(); //admin/admin
                    System.out.println(controller.executeTask("ADMIN_REGISTRATION "
                            + loginAndPassword[0] + " " + loginAndPassword[1]));

                    break;

                case 2:
                    System.out.print("Enter login: ");
                    parameter = inputText();
                    System.out.println(controller.executeTask("DELETE_ADMIN "
                            + parameter));

                    break;

                case 3:
                    System.out.print("Enter login: ");
                    parameter = inputText();
                    System.out.println(controller.executeTask("DELETE_USER "
                            + parameter));

                    break;

                case 4:

                    System.out.println(controller.executeTask("PRINT_ADMIN_LIST "));

                    break;

                case 5:

                    System.out.println(controller.executeTask("PRINT_USERS_LIST "));

                    break;

                case 6: {
                    System.out.println(controller.executeTask("ADMIN_SIGN_OUT "));
                }
                break;

                default:
                    System.out.println("wrong number");
                    break;

            }
        }
    }

    public static String inputText() {

        Scanner in = new Scanner(System.in);

        return in.nextLine();
    }

    public static int inputNumber() {

        Scanner in = new Scanner(System.in);
        int number;

        while (!in.hasNextInt()) {
            System.out.print("add integer number: ");
            in.next();
        }

        number = in.nextInt();

        return number;
    }
}
