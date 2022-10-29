package realworld;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository("input.txt");
        UserService userService = new UserService(userRepository);

        userService.countOfAllUsers();
        System.out.println(userService.countOfAllUsers());
    }
}
