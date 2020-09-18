package code;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameOverScene {

    private int languageOption;
    private SceneBuilder sceneBuilder;
    private Scene gameOverScene;
    private Button restartButton;
    GameAudio gameAudio;

    protected GameOverScene(int languageOption){
        this.languageOption = languageOption;
        gameAudio = new GameAudio();
        sceneBuilder = new SceneBuilder();
        sceneBuilder.createGameOverVBox();
        createRestartButton();
        gameOverScene = sceneBuilder.createScene();
    }

    public Scene createGameOverScene(boolean tigerWin) {
        String labelOneString = determineLabelOneString();
        String labelTwoString = determineLabelTwoString(tigerWin);
        sceneBuilder.labelOne.setText(labelOneString);
        sceneBuilder.labelTwo.setText(labelTwoString);
        if(tigerWin) sceneBuilder.labelTwo.setTextFill(Color.web("#ff0000", 1));
        else sceneBuilder.labelTwo.setTextFill(Color.web("#0000ff", 1));
        return gameOverScene;
    }

    private String determineLabelOneString(){
        String labelOneString;
        if(languageOption == 1) labelOneString = "খেলা সমাপ্ত!";
        else labelOneString = "Game Over!";
        return  labelOneString;
    }

    private String determineLabelTwoString(boolean tigerWin){
        String type;
        String labelTwoString;
        if (tigerWin) {
            if(languageOption == 1) type = "বাঘ";
            else type = "Tiger";
        } else {
            if(languageOption == 1) type = "ছাগল";
            else type = "Goat";
        }
        if(languageOption == 1) labelTwoString = type+" জিতেছে!!";
        else labelTwoString = type+" has own the game!!";
        return labelTwoString;
    }

    private void createRestartButton(){
        restartButton = sceneBuilder.createButton();
        if(languageOption==1) restartButton.setText("নতুন গেম শুরু করুন");
        else restartButton.setText("Start a new game again");
    }

    protected void buttonEventWorks(Stage stage, GameOptionScene gameOptionScene){
        restartButton.setOnAction(e->{
            stage.setScene(gameOptionScene.getGameOptionScene());
            gameAudio.buttonClickedAudio();
            workForMultipleRun(gameOptionScene);
        });
    }

    protected Button getRestartButton(){
        return restartButton;
    }

    protected VBox getGameOverSceneVBox(){
        return sceneBuilder.getVBox();
    }

    private void workForMultipleRun(GameOptionScene gameOptionScene){
        //gameAudio.buttonClickedAudio();
        GameScene newGameScene = new GameScene();
        ClientServerSelectionScene newClientServerSelectionScene = new ClientServerSelectionScene(languageOption);
        gameOptionScene.initializeButtonEventWorks(newGameScene, newClientServerSelectionScene);
    }
}
