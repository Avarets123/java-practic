import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {
        try {

            Reader reader = new FileReader("input.txt");
            char[] chars = new char[10];
            chars[0] = (char) reader.read();
            chars[1] = (char) reader.read();
            chars[2] = (char) reader.read();
            chars[3] = (char) reader.read();
            chars[4] = (char) reader.read();
            System.out.println(reader.read());
            int i = 0;
        } catch (FileNotFoundException e) {
            System.out.println("Error text error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error text error: " + e.getMessage());
        }

    }
}