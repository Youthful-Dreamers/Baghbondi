package code;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.UnknownHostException;

public class ServerScene {

    private GetIP getIP;
    private Label notice;
    private Label ipAddressNotification;
    private Button gameButton;
    private VBox vBox;
    private Scene serverScene;

    private SceneBuilder sceneBuilder;
    private int languageOption;
    private GameAudio gameAudio;

    protected ServerScene(int languageOption) throws UnknownHostException {
        this.languageOption = languageOption;
        getIP = new GetIP();
        sceneBuilder = new SceneBuilder();
        createServerScene();
        gameAudio = new GameAudio();
    }

    private void createLabels(){
        notice = sceneBuilder.createLabel(30);
        notice.setTextFill(Color.web("#004400"));
        if(languageOption == 1) notice.setText("নিচের আইপি অ্যাড্রেসটি আপনার বন্ধুর সাথে শেয়ার করুন");
        else notice.setText("Share the shown IP Address with your friend");
        ipAddressNotification = sceneBuilder.createLabel(30);
        ipAddressNotification.setTextFill(Color.web("#004400"));
        ipAddressNotification.setText(getIP.getIP());
    }

    private void createGameButton(){
        gameButton = sceneBuilder.createButton();
        if(languageOption == 1) gameButton.setText("গেমে প্রবেশ করুন");
        else gameButton.setText("Enter Game");
    }

    protected void gameButtonEventHandler(Stage stage, GameScene gameScene, GameOptionScene gameOptionScene){
       gameButton.setOnAction(e-> {
           stage.setScene(gameScene.getSceneOfGame());
           gameAudio.buttonClickedAudio();
           BoardListener boardListener = new BoardListener(stage, gameScene.getGameBoard(), gameScene.getPaneOfGame(), languageOption, gameOptionScene);
       });
    }

    private void createVBox(){
        vBox= new VBox(5);
        vBox.setBackground(sceneBuilder.setBackgroundPicture("resources/gameStartScene.png"));
        vBox.setAlignment(Pos.CENTER);
        createLabels();
        createGameButton();
        vBox.getChildren().addAll(notice, ipAddressNotification, gameButton);
    }

    private void createServerScene(){
        createVBox();
        serverScene = new Scene(vBox, 950, 650);
    }

    protected Scene getServerScene(){
        return serverScene;
    }
}
