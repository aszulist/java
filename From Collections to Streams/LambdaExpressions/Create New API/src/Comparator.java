import java.util.function.Function;

@FunctionalInterface
interface Comparator<T> {

    int compare(T t1, T t2);

    default Comparator<T> thenComparing(Comparator<T> cmp) {
        return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2);
    }

    default Comparator<T> thenComparing(Function<T, Comparable> f) {
        return thenComparing(comparing(f));
    }

    static <T> Comparator<T> comparing(Function<T, Comparable> f) {

        return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));
    }

}