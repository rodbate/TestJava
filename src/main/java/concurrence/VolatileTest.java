package concurrence;


import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

    //public static volatile int data = 0;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void increase(){
        //data++;
        atomicInteger.incrementAndGet();
    }

    public static final int THREAD_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {

            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });

            threads[i].start();
        }
//Thread.MAX_PRIORITY
        while(Thread.activeCount() > 1) {
            Thread.yield();
        }
        ThreadLocal threadLocal = new ThreadLocal();
        //int a = 1;
        //threadLocal.set(a);
        //Thread.sleep(3000);
        System.out.println(atomicInteger);
        //
    }
}
