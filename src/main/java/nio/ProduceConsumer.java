package nio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by rod bate on 2016/1/28.
 */

class Producer implements Runnable {
    private final BlockingQueue queue;

    Producer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            while (true) {
                queue.put(produce());
                queue.put(produce());
                queue.put(produce());
                queue.put(produce());
                queue.put(produce());
                //Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private Object produce() {
        System.out.println("produce one object");
        return 1;
    }
}

class Consumer implements Runnable {

    private final BlockingQueue queue;

    Consumer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while (true) {
                consume(queue.take());
                //Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void consume(Object take) {
        System.out.println("consume one object： ============== current thread : " + Thread.currentThread().getName());
    }
}

class T{
     public static void main(String[] args){
         BlockingQueue queue = new ArrayBlockingQueue(1);
         Producer p = new Producer(queue);
         Consumer c1 = new Consumer(queue);
         Consumer c2 = new Consumer(queue);

         new Thread(p).start();
         new Thread(c1).start();
         new Thread(c2).start();
    }
}