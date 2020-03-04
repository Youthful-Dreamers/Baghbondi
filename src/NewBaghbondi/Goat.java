package NewBaghbondi;

import javafx.scene.paint.Color;

public class Goat implements PieceType {
   private Color pieceColor = Color.BLUE;
    PieceTypeEnum type = PieceTypeEnum.GOAT;

    @Override
    public PieceTypeEnum getPieceType() {
        return type;
    }

    @Override
    public Color getPieceColor() {
        return pieceColor;
    }

}
