package NewBaghbondi;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Position extends Circle {
    int horizontal ,vertical;
    private Piece piece;
    boolean hasPiece(){
        return piece!=null;
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
        setRadius(10);
        relocate(horizontal*BoardScene.positionSize*2+10,vertical*BoardScene.positionSize*2+10);
        setFill(Color.BLACK);

    }
}
