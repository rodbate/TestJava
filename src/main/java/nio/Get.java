package nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by rod bate on 2016/1/28.
 */
public class Get {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("www.baidu.com", 80));

        ByteBuffer write = ByteBuffer.allocate(512);
        write.clear();
        write.put("GET / HTTP/1.1 \r\n\r\n".getBytes());
        write.flip();
        socketChannel.write(write);

        ByteBuffer read = ByteBuffer.allocate(512);

        int r;
        while ((r = socketChannel.read(read)) != -1) {
            read.flip();
            while (read.hasRemaining()) {
                System.out.print((char)read.get());
            }
            read.clear();
        }
        socketChannel.close();

    }
}
