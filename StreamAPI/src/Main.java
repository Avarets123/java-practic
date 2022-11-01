import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> words = List.of("Have", "Nice", "are", "day");

//        Predicate<String> isUpperCase = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return Character.isUpperCase(s.toCharArray()[0]);
//            }
//        };

        Function<String, String> allToUpperCase = s -> s.toUpperCase();
        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.toCharArray()[0]);
        Consumer<String> printWord = System.err::println;

//        Stream<String> wordsStream = words.stream();
//        Stream<String> upperCaseWords = wordsStream.filter(isUpperCase);
//        Stream<String> allUppercase = upperCaseWords.map(allToUpperCase);
//        allUppercase.forEach(printWord);

        words.stream()
                .filter(isUpperCase)
                .map(allToUpperCase)
                .forEach(printWord);


//        List.of("Have", "a", "nice", "Day", "Thank", "you")
//                .stream()
//                .filter(word -> Character.isUpperCase(word.toCharArray()[0]))
//                .map(word -> word.toUpperCase())
//                .forEach(word -> System.out.println(word));



                Stream.of("Have", "a", "nice", "Day", "Thank", "you")
                .filter(word -> Character.isUpperCase(word.toCharArray()[0]))
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}