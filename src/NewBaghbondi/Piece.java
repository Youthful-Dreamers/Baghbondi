package NewBaghbondi;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Piece extends StackPane {
    private double fromMouseVertical,fromMouseHorizontal;
    private double oldVertical,oldHorizontal;
    private PieceTypeEnum type;
    private int offset=30;



    public PieceTypeEnum getPieceTypeEnum() {
        return type;
    }

    public Piece(PieceTypeEnum type, int vertical, int horizontal) {
     //   relocate(vertical*BoardScene.positionSize*2,horizontal*BoardScene.positionSize*2);

        this.type=type;
        move(horizontal, vertical);
        PieceType piece;
      //  System.out.println("PIECE ");
        Circle pieceCircle = new Circle();
        piece = getPieceType(type);
        definePiece(pieceCircle, piece.getPieceColor());
        getChildren().addAll(pieceCircle);
        setOnMousePressed(e -> {
            fromMouseVertical=e.getSceneY();
            fromMouseHorizontal=e.getSceneX();
        });
        setOnMouseDragged(e->{
            relocatePiece(e.getSceneX()-fromMouseHorizontal+oldHorizontal,
                    e.getSceneY()-fromMouseVertical+oldVertical);
        });





    }

    private PieceType getPieceType(PieceTypeEnum type) {
        PieceType piece;
        if(type== PieceTypeEnum.GOAT)
        {
             piece = new Goat();
        }
        else {
            piece = new Tiger();
        }
        return piece;
    }


    private void definePiece(Circle pieceCircle, Color color) {
        pieceCircle.setFill(color);
        pieceCircle.setRadius(20);
    }
    public PieceTypeEnum getType(){
        return type;
    }


    public void move(int horizontal, int vertical)
    {

        oldHorizontal=horizontal*BoardScene.positionSize*2;
        oldVertical =vertical*BoardScene.positionSize*2;
        System.out.println(("While inserting "+horizontal+" "+vertical));
        System.out.println(oldHorizontal+" "+oldVertical);
        relocatePiece(oldHorizontal,oldVertical);
    }

    public double getOldHorizontal() {
        return oldHorizontal;
    }

    public double getOldVertical() {
        return oldVertical;
    }
    public void abortMove()
    {
        relocatePiece(oldHorizontal,oldVertical);
    }


    public void relocatePiece(double x, double y) {
        x+=offset;
        y+=offset;
        super.relocate(x, y);
    }
}
