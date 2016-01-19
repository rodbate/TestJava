package datastructureandalgorithms.queue;

/**
 * Created by rod bate on 2016/1/19.
 */
public class QueueApp {

    public static void main(String[] args) {

        Queue queue = new Queue(5);

        queue.insert(11);
        queue.insert(12);
        queue.insert(1);
        queue.insert(111);
        queue.insert(112);

        System.out.println(queue.display());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.display());
        queue.insert(2);
        System.out.println(queue.display());
        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }

    }
}
