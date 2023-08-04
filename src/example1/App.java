package example1;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<User> users = UserGenerator.getRandomUser(20);

        printAll(users);
        System.out.println("******************************************************************");
        printGreaterThan30(users);
        System.out.println("******************************************************************");
        printEvenAge(users);
        System.out.println("******************************************************************");
        printEvenAndGreaterThan30(users);
        System.out.println("******************************************************************");
        printEvenOrGreaterThan30(users);;
        System.out.println("******************************************************************");
        printUserNameWithCityAndAge(users);
        System.out.println("******************************************************************");
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(-1, -2, 1, 1, 2, 3, 4, 2, 1));
        distinctNumber(numbers);
        System.out.println("******************************************************************");
        sortUsersByAgeAsc(users);
        System.out.println("******************************************************************");
        sortUsersByAgeDesc(users);
        System.out.println("Yaşı 30'dan büyük olanların yaşları toplamı reduce : " + sumWithReduce(users));
        System.out.println("Yaşı 30'dan büyük olanların yaşları toplamı Int sum : " + sumWithInt(users));
        System.out.println("Yaşı 30'dan büyük olanların yaşları toplamı Math : " + sumWithMath(users));
        System.out.println("******************************************************************");
        System.out.println("Yaşadığı şehrin karakter sayısı ile yaşı toplamı çift olanlardan yeni liste : " + listOfLettersOfCityPlusAgesEquealEven(users));
        System.out.println("******************************************************************");
        System.out.println("Soyadlarına göre sıralandıktan sonra ilk 2 eleman : " + listOfSortedByLastName(users));
    }

    private static List<User> listOfSortedByLastName(List<User> users) {
        Collator collator = Collator.getInstance(new Locale("tr", "TR"));

        return users.stream()
                .sorted(Comparator.comparing(User::getLastName, collator).reversed())
                .limit(2)
                .collect(Collectors.toList());
    }

    private static List<Integer> listOfLettersOfCityPlusAgesEquealEven(List<User> users) {
        return users.stream()
                .map(u -> u.getCity().length() + u.getAge())
                .collect(Collectors.toList());
    }

    private static int sumWithMath(List<User> users) {
        return users.stream()
                .map(u -> u.getAge())
                .reduce(0, Math::addExact);
    }

    private static int sumWithInt(List<User> users) {
        return users.stream()
                .map(u -> u.getAge())
                .reduce(0, Integer::sum);
    }

    private static int sumWithReduce(List<User> users) {
        return users.stream()
                .map(User::getAge)
                .reduce((x, y) -> x + y)
                .orElse(0);
    }

    private static void sortUsersByAgeDesc(List<User> users) {
        users.stream()
                .sorted(Comparator.comparing(User::getAge).reversed())
                .forEach(System.out::println);
    }

    private static void sortUsersByAgeAsc(List<User> users) {
        users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .forEach(System.out::println);
    }

    private static void distinctNumber(ArrayList<Integer> numbers) {
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
    }


    private static void printUserNameWithCityAndAge(List<User> users) {
        users.stream()
                .map(u -> String.format("%s %s. - %s %d", u.getName(), u.getLastName().charAt(0), u.getCity(), u.getAge()))
                .forEach(System.out::println);
    }

    private static void printEvenOrGreaterThan30(List<User> users) {
        users.stream()
                .filter(u -> u.getAge() % 2 == 0 || u.getAge() > 30)
                .forEach(System.out::println);
    }

    private static void printEvenAndGreaterThan30(List<User> users) {
        users.stream()
                .filter(u -> u.getAge() % 2 == 0 && u.getAge() > 30)
                .forEach(System.out::println);
    }

    private static void printEvenAge(List<User> users) {
        users.stream()
                .filter(u -> u.getAge() % 2 == 0)
                .forEach(System.out::println);
    }

    private static void printGreaterThan30(List<User> users) {
        users.stream()
                .filter(u -> u.getAge() > 30)
                .forEach(System.out::println);
    }

    private static void printAll(List<User> users) {
        users.stream()
                .forEach(System.out::println);
    }

}
