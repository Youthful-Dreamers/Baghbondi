package NewBaghbondi;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

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
        int i, j;
        for (i = -verticalLine / 2, skip = -horizontalLine / 2; i < verticalLine / 2 + 1; i++, skip++) {
            for (skipCounter = 2, j = -Math.abs(i); j < Math.abs(i) + 1; j++) {
                if (skipCounter < Math.abs(skip) - 1) {
                    skipCounter++;
                    continue;
                } else skipCounter = 0;
                Position position = createPosition(i, j);
                Piece piece = null;
                if (i >= 0) {
                    piece = makePiece(PieceType.Goat, i + verticalLine / 2, j + horizontalLine / 2);

                }
                else if(i==-1&&j==0)
                {
                    piece = makePiece(PieceType.Tiger,i + verticalLine / 2, j + horizontalLine / 2);
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

    private Piece makePiece(PieceType pieceType, int horizontal, int vertical) {
        Piece piece = new Piece(pieceType, horizontal, vertical);
        return piece;
    }


}
