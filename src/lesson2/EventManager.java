package lesson2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EventManager {

    private List<Event> events = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public void addEvent() {

        String name;

        do {
            System.out.print("Nhập tên sự kiện (hoặc 'exit' để thoát): ");
            name = sc.nextLine().trim();

            if (name.equalsIgnoreCase("exit")) {
                return;
            }

            if (name.isEmpty()) {
                System.out.println("Can not enter empty string");
            }

        } while (name.isEmpty());

        LocalDateTime startDate;
        LocalDateTime endDate;

        while (true) {
            try {

                System.out.print("Nhập thời gian bắt đầu (dd/MM/yyyy HH:mm): ");
                String start = sc.nextLine();

                startDate = LocalDateTime.parse(start, formatter);

                break;

            } catch (DateTimeParseException e) {
                System.out.println("Enter not valid date");
            }
        }

        while (true) {
            try {

                System.out.print("Nhập thời gian kết thúc (dd/MM/yyyy HH:mm): ");
                String end = sc.nextLine();

                endDate = LocalDateTime.parse(end, formatter);

                if (endDate.isBefore(startDate)) {
                    System.out.println("End date must be after start date");
                    continue;
                }

                break;

            } catch (DateTimeParseException e) {
                System.out.println("Enter not valid date");
            }
        }

        events.add(new Event(name, startDate, endDate));

        System.out.println("Sự kiện đã được thêm thành công!");
    }

    public void showEvents() {

        if (events.isEmpty()) {
            System.out.println("Danh sách sự kiện trống!");
            return;
        }

        System.out.println("\n===== DANH SÁCH SỰ KIỆN =====");

        for (Event event : events) {
            System.out.println(event);
        }
    }
}