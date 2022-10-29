package realworld;

public class UserService {

    private final UserRepository userRepository;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int countOfAllUsers() {
        return userRepository.findAll().size();
    }
}
