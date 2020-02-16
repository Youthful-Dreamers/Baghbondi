package NewBaghbondi;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Piece extends StackPane {
    private PieceType type;

    public PieceType getPieceType() {
        return type;
    }

    public Piece(PieceType type, int horizontal, int vertical) {
        this.type = type;
        relocate(vertical*BoardScene.positionSize*2,horizontal*BoardScene.positionSize*2);
        System.out.println("PIECE ");
        Circle pieceCircle = new Circle();
        if(type==PieceType.Goat)
        {
            pieceCircle.setFill(Color.BLUE);
            pieceCircle.setRadius(20);
        }
        else {
            pieceCircle.setRadius(40);
            pieceCircle.setFill(Color.RED);
        }
        getChildren().addAll(pieceCircle);

    }


}
