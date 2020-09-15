package NewBaghbondi;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class GameStage {

    static final int positionSize = 50;

    private int languageOption;
    private TextArea messages;
    private TextField input;

    private Pane paneOfGame;
    private Scene sceneOfGame;
    private Stage stageOfGame;

    private GameBoard gameBoard;

    protected GameStage(int languageOption){
        this.languageOption = languageOption;
        paneOfGame = new Pane();
        stageOfGame = new Stage();
        gameBoard = new GameBoard();
    }

    private Parent createContent() {
        paneOfGame.setPrefSize(950, 650);
        getMessagesInputFromChatBox();

        Pane gamePane = createGamePane();
        paneOfGame.getChildren().addAll(gamePane, messages, input);
        paneOfGame.setBackground(setBackgroundPicture("resources/backGroundPicture.png"));

        gameBoard.createBoardListenerAndAddPieceToPosition(stageOfGame, paneOfGame, languageOption);
        return paneOfGame;
    }

    private Pane createGamePane() {
        Pane gamePane = new Pane();
        gameBoard.drawBoardAndBoardLine();
        gamePane.getChildren().addAll(gameBoard.getPositionGroup(), gameBoard.getPieceGroup(), gameBoard.getBoardLineGroup());
        gamePane.setPrefSize(500, 500);
        gamePane.setLayoutX(100);
        gamePane.setLayoutY(100);
        return gamePane;
    }

    public void boardStage() {
        sceneOfGame = new Scene(createContent());
        stageOfGame.setScene(sceneOfGame);
        stageOfGame.setTitle("BaghBondi");
        stageOfGame.show();
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
}

