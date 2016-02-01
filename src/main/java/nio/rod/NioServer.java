package nio.rod;

import datastructureandalgorithms.queue.Queue;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by rod bate on 2016/1/28.
 */
public class NioServer implements Runnable{

    private InetAddress hostAddress;
    private int port;

    private ServerSocketChannel serverSocketChannel;

    private Selector selector;

    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);

    private EchoWorker echoWorker;

    public NioServer(InetAddress hostAddress, int port, EchoWorker echoWorker) throws IOException {
        this.hostAddress = hostAddress;
        this.port = port;
        this.selector = initSelector();
        this.echoWorker = echoWorker;
    }

    private Selector initSelector() throws IOException {
        Selector socketSelector = Selector.open();

        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.socket().bind(new InetSocketAddress(hostAddress, port));

        serverSocketChannel.register(socketSelector, SelectionKey.OP_ACCEPT);

        return socketSelector;
    }

    @Override
    public void run() {

        while (true) {
            try {
                selector.select();  //blocking method until at least one available corresponding connection

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (!key.isValid()) continue;

                    if (key.isAcceptable()) {
                        accept(key);
                    } else if (key.isReadable()) {
                        read(key);
                    }
                    iterator.remove();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();

        readBuffer.clear();
        int readBytes;
        try {
            readBytes = socketChannel.read(readBuffer);
        } catch (IOException e) {
            key.cancel();
            socketChannel.close();
            return;
        }
        if (readBytes == -1) {
            key.channel().close();
            key.cancel();
            return;
        }
        this.echoWorker.processData(this, socketChannel, readBuffer.array(), readBytes);
    }

    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();

        SocketChannel socketChannel = server.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    public static void main(String[] args){
        try {
            EchoWorker worker = new EchoWorker();
            new Thread(worker).start();
            new Thread(new NioServer(null, 9999, worker)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
