import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Function<Integer, Integer> n = number -> number * 2;

//        BinaryOperator<Integer> sum = (i1, i2) -> i1 + i2;
//        BinaryOperator<Integer> sum = (i1, i2) -> Integer.sum(i1, i2);
        BinaryOperator<Integer> sum = Integer::sum;

        BinaryOperator<Integer> max = Integer::max;

//        Consumer<String> printer = s -> System.out.println(s);
        Consumer<String> printer = System.out::println;

        System.out.println(sum.apply(2, 3));
        System.out.println(max.apply(2, 3));

        printer.accept("Lalala");

    }
}
