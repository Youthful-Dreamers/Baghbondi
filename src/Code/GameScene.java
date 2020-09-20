package code;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameScene {

    private Pane paneOfBoard = new Pane();
    private Pane paneOfGame = new Pane();
    private Scene sceneOfGame;
    private Rectangle clockTiger;
    private Rectangle clockGoat;

    private GameBoard gameBoard;
    private ChatBox chatBox;
    private int languageOption;

    protected GameScene(int languageOption) {
        this.languageOption = languageOption;
        gameBoard = new GameBoard();
        createContent();
        createSceneOfGame();
    }

    private void createContent() {
        paneOfGame.setPrefSize(950, 650);
        getMessagesInputFromChatBox();

        createPaneOfBoard();
        createRectangles();
        paneOfGame.getChildren().addAll(paneOfBoard, clockGoat, clockTiger);
        paneOfGame.setBackground(setBackgroundPicture("resources/backGroundPicture.png"));
        gameBoard.addPieceToPosition();
    }

    private void createRectangles() {
        clockTiger = new Rectangle(110, 12, 235, 45);
        clockTiger.setFill(Color.LIGHTGREEN);
        clockTiger.setOpacity(0.7);
        clockGoat = new Rectangle(360, 12, 245, 45);
        clockGoat.setFill(Color.LIGHTGREEN);
        clockGoat.setOpacity(0.7);
    }

    private void createPaneOfBoard() {
        gameBoard.drawBoardAndBoardLine();
        paneOfBoard.getChildren().addAll(gameBoard.getPositionGroup(), gameBoard.getBoardLineGroup(), gameBoard.getPieceGroup());
        paneOfBoard.setPrefSize(500, 500);
        paneOfBoard.setLayoutX(100);
        paneOfBoard.setLayoutY(100);
    }

    public void createSceneOfGame() {
        sceneOfGame = new Scene(paneOfGame);
    }

    private void getMessagesInputFromChatBox() {
        chatBox = new ChatBox(languageOption, paneOfGame);
    }

    protected Background setBackgroundPicture(String string) {
        Image image = new Image(string, 950, 650, false, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        return new Background(backgroundImage);
    }

    protected Scene getSceneOfGame() {
        return this.sceneOfGame;
    }

    protected Pane getPaneOfGame() {
        return paneOfGame;
    }

    protected GameBoard getGameBoard() {
        return gameBoard;
    }

    protected ChatBox getChatBox() {
        return chatBox;
    }

}
