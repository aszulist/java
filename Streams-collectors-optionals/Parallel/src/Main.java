import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> strings = new CopyOnWriteArrayList<>();

        List<String> collect = Stream.iterate("+", s -> s + "+")
                .parallel()
                .limit(1000)
//                .peek(s -> System.out.println(s + " processed in the thread " + Thread.currentThread().getName()))
                .collect(Collectors.toList());

        System.out.println("# " + collect.size());

    }
}
