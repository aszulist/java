import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

    public static void main(String[] args) {

        // FIFO (first in first out)

        // max 3 items
        Queue<Integer> queue1 = new ArrayBlockingQueue<Integer>(3);

        queue1.add(10);
        queue1.add(20);
        queue1.add(30);

        try {
            queue1.add(40);
        } catch (IllegalStateException e) {
            System.out.println("Tried to add too many items to the queue.");
        }

        for (Integer value: queue1) {
            System.out.println("Queue value: " + value);
        }

        System.out.println("Removed from queue: " + queue1.remove());
        System.out.println("Removed from queue: " + queue1.remove());
        System.out.println("Removed from queue: " + queue1.remove());

        try {
            System.out.println("Removed from queue: " + queue1.remove());
        } catch (NoSuchElementException e) {
            System.out.println("Try to remove to many elements");
        }

        ////////////////////////////////////////////////////////////////

        Queue<Integer> queue2 = new ArrayBlockingQueue<Integer>(2);

        queue2.offer(10);
        queue2.offer(20);

        if (!queue2.offer(30)) {
            System.out.println("Offer failed to add third item.");
        }

        for (Integer value: queue2) {
            System.out.println("Queue 2 value: " + value);
        }

        System.out.println("Queue 2 poll: " + queue2.poll());
        System.out.println("Queue 2 poll: " + queue2.poll());
        System.out.println("Queue 2 poll: " + queue2.poll());
    }
}
