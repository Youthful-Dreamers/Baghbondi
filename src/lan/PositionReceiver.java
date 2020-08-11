package lan;

import NewBaghbondi.Position;

public class PositionReceiver {
    Position[][] positions;
    Receiver receiver;
    PositionReceiver(String proxy, int port){
        receiver = new Receiver(proxy,port);
    }

    public Position[][] receive() {
        positions = receiver.getPackagedPosition().getPositions();
        return positions;
    }

    public void close(){
        receiver.close();
    }
}
