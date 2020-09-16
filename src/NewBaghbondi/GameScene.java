package NewBaghbondi;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class GameScene {

    private int languageOption;
    private TextArea messages;
    private TextField input;

    private Pane paneOfBoard = new Pane();
    private Pane paneOfGame = new Pane();
    private Scene sceneOfGame;
    private Stage stageOfGame;

    private GameBoard gameBoard;

    protected GameScene(Stage stageOfGame, int languageOption){
        this.languageOption = languageOption;
        this.stageOfGame = stageOfGame;
        gameBoard = new GameBoard();

        createContent();
        createSceneOfGame();
    }

    private void createContent() {

        paneOfGame.setPrefSize(950, 650);
        getMessagesInputFromChatBox();

        createPaneOfBoard();
        paneOfGame.getChildren().addAll(paneOfBoard, messages, input);
        paneOfGame.setBackground(setBackgroundPicture("resources/backGroundPicture.png"));

        gameBoard.createBoardListenerAndAddPieceToPosition(stageOfGame, paneOfGame, languageOption);
    }

    private void createPaneOfBoard() {
        gameBoard.drawBoardAndBoardLine();
        paneOfBoard.getChildren().addAll(gameBoard.getPositionGroup(), gameBoard.getPieceGroup(), gameBoard.getBoardLineGroup());
        paneOfBoard.setPrefSize(500, 500);
        paneOfBoard.setLayoutX(100);
        paneOfBoard.setLayoutY(100);
    }

    public void createSceneOfGame() {
        sceneOfGame = new Scene(paneOfGame);
    }

    private void getMessagesInputFromChatBox(){
        ChatBox chatBox = new ChatBox();
        messages = chatBox.getMessages();
        input = chatBox.getInput();
    }

    protected Background setBackgroundPicture(String string){
        Image image = new Image(string, 950, 650, false, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        return new Background(backgroundImage);
    }

    protected Scene getSceneOfGame() { return this.sceneOfGame; }
}

