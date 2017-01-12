import model.Person;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) {

        Path path = Paths.get("/home/adam/Repo/java/Streams-collectors-optionals/Spliterator/src/people.txt");

        try (Stream<String> lines = Files.lines(path)) {

            Spliterator<String> lineSpliterator = lines.spliterator();
            Spliterator<Person> peopleSpliterator = new PersonSpliterator(lineSpliterator);

            Stream<Person> people = StreamSupport.stream(peopleSpliterator, false);
            people.forEach(System.out::println);


        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }
}
