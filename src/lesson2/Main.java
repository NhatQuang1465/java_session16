package lesson2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EventManager manager = new EventManager();

        while (true) {

            System.out.println("\n===== EVENT MANAGEMENT =====");
            System.out.println("1. Add Event");
            System.out.println("2. Show Events");
            System.out.println("0. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    manager.addEvent();
                    break;

                case 2:
                    manager.showEvents();
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