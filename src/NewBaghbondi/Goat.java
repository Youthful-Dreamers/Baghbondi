package NewBaghbondi;

import javafx.scene.paint.Color;

public class Goat extends Piece
{

    private Color pieceColor = Color.BLUE;

    PlayerType type = PlayerType.GOAT;

    Goat( int vertical, int horizontal) {
        super(PlayerType.GOAT,vertical,horizontal);
        definePiece(pieceCircle,pieceColor);
    }

    @Override
    public PlayerType getPieceType() {
        return type;
    }

    @Override
    public Color getPieceColor() {
        return pieceColor;
    }


}
