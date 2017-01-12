import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> animals = new LinkedList<>();

        animals.add("fox");
        animals.add("cat");
        animals.add("dog");
        animals.add("rabbit");

        // modern iteration, post Java 5 and later

        Iterator<String> it = animals.iterator();
        String next;

        while (it.hasNext()) {
            next = it.next();
            System.out.println(next);

            if (next.equals("cat")) {
                it.remove();
            }
        }

        System.out.println();

        for (String animal: animals) {
            System.out.println(animal);
        }

    }
}
