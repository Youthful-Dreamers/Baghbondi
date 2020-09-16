package NewBaghbondi;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameOptionScene {

    int languageOption;
    Stage stage;
    Scene gameScene;
    Scene gameOptionScene;
    SceneBuilder sceneBuilder;

    protected GameOptionScene(Stage stage){
        this.stage = stage;
        sceneBuilder = new SceneBuilder();
        createGameOptionScene();
    }

    protected void createGameOptionScene(){
        sceneBuilder.createMenuSceneElements(5);
        gameOptionScene = sceneBuilder.createScene();
    }

    protected void languageBasedWorks(int languageOption){
        this.languageOption = languageOption;
        setLabelText();
        setButtonOneText();
        setButtonTwoText();
    }

    protected void initializeEventWorks(){
        buttonOneEventWorks();
        buttonTwoEventWorks();
    }

    protected void setLabelText(){
        if(languageOption == 1) sceneBuilder.label.setText("স্বাগতম!");
        else sceneBuilder.label.setText("Welcome!");
    }

    protected void setButtonOneText(){
        if(languageOption == 1) sceneBuilder.buttonOne.setText("ডিফল্ট গেম");
        else sceneBuilder.buttonOne.setText("Default Game");
    }

    protected void setButtonTwoText(){
        if(languageOption == 1) sceneBuilder.buttonTwo.setText("ল্যান হেম");
        else sceneBuilder.buttonTwo.setText("LAN Game");
    }

    protected void buttonOneEventWorks(){
        sceneBuilder.buttonOne.setOnAction( e-> stage.setScene(gameScene));
    }

    protected void buttonTwoEventWorks(){
       sceneBuilder.buttonTwo.setOnAction( e-> stage.setScene(gameScene));
    }

    protected Scene getLanguageOptionScene(){
        return gameOptionScene;
    }

    protected void setGameScene(Scene scene){
        this.gameScene = scene;
    }

}
