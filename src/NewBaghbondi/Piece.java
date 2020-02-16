package NewBaghbondi;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Piece extends StackPane {
    private double fromMouseVertical,oldVertical;
    private double fromMouseHorizontal,oldHorizontal;
    private PieceType type;

    public PieceType getPieceType() {
        return type;
    }

    public Piece(PieceType type, int vertical, int horizontal) {
        this.type = type;
     //   relocate(vertical*BoardScene.positionSize*2,horizontal*BoardScene.positionSize*2);
        move(horizontal, vertical);
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
        setOnMousePressed(e -> {
            fromMouseVertical=e.getSceneY();
            fromMouseHorizontal=e.getSceneX();
        });
        setOnMouseDragged(e->{
            relocate(e.getSceneX()-fromMouseHorizontal+oldHorizontal,
                    e.getSceneY()-fromMouseVertical+oldVertical);
        });


    }
    public void move(int horizontal, int vertical)
    {
        oldHorizontal=horizontal*BoardScene.positionSize*2;
        oldVertical =vertical*BoardScene.positionSize*2;
        relocate(oldHorizontal,oldVertical);

    }



}
