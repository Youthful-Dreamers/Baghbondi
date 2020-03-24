package NewBaghbondi;

import javafx.scene.paint.Color;

public class Goat extends Piece {
    private Color pieceColor = Color.BLUE;
    public static int goatNo = 7;
    PieceTypeEnum type = PieceTypeEnum.GOAT;
    Goat( int vertical, int horizontal){
        super(PieceTypeEnum.GOAT,vertical,horizontal);
        definePiece(pieceCircle,pieceColor);

    }

    public static boolean goatEliminate()
    {
        goatNo--;
        if(goatNo==0) return true;
        else return false;
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
