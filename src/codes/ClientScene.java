package codes;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ClientScene {

    private Scene clientScene;
    private int languageOption;
    private Label notice;
    private TextField ipField;
    private Label ipText;
    private Pane clientScenePane;
    private Rectangle backGround;
    private String ip;

    private SceneBuilder sceneBuilder;
    private GameAudio gameAudio;
    private CreateConnection createClientConnection;

    protected ClientScene(int languageOption) {
        this.languageOption = languageOption;
        sceneBuilder = new SceneBuilder();
        createClientScene();
        gameAudio = new GameAudio();
    }

    private void createNoticeLabel() {
        notice = sceneBuilder.createLabel(30);
        if (languageOption == 1) notice.setText("আপনার বন্ধুর সার্ভারের আইপিটি সংগ্রহ করুন");
        else notice.setText("Please Get IP of the server from your friend");
        notice.setLayoutX(150);
        notice.setLayoutY(300);
        notice.setTextFill(Color.web("#004400"));
    }

    private void createIPText() {
        ipText = sceneBuilder.createLabel(28);
        ipText.setTextFill(Color.web("#004400"));
        if (languageOption == 1) {
            ipText.setText("আইপিঃ");
            ipText.setLayoutX(330);
        } else {
            ipText.setText("IP:");
            ipText.setLayoutX(398);
        }
        ipText.setLayoutY(345);
    }

    private void createIPTextField() {
        ipField = new TextField();
        ipField.setLayoutX(445);
        ipField.setLayoutY(350);
    }

    protected void ipFieldEventHandler(Stage stage, GameScene gameScene, GameOptionScene gameOptionScene) {
        ipField.setOnAction(e -> {
            ip = ipField.getText();
            stage.setScene(gameScene.getSceneOfGame());
            gameAudio.callButtonClickedAudio();
            createClientConnection = new CreateConnection(false, gameScene.getChatBox(), ip);
            BoardListener boardListener = new BoardListener(stage, gameScene.getGameBoard(), gameScene.getPaneOfGame(), languageOption, gameOptionScene, createClientConnection, false, true);
            createClientConnection.getClientConnection().startConnection();
            gameScene.getChatBox().inputEventHandlerServer(createClientConnection.getClientConnection(), null, false);
        });
    }

    private void creatPane() {
        createNoticeLabel();
        createIPText();
        createIPTextField();
        backGround = sceneBuilder.createBackground(25, 200, 900, 300);
        clientScenePane = new Pane();
        clientScenePane.setPrefSize(950, 650);
        clientScenePane.setBackground(sceneBuilder.setBackgroundPicture("resources/gameStartScene.png"));
        clientScenePane.getChildren().addAll(backGround, notice, ipText, ipField);
    }

    private void createClientScene() {
        creatPane();
        clientScene = new Scene(clientScenePane);
    }

    protected Scene getClientScene() {
        return clientScene;
    }

    protected String getIp() {
        return ip;
    }
}
