package lesson5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Quang", "IT", 8.5),
                new Student("Nam", "IT", 7.8),
                new Student("Lan", "Business", 8.0),
                new Student("Hoa", "Business", 7.5),
                new Student("Minh", "IT", 9.0),
                new Student("Tuan", "Marketing", 8.2),
                new Student("Huong", "Marketing", 7.9),
                new Student("Linh", "Marketing", 8.4),
                new Student("Dat", "Finance", 7.6),
                new Student("Mai", "Finance", 8.1)
        );

        Map<String, Long> statistics =
                students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getMajor,
                                Collectors.counting()
                        ));

        System.out.println("===== THỐNG KÊ SINH VIÊN THEO CHUYÊN NGÀNH =====");

        statistics.entrySet()
                .stream()
                .sorted((e1, e2) ->
                        Long.compare(e2.getValue(), e1.getValue()))
                .forEach(entry ->
                        System.out.println(
                                "Chuyên ngành: "
                                        + entry.getKey()
                                        + " - Số lượng: "
                                        + entry.getValue()
                        ));
    }
}