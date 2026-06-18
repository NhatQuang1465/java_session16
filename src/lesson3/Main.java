package lesson3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChatManager manager = new ChatManager();

        while (true) {

            System.out.println("\n===== CHAT APPLICATION =====");
            System.out.println("1. Send Message");
            System.out.println("2. View Chat History");
            System.out.println("3. Filter Messages By Sender");
            System.out.println("4. Filter Messages By Date");
            System.out.println("0. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    manager.sendMessage();
                    break;

                case 2:
                    manager.showHistory();
                    break;

                case 3:
                    manager.filterBySender();
                    break;

                case 4:
                    manager.filterByDate();
                    break;

                case 0:
                    System.out.println("Program ended!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}