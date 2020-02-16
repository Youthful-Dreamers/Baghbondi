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
    private Position[][] board = new Position[5][5];
    private int verticalLine = 5;
    private int horizontalLine = 5;

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(800, 600);
        root.getChildren().addAll(positionGroup, pieceGroup);
        boardDrawer();

        return root;
    }

    public void boardSceneView() {
        Stage boardStage = new Stage();
        boardStage.setScene(new Scene(createContent()));
        boardStage.setTitle("BaghBondi");
        boardStage.show();
    }

    private void boardDrawer() {
        int skip, skipCounter;
        int i, j = 0;
        for (i = -verticalLine / 2, skip = -horizontalLine / 2; i < verticalLine / 2 + 1; i++, skip++) {
            // System.out.println(i);
            /*if(i<verticalLine/2+1) {
                j = i;
            }
            else j-=i+1;*/
            for (skipCounter = 2, j = -Math.abs(i); j < Math.abs(i) + 1; j++) {
                if (skipCounter < Math.abs(skip) - 1) {
                    skipCounter++;
                    continue;
                } else skipCounter = 0;
                Position position = createPosition(i, j);
                Piece piece = null;
                if (i >= 0) {
                    piece = makePiece(PieceType.GOAT, i + verticalLine / 2, j + horizontalLine / 2);

                }
                else if(i==-1&&j==0)
                {
                    piece = makePiece(PieceType.TIGER,i + verticalLine / 2, j + horizontalLine / 2);
                }
                if (piece != null) {
                    position.setPiece(piece);
                    pieceGroup.getChildren().add(piece);
                }


            }
        }

    }

    private Position createPosition(int vertical, int horizontal) { 
        Position position = new Position(vertical + verticalLine / 2, horizontal + horizontalLine / 2);
        System.out.println((vertical + verticalLine / 2) + " " + (horizontal + horizontalLine / 2));
        board[vertical + verticalLine / 2][horizontal + horizontalLine / 2] = position;
        positionGroup.getChildren().add(position);
        return position;
    }

    private Piece makePiece(PieceType pieceType, int vertical, int horizontal) {
        Piece piece = new Piece(pieceType, vertical, horizontal);
        piece.setOnMouseReleased(e ->{
        int newHorizonal = pixelToBoard(piece.getLayoutX());
        int oldHorizontal= pixelToBoard(piece.getOldHorizontal());
        int newVertical = pixelToBoard(piece.getLayoutY());
        int oldvertical = pixelToBoard(piece.getOldVertical());
        MoveResult result = tryMove(piece,newHorizonal,newVertical);

        switch (result.getType())
        {
            case NONE:
                piece.abortMove();
                break;
            case NORMAL:
                piece.move(newHorizonal,newVertical);
                board[oldHorizontal][oldvertical].setPiece(null);
                board[newHorizonal][newVertical].setPiece(piece);
                break;
            case KILL:
                piece.move(newHorizonal,newVertical);
                board[oldHorizontal][oldvertical].setPiece(null);
                board[newHorizonal][newVertical].setPiece(piece);
                Piece killedPiece = result.getPiece();
                board[pixelToBoard(killedPiece.getOldHorizontal())][pixelToBoard(killedPiece.getOldVertical())].setPiece(null);
                pieceGroup.getChildren().remove(killedPiece);
                break;

        }
        });
        return piece;
    }
    private MoveResult tryMove(Piece piece, int newHorizontal, int newVertical)
    {
        System.out.println("Try move at "+newHorizontal+", "+newVertical);
        if(newVertical>4||newHorizontal>4) return new MoveResult((MoveType.NONE));
        if (board[newHorizontal][newVertical].hasPiece())
        {
            return new MoveResult(MoveType.NONE);
        }
        int  oldHorizontal= pixelToBoard(piece.getOldHorizontal());
        int oldVertical= pixelToBoard(piece.getOldVertical());
        if(Math.abs(newVertical-oldVertical)==1)
        {
            return new MoveResult(MoveType.NORMAL);
        }
        else if(Math.abs(newHorizontal-oldVertical)==2||Math.abs((newVertical-oldVertical))==2)
        {
            int killedX =oldHorizontal + (newHorizontal-oldHorizontal)/2;
            int killedY = oldVertical  + (newVertical-oldVertical)/2;
                 if(board[killedX][killedY].hasPiece()
                    &&board[killedX][killedY].getPiece().getPieceType()!=piece.getPieceType())
                 {
                     return new MoveResult(MoveType.KILL,board[killedX][killedY].getPiece());
                 }

        }
        return new MoveResult(MoveType.NONE);


    }

    private int pixelToBoard(double pixel)
    {
        System.out.println("Layout Pixel is:"+pixel);
        return (int) pixel/(positionSize*2);
    }


}
