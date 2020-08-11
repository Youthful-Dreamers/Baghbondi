package lan;

import NewBaghbondi.Position;

import java.io.Serializable;

class TransferablePosition implements Serializable {
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
