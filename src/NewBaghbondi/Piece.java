package NewBaghbondi;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public abstract class Piece extends StackPane {
    private double fromMouseVertical,fromMouseHorizontal;
    private double oldVertical,oldHorizontal;
    private PieceTypeEnum type;
    private int offset=30;
    Circle pieceCircle = new Circle();
    Piece piece;
    Piece(){}


    public PieceTypeEnum getPieceTypeEnum() {
        return type;
    }

    public Piece(PieceTypeEnum type, int vertical, int horizontal) {

        this.type=type;
        move(horizontal, vertical);


      //  piece = getPieceType(type,vertical, horizontal);
    //        definePiece(pieceCircle, piece.getPieceColor());
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




     void definePiece(Circle pieceCircle, Color color) {
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
   int getMoveFactor(){
        int centralVertical = 2;
        return (int)Math.abs(oldVertical/100-centralVertical);

    }
    abstract Color getPieceColor();
    abstract PieceTypeEnum getPieceType();

}
