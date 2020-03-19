package NewBaghbondi;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Position extends Circle {
    private int horizontal ,vertical;

    private Piece piece;
    boolean hasPiece(){
        return piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Position(int vertical ,int horizontal )
    {
        this.horizontal =horizontal;
        this.vertical=vertical;
        setRadius(40);
        relocate(horizontal*BoardStage.positionSize*2+10,vertical*BoardStage.positionSize*2+10);
        setFill(Color.VIOLET);
    }
}
