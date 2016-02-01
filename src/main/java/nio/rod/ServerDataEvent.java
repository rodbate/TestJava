package nio.rod;

import java.nio.channels.SocketChannel;

/**
 * Created by rod bate on 2016/1/28.
 */
public class ServerDataEvent {

    private NioServer server;
    private SocketChannel socketChannel;
    private byte[] data;

    public ServerDataEvent(NioServer server, SocketChannel socketChannel, byte[] data) {
        this.server = server;
        this.socketChannel = socketChannel;
        this.data = data;
    }

    public NioServer getServer() {
        return server;
    }

    public void setServer(NioServer server) {
        this.server = server;
    }

    public SocketChannel getSocketChannel() {
        return socketChannel;
    }

    public void setSocketChannel(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
