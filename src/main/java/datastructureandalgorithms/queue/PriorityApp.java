package datastructureandalgorithms.queue;

/**
 * Created by rod bate on 2016/1/19.
 */
public class PriorityApp {

    public static void main(String[] args) {

        PriorityQueue queue = new PriorityQueue(5);
        queue.insert(11).insert(122).insert(1).insert(2).insert(300);
        System.out.println(queue.peekMax());
        System.out.println(queue.peekMin());
        System.out.println(queue.display());
    }
}
