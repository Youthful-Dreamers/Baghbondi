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

        this.type=type;
        move(horizontal, vertical);
        PieceType piece;
        Circle pieceCircle = new Circle();
        piece = getPieceType(type);
        definePiece(pieceCircle, piece.getPieceColor());
        getChildren().addAll(pieceCircle);
        addMousePressBehavior();
        addMouseDragBehavior();
    }


    private void addMousePressBehavior() {
        setOnMousePressed(e -> {
            fromMouseVertical=e.getSceneY();
            fromMouseHorizontal=e.getSceneX();
        });
    }

    private void addMouseDragBehavior() {
        setOnMouseDragged(e->{
            pieceRelocate(e.getSceneX()-fromMouseHorizontal+oldHorizontal,
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
        pieceRelocate(oldHorizontal,oldVertical);
    }

    public double getOldHorizontal() {
        return oldHorizontal;
    }

    public double getOldVertical() {
        return oldVertical;
    }
    public void abortMove()
    {
        pieceRelocate(oldHorizontal,oldVertical);
    }


    public void pieceRelocate(double x, double y) {
        x+=offset;
        y+=offset;
        super.relocate(x, y);
    }
}
