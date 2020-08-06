package NewBaghbondi;

import javafx.scene.paint.Color;

public class Tiger extends Piece{
    private Color pieceColor = Color.RED;
    private PlayerType type = PlayerType.TIGER;

    Tiger( int vertical, int horizontal){
        super(PlayerType.TIGER,vertical,horizontal);
        definePiece(pieceCircle,pieceColor);
    }
    @Override
    public PlayerType getPieceType() {
        return type;
    }

    @Override
    public Color getPieceColor(){
        return pieceColor;
    }


}
