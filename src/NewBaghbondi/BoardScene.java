package NewBaghbondi;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BoardScene {
    static final int positionSize = 50;
    private Group positionGroup = new Group();
    private Group pieceGroup = new Group();
    private BoardLines lineGroup = new BoardLines();
    private Position[][] board = new Position[5][5];
    private int verticalLine = 5;
    private int horizontalLine = 5;

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(800, 600);
        drawBoard();
        drawLine();
        root.getChildren().addAll(positionGroup, pieceGroup,lineGroup.getLineGroup());
        return root;
    }

    public void boardSceneView() {
        Stage boardStage = new Stage();
        boardStage.setScene(new Scene(createContent()));
        boardStage.setTitle("BaghBondi");
        boardStage.show();
    }

    private void drawBoard() {
        System.out.println("****************Called drawBoard()****************");
        int skip, skipCounter;
        int i, j = 0;
        for (i = -verticalLine / 2, skip = -horizontalLine / 2; i < verticalLine / 2 + 1; i++, skip++) {
            for (skipCounter = 2, j = -Math.abs(i); j < Math.abs(i) + 1; j++) {
                if (skipCounter < Math.abs(skip) - 1) {
                    skipCounter++;
                    continue;
                } else skipCounter = 0;
                Position position = createPosition(i, j);
                Piece piece = null;
                if (i >= 0) {
                    piece = makePiece(PieceTypeEnum.GOAT, i + verticalLine / 2, j + horizontalLine / 2);
                    System.out.println("Making piece type :: goat: "+position.getLayoutX()+","+position.getLayoutY());

                } else if (i == -1 && j == 0) {
                    piece = makePiece(PieceTypeEnum.TIGER, i + verticalLine / 2, j + horizontalLine / 2);
                }
                if (piece != null) {
                    addMouseReleaseOptions(piece);
                    position.setPiece(piece);
                    pieceGroup.getChildren().add(piece);
                }


            }
        }


    }

    private Position createPosition(int vertical, int horizontal) {
        System.out.println("****************Called createPosition()****************");
        Position position = new Position(vertical + verticalLine / 2, horizontal + horizontalLine / 2);
        System.out.println("On board " + (horizontal + horizontalLine / 2) + " " + (vertical + verticalLine / 2));
        board[horizontal + horizontalLine / 2][vertical + verticalLine / 2] = position;
        positionGroup.getChildren().add(position);
        return position;
    }

    private Piece makePiece(PieceTypeEnum pieceTypeEnum, int vertical, int horizontal) {
        System.out.println("-----Called makePiece()-----");
        Piece piece;
        if(pieceTypeEnum==PieceTypeEnum.TIGER)
         piece = new Tiger(vertical, horizontal);
        else
            piece = new Goat(vertical,horizontal);

        return piece;

    }
    BoardListener boardListener = new BoardListener(board);
    private void addListener(){

    }
    private void addMouseReleaseOptions(Piece piece) {
        piece.setOnMouseReleased(e -> {
            System.out.println("-----Called makePiece() on mouse-----");
            int newHorizontal = pixelToBoard(piece.getLayoutX());
            int oldHorizontal = pixelToBoard(piece.getOldHorizontal());
            int newVertical = pixelToBoard(piece.getLayoutY());
            int oldVertical = pixelToBoard(piece.getOldVertical());
            MoveResult result = tryMove(piece, newHorizontal, newVertical);

            switch (result.getType()) {
                case NONE:
                    piece.abortMove();
                    break;
                case NORMAL:
                    piece.move(newHorizontal, newVertical);
                    System.out.println("Normal move from:: " + oldHorizontal + ", " + oldVertical);
                    board[oldHorizontal][oldVertical].setPiece(null);
                    board[newHorizontal][newVertical].setPiece(piece);
                    break;
                case KILL:
                    piece.move(newHorizontal, newVertical);
                    board[oldHorizontal][oldVertical].setPiece(null);
                    board[newHorizontal][newVertical].setPiece(piece);
                    Piece killedPiece = result.getPiece();
                    board[pixelToBoard(killedPiece.getOldHorizontal())][pixelToBoard(killedPiece.getOldVertical())].setPiece(null);
                    pieceGroup.getChildren().remove(killedPiece);
                    break;

            }
        }
        );
    }

    private MoveResult tryMove(Piece piece, int newHorizontal, int newVertical) {

        if (newVertical > 4 || newHorizontal > 4){
            System.out.println("Out of board selection");
            return new MoveResult((MoveType.NONE));}
        if ((board[newHorizontal][newVertical] == null)) {
            System.out.println("null Board for"+newHorizontal+", "+newVertical);
            return new MoveResult(MoveType.NONE);
        }
        if (board[newHorizontal][newVertical].hasPiece()) {
            System.out.println("HAS PIECE, NO MOVE"+ newHorizontal + ", " + newVertical);
            return new MoveResult(MoveType.NONE);
        }
        int oldHorizontal = pixelToBoard(piece.getOldHorizontal());
        int oldVertical = pixelToBoard(piece.getOldVertical());
        System.out.println("Try move to(" + newHorizontal + ", " + newVertical+") from ("+oldHorizontal+","+oldVertical+")");

        if (!((Math.abs(newVertical - oldVertical) < 2)
                ^(Math.abs(newHorizontal-oldHorizontal)<2))) {
          //  System.out.println((newVertical - oldVertical)+" "+);
            return new MoveResult(MoveType.NORMAL);


        } else if (Math.abs((newVertical - oldVertical))== 2 ^
                Math.abs(newHorizontal - oldHorizontal) ==2) {
            System.out.println(piece.getPieceTypeEnum());
            if(piece.getPieceTypeEnum()== PieceTypeEnum.TIGER)
            { int killedX = oldHorizontal + (newHorizontal - oldHorizontal) / 2;
            System.out.println("Killed");
            int killedY = oldVertical + (newVertical - oldVertical)/ 2;
            if (board[killedX][killedY].hasPiece()) {
                return new MoveResult(MoveType.KILL, board[killedX][killedY].getPiece());}
            }
            else System.out.println("Goat can't kill");


        }
        return new MoveResult(MoveType.NONE);


    }

    private int pixelToBoard(double pixel) {
        //System.out.println("Layout Pixel is:"+pixel);
        return (int) pixel / (positionSize * 2);
    }
    private void drawLine()
    {
        lineGroup.setHorizontalLine1(board[0][0],board[4][0]);
        lineGroup.setHorizontalLine2(board[1][1],board[3][1]);
        lineGroup.setHorizontalLine3(board[1][3],board[3][3]);
        lineGroup.setHorizontalLine4(board[0][4],board[4][4]);
        lineGroup.setVerticalLine1(board[0][0],board[4][4]);
        lineGroup.setVerticalLine2(board[2][0],board[2][4]);
        lineGroup.setVerticalLine3(board[4][0],board[0][4]);
    }



}
class BoardListener{
    Position[][] board;
    BoardListener(Position[][] board){
        this.board = board;

    }
    BoardListener(){}

}
