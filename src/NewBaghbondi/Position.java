package NewBaghbondi;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Position extends Circle {

    final static int positionSize = 50;

    private Piece piece;
    private int horizontal, vertical;

    public Position(int vertical ,int horizontal )
    {
        this.horizontal =horizontal;
        this.vertical=vertical;
        setRadius(40);
        relocate(horizontal*positionSize*2+10,vertical*positionSize*2+10);
        setFill(Color.SKYBLUE);
        setOpacity(.45);
    }

    public int getHorizontal() {
        return horizontal;
    }
    public int getVertical() {
        return vertical;
    }

    boolean hasPiece() {
        return piece != null;
    }
    public Piece getPiece() {
        return piece;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
