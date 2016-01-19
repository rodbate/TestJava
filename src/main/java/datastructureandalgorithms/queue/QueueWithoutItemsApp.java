package datastructureandalgorithms.queue;

import java.util.stream.IntStream;

/**
 * Created by rod bate on 2016/1/19.
 */
public class QueueWithoutItemsApp {

    public static void main(String[] args) {

        QueueWithoutItems queue = new QueueWithoutItems(5);
        queue.insert(1).insert(2).insert(3).insert(4).insert(5);
        IntStream.rangeClosed(1,3).forEach((i) -> {
            queue.remove();
        });
        queue.insert(2).insert(2);
        System.out.println(queue.size());

    }
}
