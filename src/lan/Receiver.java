package lan;

import NewBaghbondi.Position;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver {
    private TransferablePosition packagedPosition;
    private Socket receiverSocket;

    Receiver(String proxy, int port){
        try {
            receiverSocket = new Socket(proxy,port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public TransferablePosition getPackagedPosition() {
        getFromStream();
        return packagedPosition;
    }

    private void getFromStream()  {
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(receiverSocket.getInputStream());
        packagedPosition = (TransferablePosition) objectInputStream.readObject();
        }
        catch (ClassNotFoundException | IOException e){
            e.printStackTrace();
        }
    }

    protected void close()  {
        try {
            receiverSocket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
