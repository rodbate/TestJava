package nio.rod;

import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rod bate on 2016/1/28.
 */
public class EchoWorker implements Runnable{

    private List<ServerDataEvent> queue = new LinkedList<>();

    public void processData(NioServer server, SocketChannel socketChannel, byte[] data, int count){
        byte[] dataCopy = new byte[count];
        System.arraycopy(data, 0, dataCopy, 0, count);
        synchronized (this){
            queue.add(new ServerDataEvent(server, socketChannel, data));
            queue.notify();
        }
    }
    @Override
    public void run() {
        ServerDataEvent serverDataEvent;

        while (true) {
            synchronized (this) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                serverDataEvent = queue.remove(0);
            }
            serverDataEvent.getServer();
        }
    }
}
