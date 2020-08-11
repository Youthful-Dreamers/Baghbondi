package lan;

import NewBaghbondi.Position;

import java.io.Serializable;

public interface Transferable extends Serializable {

}

class TransferablePosition implements Transferable,Serializable {
    private Position[][] positions;

    public TransferablePosition(Position[][] positions) {
        this.positions = positions;
    }

    public void setPositions(Position[][] positions) {
        this.positions = positions;
    }

    public Position[][] getPositions() {
        return positions;
    }

}
