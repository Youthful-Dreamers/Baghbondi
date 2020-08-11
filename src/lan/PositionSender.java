package lan;

import NewBaghbondi.Position;

public class PositionSender {
    TransferablePosition packagedPositions;
    Sender sender;
    PositionSender(Position[][] positions, int port){
        packagedPositions = new TransferablePosition(positions);
        sender = new Sender(port);
    }
    public void send(){
        sender.send(packagedPositions);
    }

    public void close(){
        sender.close();
    }
}
