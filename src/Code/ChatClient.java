package code;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.net.Socket;
import java.net.InetAddress;


public class ChatClient {

    private GetIP getIP;
    private Connection connection;

    private String destinationIP;
    private int destinationPort;
    private String localIP;
    private int localPort;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    InetAddress destAddress;
    InetAddress localAddress;

    Socket socket = null;

    protected ChatClient() throws UnknownHostException {
        getIP = new GetIP();
        connection = new Connection();
        localIP = getIP.getIP();
    }

    public void startClient(String destinationIP) {
        try {
            destinationPort = 9811;
            localPort = 9811;
            this.destinationIP = destinationIP;
            destAddress = InetAddress.getByName(destinationIP);
            localAddress = InetAddress.getByName(localIP);
            
            socket = new Socket(destAddress, destinationPort);

            bufferedReader = connection.createBufferReader(socket);
            printWriter = connection.createPrintWriter(socket);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    protected void closeChatClient() throws IOException {
        bufferedReader.close();
        printWriter.close();
        socket.close();
    }

    protected BufferedReader getBufferedReader(){ return  bufferedReader; }
    protected PrintWriter getPrintWriter(){return printWriter; }
}

