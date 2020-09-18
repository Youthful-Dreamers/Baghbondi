package code;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class GameOverScene {

    private int languageOption;
    private SceneBuilder sceneBuilder;
    private Scene gameOverScene;

    protected GameOverScene(int languageOption){
        this.languageOption = languageOption;
        sceneBuilder = new SceneBuilder();
        sceneBuilder.createGameOverVBox();
        gameOverScene = sceneBuilder.createScene();
    }

    public Scene createGameOverScene(boolean tigerWin) {
        String labelOneString = determineLabelOneString();
        String labelTwoString = determineLabelTwoString(tigerWin);
        sceneBuilder.labelOne.setText(labelOneString);
        sceneBuilder.labelTwo.setText(labelTwoString);
        if(tigerWin) sceneBuilder.labelTwo.setTextFill(Color.web("#ffffff", 1));
        else sceneBuilder.labelTwo.setTextFill(Color.web("#ffff00", 1));
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
}
