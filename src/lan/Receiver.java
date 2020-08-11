package lan;

import NewBaghbondi.Position;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver {
    Position[][] positions;
    Socket receiverSocket;
    ObjectInputStream objectInputStream;

    Receiver(String proxy, int port){
        try {
            receiverSocket = new Socket(proxy,port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Position[][] getPositions() {
        getFromStream();
        return positions;
    }

    private void getFromStream()  {
        try{objectInputStream = new ObjectInputStream(receiverSocket.getInputStream());
        TransferablePosition packagedPosition = (TransferablePosition) objectInputStream.readObject();
        positions = packagedPosition.getPositions();}
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
