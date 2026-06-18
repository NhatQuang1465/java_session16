package lesson3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatManager {

    private List<Message> messages = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void sendMessage() {

        System.out.print("Nhập tên người gửi: ");
        String sender = sc.nextLine();

        System.out.print("Nhập nội dung tin nhắn: ");
        String content = sc.nextLine();

        messages.add(
                new Message(
                        sender,
                        content,
                        LocalDateTime.now()
                )
        );

        System.out.println("Tin nhắn đã được gửi!");
    }

    public void showHistory() {

        if (messages.isEmpty()) {
            System.out.println("Chưa có tin nhắn nào!");
            return;
        }

        System.out.println("\n===== CHAT HISTORY =====");

        messages.forEach(System.out::println);
    }

    public void filterBySender() {

        System.out.print("Nhập tên người gửi cần tìm: ");
        String sender = sc.nextLine();

        System.out.println("\nKết quả:");

        messages.stream()
                .filter(m -> m.getSender()
                        .equalsIgnoreCase(sender))
                .forEach(System.out::println);
    }

    public void filterByDate() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {

            System.out.print("Nhập ngày cần tìm (dd/MM/yyyy): ");
            String input = sc.nextLine();

            LocalDate date =
                    LocalDate.parse(input, formatter);

            System.out.println("\nKết quả:");

            messages.stream()
                    .filter(m ->
                            m.getTimestamp()
                                    .toLocalDate()
                                    .equals(date))
                    .forEach(System.out::println);

        } catch (DateTimeParseException e) {

            System.out.println(
                    "Invalid date format! Use dd/MM/yyyy");
        }
    }
}