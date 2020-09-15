package NewBaghbondi;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class StageCreator {

    static final int positionSize = 50;
    private Group positionGroup = new Group();
    private Group pieceGroup = new Group();
    private BoardLines lineGroup = new BoardLines();
    private Position[][] board = new Position[5][5];
    private Scene gameScene;
    private int verticalLine = 5;
    private int horizontalLine = 5;
    private int languageOption;
    private TextArea messages;
    private TextField input;

    Pane rootPane = new Pane();
    Stage boardStage = new Stage();
    BoardListener listener;

    protected StageCreator(int languageOption){
        this.languageOption = languageOption;
    }

    private Parent createContent() {
        rootPane.setPrefSize(950, 650);
        getMessagesInputFromChatBox();

        Pane gamePane = new Pane();
        configureParent(gamePane);

        rootPane.getChildren().addAll(gamePane, messages, input);
        rootPane.setBackground(setBackgroundPicture("resources/backGroundPicture.png"));

        listener = new BoardListener(boardStage, board, pieceGroup, rootPane, languageOption);
        addPieceToPosition();

        return rootPane;
    }

    private void configureParent(Pane gamePane) {
        drawBoard();
        drawLine();
        gamePane.getChildren().addAll(positionGroup, pieceGroup, lineGroup.getLineGroup());
        gamePane.setPrefSize(500, 500);
        gamePane.setLayoutX(100);
        gamePane.setLayoutY(100);
    }

    public void boardStage() {
        gameScene = new Scene(createContent());
        boardStage.setScene(gameScene);
        boardStage.setTitle("BaghBondi");
        boardStage.show();
    }

    private void getMessagesInputFromChatBox(){
        ChatBox chatBox = new ChatBox();
        messages = chatBox.getMessages();
        input = chatBox.getInput();
    }

    private Background setBackgroundPicture(String string){
        Image image = new Image(string, 950, 650, false, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        return new Background(backgroundImage);
    }

    private void drawBoard() {
        System.out.println("****************Called drawBoard()****************");
        int skip, skipCounter;
        int i, j;
        for (i = -verticalLine / 2, skip = -horizontalLine / 2; i < verticalLine / 2 + 1; i++, skip++) {
            for (skipCounter = 2, j = -Math.abs(i); j < Math.abs(i) + 1; j++) {
                if (skipCounter < Math.abs(skip) - 1) {
                    skipCounter++;
                    continue;
                } else skipCounter = 0;
                createPosition(i, j);

            }
        }
    }

    private void addPieceToPosition() {

        for (int i = 0; i < verticalLine; i++)
            for (int j = 0; j < horizontalLine; j++) {
                Position position = board[i][j];
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

    private void createPosition(int vertical, int horizontal) {
        System.out.println("****************Called createPosition()****************");
        Position position = new Position(vertical + verticalLine / 2, horizontal + horizontalLine / 2);
        System.out.println("On board " + (horizontal + horizontalLine / 2) + " " + (vertical + verticalLine / 2));
        board[horizontal + horizontalLine / 2][vertical + verticalLine / 2] = position;
        positionGroup.getChildren().add(position);

    }

    private Piece makePiece(PlayerType playerType, int vertical, int horizontal) {
        System.out.println("-----Called makePiece()-----");
        Piece piece;
        if (playerType == PlayerType.TIGER)
            piece = new Tiger(vertical, horizontal);
        else
            piece = new Goat(vertical, horizontal);
        listener.addMouseReleaseOptions(piece);
        return piece;

    }


    private void drawLine() {
        lineGroup.setHorizontalLine1(board[0][0], board[4][0]);
        lineGroup.setHorizontalLine2(board[1][1], board[3][1]);
        lineGroup.setHorizontalLine3(board[1][3], board[3][3]);
        lineGroup.setHorizontalLine4(board[0][4], board[4][4]);
        lineGroup.setVerticalLine1(board[0][0], board[4][4]);
        lineGroup.setVerticalLine2(board[2][0], board[2][4]);
        lineGroup.setVerticalLine3(board[4][0], board[0][4]);
    }

    public Stage getStage(){
        return boardStage;
    }
}

