package NewBaghbondi;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Position extends Circle {
    private int horizontal, vertical;

    public int getHorizontal() {
        return horizontal;
    }

    public int getVertical() {
        return vertical;
    }

    private Piece piece;

    boolean hasPiece() {
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
        relocate(horizontal* GameStage.positionSize*2+10,vertical* GameStage.positionSize*2+10);
        setFill(Color.SKYBLUE);
        setOpacity(.45);
    }
}
