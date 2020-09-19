package code;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.function.Consumer;

public class Client{

    private ConnectionThread connectionThread = new ConnectionThread();
    private Consumer<Serializable> onReceiveCallBack;
    private String IPAddress;
    private int port;
    private boolean isClosed;

    public Client(String IPAddress, Consumer<Serializable> onReceiveCallBack){
        this.onReceiveCallBack = onReceiveCallBack;
        connectionThread.setDaemon(true);
        this.IPAddress = IPAddress;
        port = 9811;
    }

    public void startConnection(){
        connectionThread.start();
    }

    public void send(Serializable data) throws Exception{
        connectionThread.out.writeObject(data);
        isClosed =  false;
    }

    public void closeConnection() throws Exception{
        connectionThread.socket.close();
        isClosed = true;
    }

    protected String getIP(){
        return IPAddress;
    }
    protected int getPort(){
        return port;
    }
    protected boolean getIsClosed() { return isClosed; }

    private class ConnectionThread extends Thread{

        protected Socket socket;
        protected ObjectOutputStream out;

        @Override
        public void run(){
            try(Socket socket = new Socket(getIP(), getPort());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

                this.socket = socket;
                this.out = out;
                socket.setTcpNoDelay(true);

                while(true){
                    try {
                        Serializable data = (Serializable) in.readObject();
                        onReceiveCallBack.accept(data);
                    }catch(Exception e){
                        System.out.println("Exception in Receiving data: "+e);
                    }
                }
            } catch (Exception e){
                onReceiveCallBack.accept("Exception in establishing connection: " + e);
            }
        }
    }
}

