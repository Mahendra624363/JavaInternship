import java.util.*;
import java.io.*;

class ExpenseManager {
    void saveDetails(String user) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date:");
        String date = sc.nextLine();
        System.out.println("Enter category:");
        String category = sc.nextLine();
        System.out.println("Enter amount:");
        double amount = sc.nextDouble();
        sc.nextLine(); // Consume newline character after nextDouble()

        String data = "\nDate: " + date +"\tCategory:" + category + "\tAmount: " + amount;
        String fileName = user + ".txt";

        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(data);
            System.out.println("Expense details saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving expense details: " + e.getMessage());
        }
    }

    void getDetails(String user) {
        String fileName = user + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading expense details: " + e.getMessage());
        }
    }
}

public class Expense {
    public static void main(String[] args) {
        ExpenseManager obj = new ExpenseManager();
        Scanner sc = new Scanner(System.in);
        String name, pass;

        HashMap<String, String> userpass = new HashMap<>();

        System.out.println("Enter 1 for sign in\n2 for Sign up");
        int option = sc.nextInt();
        sc.nextLine(); // Consume newline character after nextInt()

        System.out.println("Enter Username:");
        name = sc.nextLine();

        System.out.println("Enter Password:");
        pass = sc.nextLine();

        if (option == 2) {
            userpass.put(name, pass);
        }

        if (userpass.containsKey(name) && userpass.get(name).equals(pass)) {
            while (true) {
                System.out.println("\n1. Add Expenses\n2. Get Details\n3. Exit");
                option = sc.nextInt();
                sc.nextLine(); // Consume newline character after nextInt()

                switch (option) {
                    case 1:
                        obj.saveDetails(name);
                        break;
                    case 2:
                        obj.getDetails(name);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid login details.");
        }
    }
}

