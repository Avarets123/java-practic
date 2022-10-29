package realworld;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements EntityRepository<User>{

    private  final String fileName;

    public UserRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<User> findAll() {
        List<User> array = new ArrayList<>();
        try {
            Reader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);

            String userReadLine = reader.readLine();
            while (userReadLine != null) {
                String[] parts = userReadLine.split("\\|");

                Long id = Long.parseLong(parts[0]);
                String firstName = parts[1];
                String lastName = parts[2];
                Integer age = Integer.parseInt(parts[3]);
                array.add(new User(id, firstName, lastName, age));
                userReadLine = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Что-то пошло не так !");
            throw new IllegalArgumentException(e);
        }
        return array;
    }
}
