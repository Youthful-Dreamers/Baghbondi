package NewBaghbondi;

import javafx.scene.paint.Color;

public class Tiger extends Piece{
    private Color pieceColor = Color.RED;
    private PieceTypeEnum type = PieceTypeEnum.TIGER;

    Tiger( int vertical, int horizontal){
        super(PieceTypeEnum.TIGER,vertical,horizontal);
        definePiece(pieceCircle,pieceColor);
    }
    @Override
    public PieceTypeEnum getPieceType() {
        return type;
    }

    @Override
    public Color getPieceColor(){
        return pieceColor;
    }


}
