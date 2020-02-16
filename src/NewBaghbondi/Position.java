package NewBaghbondi;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Position extends Circle {
    int vertical,horizontal;
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

    public Position(int horizontal, int vertical)
    {
        this.vertical =vertical;
        this.horizontal=horizontal;
        setRadius(10);
        relocate(vertical*BoardScene.positionSize*2+10,horizontal*BoardScene.positionSize*2+10);
        setFill(Color.BLACK);

    }
}
