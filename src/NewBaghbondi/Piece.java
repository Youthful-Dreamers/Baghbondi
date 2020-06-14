package NewBaghbondi;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public abstract class Piece extends StackPane {
    protected double fromMouseVertical, fromMouseHorizontal;
    protected double oldVertical, oldHorizontal;

    private PieceTypeEnum type;
    private int offset = 30;
    Circle pieceCircle = new Circle();


    public PieceTypeEnum getPieceTypeEnum() {
        return type;
    }

    public Piece(PieceTypeEnum type, int vertical, int horizontal) {

        this.type=type;
        move(horizontal, vertical);


        getChildren().addAll(pieceCircle);
        addMousePressBehavior();
        addMouseDragBehavior();
    }

     void definePiece(Circle pieceCircle, Color color) {
        pieceCircle.setFill(color);
        pieceCircle.setRadius(20);
    }

     public PieceTypeEnum getType() {return type;}


    public void move(int horizontal, int vertical)
    {

        oldHorizontal=horizontal* StageCreator.positionSize*2;
        oldVertical =vertical* StageCreator.positionSize*2;
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
        x += offset;
        y += offset;
        super.relocate(x, y);
    }

    abstract Color getPieceColor();

    abstract PieceTypeEnum getPieceType();

    public void addMousePressBehavior() {
        setOnMousePressed(e -> {
            fromMouseVertical = e.getSceneY();
            fromMouseHorizontal = e.getSceneX();
        });
    }

    public void addMouseDragBehavior() {
        setOnMouseDragged(e -> {
            pieceRelocate(e.getSceneX() - fromMouseHorizontal + oldHorizontal,
                    e.getSceneY() - fromMouseVertical + oldVertical);
        });
    }

}
