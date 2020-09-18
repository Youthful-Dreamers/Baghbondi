package code;

import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.UnknownHostException;

public class GameOptionScene {

    int languageOption;
    Stage stage;
    Scene gameOptionScene;
    SceneBuilder sceneBuilder;
    GameAudio gameAudio;

    protected GameOptionScene(Stage stage){
        this.stage = stage;
        sceneBuilder = new SceneBuilder();
        createGameOptionScene();
        gameAudio=new GameAudio();
    }

    protected void createGameOptionScene(){
        sceneBuilder.createMenuVBox(5);
        gameOptionScene = sceneBuilder.createScene();
    }

    protected void languageBasedWorks(int languageOption){
        this.languageOption = languageOption;
        setLabelText();
        setButtonOneText();
        setButtonTwoText();
    }

    protected void setLabelText(){
        if(languageOption == 1) sceneBuilder.labelOne.setText("স্বাগতম!");
        else sceneBuilder.labelOne.setText("Welcome!");
    }

    protected void setButtonOneText(){
        if(languageOption == 1) sceneBuilder.buttonOne.setText("ডিফল্ট গেম");
        else sceneBuilder.buttonOne.setText("Default Game");
    }

    protected void setButtonTwoText(){
        if(languageOption == 1) sceneBuilder.buttonTwo.setText("ল্যান গেম");
        else sceneBuilder.buttonTwo.setText("LAN Game");
    }

    protected void initializeButtonEventWorks(GameScene gameScene, ClientServerSelectionScene clientServerSelectionScene){
        sceneBuilder.buttonOne.setOnAction( e->  {
            buttonOneEventWorks(gameScene);
        });
        sceneBuilder.buttonTwo.setOnAction( e-> {
            stage.setScene(clientServerSelectionScene.getClientServerSelectionScene());
            ClientScene clientScene = new ClientScene(languageOption);
            clientScene.ipFieldEventHandler(stage, gameScene);
            try {
                ServerScene serverScene = new ServerScene(languageOption);
                serverScene.gameButtonEventHandler(stage, gameScene);
                clientServerSelectionScene.buttonEventHandler(stage, clientScene, serverScene);
            } catch (UnknownHostException ex) {
                System.out.println("Error in getting ip address: "+e);
            }
        });
    }

    private void buttonOneEventWorks(GameScene gameScene){
        gameScene.getPaneOfGame().getChildren().removeAll(gameScene.getMessages(), gameScene.getInput());
        stage.setScene(gameScene.getSceneOfGame());
        //gameAudio.buttonClickedAudio();
        BoardListener boardListener = new BoardListener(stage, gameScene.getGameBoard(), gameScene.getPaneOfGame(), languageOption);
    }

    protected Scene getLanguageOptionScene(){
        return gameOptionScene;
    }
}
