package example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {

    List<User> users = new ArrayList<>();

    users.add(new User("Marsel", 35));
    users.add(new User("Yunus", 22));
    users.add(new User("Ali", 27));
    users.add(new User("Omar", 44));
    users.add(new User("Zanga", 11));
    users.add(new User("Langa", 31));
    users.add(new User("Dov", 20));

    long count = users.stream().filter(user -> user.getAge() > 30).count();

    System.out.println(users.stream().noneMatch(user -> user.getAge() > 50));

    users.stream().sorted((u1, u2) -> Integer.compare(u2.getAge(), u1.getAge())).limit(3)
        .forEach(System.out::println);


    users.stream().sorted(Comparator.comparing(User::getName)).filter(user -> user.getAge() < 40)
        .limit(3).map(User::getName).forEach(System.out::println);

    System.out.println(count);


    Optional<User> user = users.stream().max(Comparator.comparingInt(User::getAge));
    user.ifPresentOrElse(System.out::println, () -> System.out.println("user not found"));

    users.stream()
        .filter(user1 -> user1.getName().contains("l"))
        .findFirst()
        .ifPresentOrElse(System.out::println, () -> System.out.println("User not fount"));


    int[] arr = {12, 434, 23, 323, 5, 1, 6, 3, 6,};
    Arrays.stream(arr)
        .filter(el -> el > 5)
        .forEach(System.out::println);

    Stream.of(1, 3, 4, 5, 6, 32, 124, 1243, 12);

  }


}