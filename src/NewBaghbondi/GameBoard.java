package NewBaghbondi;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameBoard {

    private int verticalLine = 5;
    private int horizontalLine = 5;
    private Group pieceGroup = new Group();
    private Group positionGroup = new Group();
    private Group boardLineGroup = new Group();
    private Position[][] positions = new Position[5][5];

    private BoardLine boardLine;
    private BoardListener boardListener;


    protected GameBoard(){
        boardLine = new BoardLine(positions);
    }

    protected void drawBoardAndBoardLine(){
        drawBoard();
        drawLineInBoard();
        boardLineGroup = boardLine.createLineGroup();
    }

    protected void createBoardListenerAndAddPieceToPosition(Stage stageOfGame, Pane paneOfGame, int languageOption){
        boardListener = new BoardListener(stageOfGame, positions, pieceGroup, paneOfGame, languageOption);
        addPieceToPosition();
    }


    protected void drawLineInBoard() {
        boardLine.setHorizontalLine1(positions[0][0], positions[4][0]);
        boardLine.setHorizontalLine2(positions[1][1], positions[3][1]);
        boardLine.setHorizontalLine3(positions[1][3], positions[3][3]);
        boardLine.setHorizontalLine4(positions[0][4], positions[4][4]);
        boardLine.setVerticalLine1(positions[0][0], positions[4][4]);
        boardLine.setVerticalLine2(positions[2][0], positions[2][4]);
        boardLine.setVerticalLine3(positions[4][0], positions[0][4]);
    }

    private void drawBoard() {
        int skip, skipCounter;
        int i, j;
        for (i = -verticalLine / 2, skip = -horizontalLine / 2; i < verticalLine / 2 + 1; i++, skip++) {
            for (skipCounter = 2, j = -Math.abs(i); j < Math.abs(i) + 1; j++) {
                if (skipCounter < Math.abs(skip) - 1) {
                    skipCounter++;
                    continue;
                } else skipCounter = 0;
                createAndSetPositionInBoard(i, j);
            }
        }
    }

    private void createAndSetPositionInBoard(int vertical, int horizontal) {
        Position position = new Position(vertical + verticalLine / 2, horizontal + horizontalLine / 2);
        positions[horizontal + horizontalLine / 2][vertical + verticalLine / 2] = position;
        positionGroup.getChildren().add(position);
    }

    private Piece makePiece(PlayerType playerType, int vertical, int horizontal) {
        Piece piece;
        if (playerType == PlayerType.TIGER)
            piece = new Tiger(vertical, horizontal);
        else
            piece = new Goat(vertical, horizontal);
        boardListener.addMouseReleaseOptions(piece);
        return piece;
    }

    private void addPieceToPosition() {
        for (int i = 0; i < verticalLine; i++)
            for (int j = 0; j < horizontalLine; j++) {
                Position position = positions[i][j];
                if (position == null) continue;
                Piece piece = null;
                if (j >= 2) {
                    piece = makePiece(PlayerType.GOAT, position.getVertical(), position.getHorizontal());
                    System.out.println("Making piece type :: goat: " + position.getLayoutX() + "," + position.getLayoutY());

                } else if (i == 2 && j == 1) {
                    piece = makePiece(PlayerType.TIGER, position.getVertical(), position.getHorizontal());
                }
                if (piece != null) {

                    position.setPiece(piece);
                    pieceGroup.getChildren().add(piece);
                }
            }
    }

    protected Group getPieceGroup(){ return pieceGroup; }
    protected Group getPositionGroup(){ return positionGroup; }
    protected Group getBoardLineGroup(){ return boardLineGroup; }
}
