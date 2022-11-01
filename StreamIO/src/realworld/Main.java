package realworld;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository("input.txt");


        System.out.println(userRepository.findWithMinAge());
//        User user = new User("Maga", "Magomedov", 25);
//        userRepository.save(user);
    }
}
