package realworld;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository("input.txt");


        System.out.println((userRepository.findAllByAgeGreaterThan(25).toString()));
    }
}
