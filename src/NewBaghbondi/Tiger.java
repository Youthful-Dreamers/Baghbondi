package NewBaghbondi;

import javafx.scene.paint.Color;

public class Tiger implements PieceType{
    private Color pieceColor = Color.RED;
    private PieceTypeEnum type = PieceTypeEnum.TIGER;

    @Override
    public PieceTypeEnum getPieceType() {
        return type;
    }

    @Override
    public Color getPieceColor(){
        return pieceColor;
    }

}
