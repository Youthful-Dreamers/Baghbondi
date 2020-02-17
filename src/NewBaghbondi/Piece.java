package NewBaghbondi;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Piece extends StackPane {
    private double fromMouseVertical,fromMouseHorizontal;
    private double oldVertical,oldHorizontal;
    private PieceType type;
    private int offset=30;



    public PieceType getPieceType() {
        return type;
    }

    public Piece(PieceType type, int vertical, int horizontal) {
     //   relocate(vertical*BoardScene.positionSize*2,horizontal*BoardScene.positionSize*2);

        move(horizontal, vertical);
      //  System.out.println("PIECE ");
        Circle pieceCircle = new Circle();

        if(type==PieceType.GOAT)
        {
            pieceCircle.setFill(Color.BLUE);
            pieceCircle.setRadius(20);

        }
        else {
            pieceCircle.setRadius(20);
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
        System.out.println(("While inserting "+horizontal+" "+vertical));
        System.out.println(oldHorizontal+" "+oldVertical);
        relocate(oldHorizontal,oldVertical);
    }

    public double getOldHorizontal() {
        return oldHorizontal;
    }

    public double getOldVertical() {
        return oldVertical;
    }
    public void abortMove()
    {
        relocate(oldHorizontal,oldVertical);
    }

    @Override
    public void relocate(double x, double y) {
        x+=offset;
        y+=offset;
        super.relocate(x, y);
    }
}
