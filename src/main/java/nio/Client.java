package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by rod bate on 2016/1/28.
 */
public class Client {

    public static void main(String[] args) throws IOException {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("please type something....");
            String line = scanner.nextLine();
            System.out.println(line);
            byte[] bytes = line.getBytes("utf-8");

            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 10000));
            ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
            buffer.clear();
            buffer.put(bytes);
            buffer.flip();

            //while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
           // }

            socketChannel.close();
       }

    }
}
