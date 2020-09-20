package codes;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

    private ConnectionThread connectionThread = new ConnectionThread();
    private Consumer<Serializable> onReceiveCallBack;
    private int port;
    private boolean isClosed;

    public Server(Consumer<Serializable> onReceiveCallBack) {
        this.onReceiveCallBack = onReceiveCallBack;
        connectionThread.setDaemon(true);
        port = 9811;
    }

    public void startConnection() {
        connectionThread.start();
        isClosed = false;
    }

    public void send(Serializable data) throws Exception {
        connectionThread.out.writeObject(data);
    }

    public void closeConnection() throws Exception {
        if (connectionThread.socketServer != null) {
            connectionThread.socketServer.close();
            isClosed = true;
        }
        if (connectionThread.socket != null) {
            connectionThread.socket.close();
            isClosed = true;
        }
    }

    protected int getPort() {
        return port;
    }

    protected boolean getIsClosed() {
        return isClosed;
    }

    private class ConnectionThread extends Thread {

        protected Socket socket;
        protected ServerSocket socketServer;
        protected ObjectOutputStream out;

        @Override
        public void run() {
            try (ServerSocket server = new ServerSocket(getPort());
                 Socket socket = server.accept();
                 ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

                this.socketServer = server;
                this.socket = socket;
                this.out = out;
                socket.setTcpNoDelay(true);

                while (true) {
                    try {
                        Serializable data = (Serializable) in.readObject();
                        onReceiveCallBack.accept(data);
                    } catch (Exception e) {
                        System.out.println("Exception in Receiving data: " + e);
                    }
                }
            } catch (Exception e) {
                onReceiveCallBack.accept("Exception in establishing connection: " + e);
            }
        }
    }
}

