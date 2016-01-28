package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rod bate on 2016/1/28.
 */
public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(10000));

        SocketChannel socketChannel = null;

        ByteBuffer buffer = ByteBuffer.allocate(48);

        while(true) {
            socketChannel = serverSocketChannel.accept();
            System.out.println("remote address : " + socketChannel.getRemoteAddress());
            //byte[] bytes = new byte[socketChannel.];
            List<Byte> bytes = new ArrayList<>();
            int read;
            while ((read = socketChannel.read(buffer)) != -1) {
                buffer.flip();
                //System.out.println(new String(buffer.array(), "utf-8"));
                while (buffer.hasRemaining()) {
                    bytes.add(buffer.get());
                    //System.out.print((char) buffer.get());
                }
                buffer.clear();
            }
            System.out.println("=================================");
            byte[] b = new byte[bytes.size()];
            for (int i = 0; i < bytes.size(); i++) {
                b[i] = bytes.get(i);
            }
            System.out.println(new String(b, "utf-8"));

            String httpResponse = "HTTP/1.1 200 OK\r\n" +
                    "Content-Length: 38\r\n" +
                    "Content-Type: text/html\r\n" +
                    "\r\n" +
                    "<html><body>Hello World rodbate!</body></html>";

            byte[] response = httpResponse.getBytes("utf-8");
            //ByteBuffer buffer1 = ByteBuffer.allocate(response.length);
            //buffer1.clear();
            //buffer1.put(response);
            //buffer1.flip();
            socketChannel.write(ByteBuffer.wrap(response));
            socketChannel.close();
        }
    }
}
