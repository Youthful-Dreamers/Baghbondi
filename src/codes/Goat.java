package codes;

import javafx.scene.paint.Color;

public class Goat extends Piece {
    private PlayerType type = PlayerType.GOAT;
    private Color pieceColor = Color.BLUE;

    Goat(int vertical, int horizontal) {
        super(PlayerType.GOAT, vertical, horizontal);
        definePiece(pieceCircle, pieceColor);
    }

    public PlayerType getPieceType() {
        return type;
    }
}
