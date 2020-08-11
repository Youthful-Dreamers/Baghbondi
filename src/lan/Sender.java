package lan;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

 class Sender {
    ServerSocket server;
    Socket socket;
    ObjectOutputStream objectOutputStream;

   protected Sender(int port)  {

       try {
           server = new ServerSocket(port);
           socket = server.accept();
       }
       catch (IOException e){
           e.printStackTrace();
       }

    }

    public void send(TransferablePosition packagedPosition) {
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(packagedPosition);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void close(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
