package by.st.streamApi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiMain {
    public static void main(String[] args) {

        getMyStrings().stream()
                .filter(s -> s.startsWith("s"))
                .filter(s -> s.endsWith("4"))
                .forEach(System.out::println);

        // Напишите программу, которая создает список целых чисел, а затем использует стримы для фильтрации только четных чисел и их сортировки по возрастанию.
        getMyIntegers().stream()
                .filter(integer -> integer % 2 == 0)
                .sorted()
                .forEach(System.out::println);

        // Создайте список строк, затем используйте стримы для преобразования каждой строки в верхний регистр и сборки результатов в новый список.
        getMyStrings().stream()
                .map(String::toUpperCase)
                .toList()
                .forEach(System.out::println);

        // Напишите программу, которая использует стрим для вычисления суммы всех элементов в массиве целых чисел
        List<Integer> integers = getMyIntegers();
        int sum = integers.stream()
                .reduce(0, Integer::sum);
        System.out.println("sum " + sum);

        int[] myArray = getMyIntArray();
        int sumArrayInt = Arrays.stream(myArray)
                .reduce(0, Integer::sum);
        System.out.println("sumArrayInt " + sumArrayInt);



        // Создайте список объектов (например, объекты класса Person с полями name и age).
        Map<Integer, List<Person>> groupByAge = getMyPersons().stream()
                .collect(Collectors.groupingBy(Person::getAge));
        groupByAge.forEach(
                (age, people) -> {
                    System.out.println("age " + age);
                    people.forEach(System.out::println);
                }
        );

        // Используйте стримы для группировки объектов по возрасту и вычисления среднего возраста в каждой группе.
        Map<Integer, Double> groupingByAgeAndAveragingByAge = getMyPersons().stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.averagingInt(Person::getAge)));
        groupingByAgeAndAveragingByAge.forEach(
                (age, averagingAge) -> System.out.println("age " + age + " average " + averagingAge)
        );

        // Создайте список строк. Используйте стримы для фильтрации строк длиной более 5 символов и поиска первой строки, удовлетворяющей условию.
        getMyStrings().stream()
                .filter(s -> s.length() > 5)
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Item not found")
                );

        // Перепишите одну из предыдущих задач с использованием параллельного стрима (parallelStream()) для выполнения операций на нескольких ядрах процессора.






        // Напишите программу, которая читает текстовый файл построчно, фильтрует строки по заданному условию (например, содержащим определенное слово), и выводит результаты на консоль.
        String filePath = "/Users/sergeysterlikov/Desktop/Дз stream exception.txt";
        String keyword = "w";
        boolean[] found = {false};

        try (Stream<String> lines = Files.lines(Path.of(filePath))) {
            lines.filter(line -> line.contains(keyword))
                    .peek(line -> found[0] = true)
                    .forEach(System.out::println);
            if(!found[0]){
                System.out.println("The searched word was not found. Please try again.");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Рассмотрите ситуацию, когда стрим может содержать значения, которые не могут быть преобразованы в желаемый тип.
        // Напишите программу, которая фильтрует стрим таким образом, чтобы исключить некорректные значения и обработать такие случаи.
        // стримы



        // Удалить дубликаты
        List<Integer> districts = getMyIntegers().stream()
                .distinct()
                        .toList();
        districts.forEach(System.out::println);


        // Вывести все четные элементы в диапазоне от 7 до 17
        List<Integer> between = getMyIntegers().stream()
                .filter(e -> e % 2 == 0 && e > 7 && e < 17)
                .distinct()
                .toList();
        System.out.println(between + " between " );

        // Каждый элемент умножить на 2
        List<Integer> multiplication = between.stream()
                .map(e -> e * 2)
                .toList();
        System.out.println(multiplication + " multiplication");

        // Отсортировать и вывести на экран первых 4 элемента
        multiplication.stream()
                .sorted()
                .limit(4)
                .forEach(System.out::println);

        // Вывести количество элементов в стриме
        Long count = districts.stream().count();
        System.out.println(count + " districts count");

        // Вывести среднее арифметическое всех чисел в стриме
        Double average = districts.stream()
                .collect(Collectors.averagingDouble(Integer::doubleValue));
        System.out.println(average + " average districts");

        // Создать коллекцию класса ArrayList со значениями имен всех студентов в группе С помощью Stream:
        //- Вернуть количество людей с вашим именем (вне зависимости от верхнего/нижнего регистра букв)
        getMyPersons().stream()
                .filter(person -> person.getName().equalsIgnoreCase("sergey"))
                .forEach(System.out::println);

        // Выбрать все имена, начинающиеся на "а" (вне зависимости от верхнего/нижнего регистра букв)
        List<Person> findBy = getMyPersons().stream()
                .filter(person -> person.getName().toLowerCase().startsWith("s"))
                .toList();
        System.out.println(findBy + "findByChar");


        //Отсортировать и вернуть первый элемент коллекции или "Empty”, если коллекция пуста
        getMyPersons().stream()
                .filter(person -> person.getName().toLowerCase().startsWith("x"))
                .sorted(Comparator.comparing(Person::getName))
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Empty")
                );











    }

    public static List<String> getMyStrings() {
        return Arrays.asList("string1", "string2", "string3", "string4", "string5", "string6", "string7");
    }

    private static List<Integer> getMyIntegers() {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 1, 2, 2, 4, 1);
    }

    private static List<Person> getMyPersons() {
        return Arrays.asList(
                new Person("Nick", 20),
                new Person("Bill", 30),
                new Person("Tom", 40),
                new Person("Jack", 50),
                new Person("Micki", 50),
                new Person("Linda", 50),
                new Person("Cat", 50),
                new Person("Sergey",42),
                new Person("sergey",42)
        );
    }

    private static int[] getMyIntArray(){
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

}
