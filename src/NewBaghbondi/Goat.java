package NewBaghbondi;

import javafx.scene.paint.Color;

public class Goat extends Piece
{
    private Color pieceColor = Color.BLUE;

    PieceTypeEnum type = PieceTypeEnum.GOAT;

    Goat( int vertical, int horizontal) {
        super(PieceTypeEnum.GOAT,vertical,horizontal);
        definePiece(pieceCircle,pieceColor);
    }

    @Override
    public PieceTypeEnum getPieceType() {
        return type;
    }

    @Override
    public Color getPieceColor() {
        return pieceColor;
    }

}
