package nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by rod bate on 2016/1/26.
 */
public class SimpleChannel {

    public static void main(String[] args) throws IOException {

        //RandomAccessFile aFile = new RandomAccessFile("nio-data.txt","rw");
        File file = new File("D://nio-data/nio-data.txt");
        FileInputStream fis = new FileInputStream(file);

        FileChannel channel = fis.getChannel();

        System.out.println("file size : " + channel.size());
        System.out.println("channel position : " + channel.position());

        ByteBuffer buffer = ByteBuffer.allocate(24);

        int read;

        while ((read = channel.read(buffer))!= -1) {
            System.out.println("channel position : " + channel.position());
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char)buffer.get());
            }
            System.out.println();
            buffer.clear();
        }
        fis.close();

    }
}
