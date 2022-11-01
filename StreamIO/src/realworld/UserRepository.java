package realworld;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserRepository implements EntityRepository<User> {

    private final String fileName;

    public UserRepository(String fileName) {
        this.fileName = fileName;
    }

    private static final Function<String, User> stringToUserMapper = userString -> {
        String[] parts = userString.split("\\|");
        String firstName = parts[0];
        String lastName = parts[1];
        Integer age = Integer.parseInt(parts[2]);
        return new User(firstName, lastName, age);
    };

    private static final Function<User, String> userToStringMapper = user -> {
        return user.getFirstName() + "|" + user.getLastName() + "|" + user.getAge();
    };

//    @Override
//    public List<User> findAll() {
//        List<User> array = new ArrayList<>();
//        Reader fileReader;
//        BufferedReader reader;
//        try {
//            fileReader = new FileReader(fileName);
//            reader = new BufferedReader(fileReader);
//
//            String userReadLine = reader.readLine();
//            while (userReadLine != null) {
//                String[] parts = userReadLine.split("\\|");
//
//                Long id = Long.parseLong(parts[0]);
//                String firstName = parts[1];
//                String lastName = parts[2];
//                Integer age = Integer.parseInt(parts[3]);
//                array.add(new User(id, firstName, lastName, age));
//                userReadLine = reader.readLine();
//            }
//
//        } catch (IOException e) {
//            System.out.println("Что-то пошло не так !");
//            throw new IllegalArgumentException(e);
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//
//                } catch (IOException ignored){}
//
//            }
//            if (fileReader != null) {
//                try {
//                    fileReader.close();
//
//                } catch (IOException ignored) {}
//            }
//
//        }
//        return array;
//    }

    @Override
    public List<User> findAll() {
        List<User> array = new ArrayList<>();
        try (
                Reader fileReader = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {

            String userReadLine = reader.readLine();
            while (userReadLine != null) {
                User user = stringToUserMapper.apply(userReadLine);
                array.add(user);
                userReadLine = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Что-то пошло не так !");
            throw new IllegalArgumentException(e);
        }
        return array;
    }

    @Override
    public List<User> findAllByAgeGreaterThan(int less) {
        List<User> array = new ArrayList<>();
        try (
                Reader fileReader = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(fileReader);
        ) {

            String userReadLine = reader.readLine();
            while (userReadLine != null) {
                User user = stringToUserMapper.apply(userReadLine);
                if (user.getAge() > less) {
                    array.add(user);
                }
                userReadLine = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Что-то пошло не так !");
            throw new IllegalArgumentException(e);
        }
        return array;
    }

    @Override
    public void save(User value) {
        try
                (
                        FileWriter fileWriter = new FileWriter(fileName, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                ) {

            String userToSave = userToStringMapper.apply(value);
            bufferedWriter.write(userToSave);
            bufferedWriter.newLine();

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<String> findAllByUniqueName() {
        try {
            return new BufferedReader(new FileReader(fileName))
                    .lines()
                    .map(stringToUserMapper)
                    .map(User::getFirstName)
                    .distinct()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public int findMinAge() {
        try {
            return new BufferedReader(new FileReader(fileName))
                    .lines()
                    .map(stringToUserMapper)
                    .mapToInt(User::getAge)
                    .min()
                    .getAsInt();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

    }

    @Override
    public double getAverageAge() {
        try {
            return new BufferedReader(new FileReader(fileName))
                    .lines()
                    .map(stringToUserMapper)
                    .mapToInt(User::getAge)
                    .average()
                    .getAsDouble();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

    }

    @Override
    public User findWithMinAge() {

        try {
            return new BufferedReader(new FileReader(fileName))
                    .lines()
                    .map(stringToUserMapper)
//                    .min((a, b) -> a.getAge() - b.getAge())
                    .min(Comparator.comparing(User::getAge))
                    .get();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

    }

}
