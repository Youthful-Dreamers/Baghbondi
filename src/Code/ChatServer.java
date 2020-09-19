package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ChatServer {

    private Connection connection;

    private String clientIP;
    private int clientPort;
    private String localIP;
    private int localPort;
    private int backLog;

    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    private InetAddress clientAddress;
    private InetAddress localAddress;

    private Socket socket = null;
    private ServerSocket serverSocket = null;

    protected ChatServer(String localIP){
        connection = new Connection();
        this.localIP = localIP;
        localPort = 9811;
        backLog = 50;
    }

    public void startServer() throws IOException {
        localAddress = InetAddress.getByName(localIP);
        serverSocket = new ServerSocket(localPort, backLog, localAddress);
        socket = serverSocket.accept();
        clientAddress = socket.getInetAddress();
        clientPort = socket.getPort();
        bufferedReader = connection.createBufferReader(socket);
        printWriter = connection.createPrintWriter(socket);
    }

    protected void closeServer() throws IOException {
        bufferedReader.close();
        printWriter.close();
        socket.close();
        serverSocket.close();
    }

    protected BufferedReader getBufferedReader(){ return bufferedReader; }
    protected PrintWriter getPrintWriter(){ return printWriter; }
}

