package NewBaghbondi;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameOptionScene {

    int languageOption;
    Stage stage;
    Scene gameOptionScene;
    SceneBuilder sceneBuilder;

    protected GameOptionScene(Stage stage){
        this.stage = stage;
        sceneBuilder = new SceneBuilder();
        createGameOptionScene();
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

    protected void initializeButtonEventWorks(GameScene gameScene){
        sceneBuilder.buttonOne.setOnAction( e-> stage.setScene(gameScene.getSceneOfGame()));
        sceneBuilder.buttonTwo.setOnAction( e-> stage.setScene(gameScene.getSceneOfGame()));
        callingBoardListener(gameScene.getGameBoard(), gameScene.getPaneOfGame());
    }

    private void callingBoardListener(GameBoard gameBoard, Pane rootPane){
        BoardListener boardListener = new BoardListener(stage, gameBoard, rootPane, languageOption);
    }

    protected Scene getLanguageOptionScene(){
        return gameOptionScene;
    }
}
