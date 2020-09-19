package code;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ServerScene {

    private GetIP getIP;
    private Label notice;
    private Label ipAddressNotification;
    private Button gameButton;
    private VBox vBox;
    private Scene serverScene;
    private Rectangle backGround;
    private StackPane stackPane;

    private SceneBuilder sceneBuilder;
    private int languageOption;
    private GameAudio gameAudio;
    private String localServerIP;
    private CreateConnection createServerConnection;

    protected ServerScene(int languageOption){
        this.languageOption = languageOption;
        getIP = new GetIP();
        localServerIP = getIP.getIP();
        sceneBuilder = new SceneBuilder();
        createServerScene();
        gameAudio = new GameAudio();
    }

    private void createLabels(){
        notice = sceneBuilder.createLabel(30);
        notice.setTextFill(Color.web("#003300"));
        if(languageOption == 1) notice.setText("নিচের আইপি অ্যাড্রেসটি আপনার বন্ধুর সাথে শেয়ার করুন\n         আপনাকে অবশ্যই প্রথমে খেলা শুরু করতে হবে");
        else notice.setText("Share the shown IP Address with your friend\n            You must start the Game First");
        ipAddressNotification = sceneBuilder.createLabel(30);
        ipAddressNotification.setTextFill(Color.web("#003300"));
        ipAddressNotification.setText(localServerIP);
    }

    private void createGameButton(){
        gameButton = sceneBuilder.createButton();
        if(languageOption == 1) gameButton.setText("গেমে প্রবেশ করুন");
        else gameButton.setText("Enter Game");
    }

    protected void gameButtonEventHandler(Stage stage, GameScene gameScene, GameOptionScene gameOptionScene){
       gameButton.setOnAction(e-> {
           stage.setScene(gameScene.getSceneOfGame());
           //gameAudio.buttonClickedAudio();
           createServerConnection = new CreateConnection(true, gameScene.getChatBox(), null);
           BoardListener boardListener = new BoardListener(stage, gameScene.getGameBoard(), gameScene.getPaneOfGame(), languageOption, gameOptionScene, createServerConnection, true, true);
           createServerConnection.getServerConnection().startConnection();
           gameScene.getChatBox().inputEventHandlerServer(null, createServerConnection.getServerConnection(), true);
       });
    }

    private void createVBox(){
        vBox= new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        createLabels();
        createGameButton();
        vBox.getChildren().addAll(notice, ipAddressNotification, gameButton);
    }

    private void createServerScene(){
        createVBox();
        backGround = sceneBuilder.createBackground(25,200, 900, 300);
        stackPane = sceneBuilder.createPane(backGround, vBox);
        serverScene = new Scene(stackPane, 950, 650);
    }

    protected Scene getServerScene(){
        return serverScene;
    }
}
