package NewBaghbondi;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class LanguageOptionScene {

    Stage stage;
    Scene languageOptionScene;
    SceneBuilder sceneBuilder;
    GameOptionScene gameOptionScene;


    LanguageOptionScene(Stage stage) {
        this.stage = stage;
        sceneBuilder = new SceneBuilder();
        createLanguageOptionScene();
        this.gameOptionScene = new GameOptionScene(stage);
    }

    protected void createLanguageOptionScene() {
        sceneBuilder.createMenuSceneElements(5);
        setLabelText();
        setButtonOneText();
        setButtonTwoText();
        buttonOneEventWorks();
        buttonTwoEventWorks();
        languageOptionScene = sceneBuilder.createScene();
    }


    protected Scene getLanguageOptionScene() {
        return languageOptionScene;
    }

    protected void setLabelText() {
        sceneBuilder.label.setText("ভাষা পছন্দ করুনঃ\nSelect a language:");
    }

    protected void setButtonOneText() {
        sceneBuilder.buttonOne.setText("বাংলা");
    }

    protected void setButtonTwoText() {
        sceneBuilder.buttonTwo.setText("English");
    }

    protected void buttonOneEventWorks() {
        sceneBuilder.buttonOne.setOnAction(e -> {
            gameOptionScene.languageBasedWorks(1);
            stage.setScene(gameOptionScene.getLanguageOptionScene());
            gameOptionScene.initializeEventWorks();
            GameScene gameScene = new GameScene(stage, 1);
            gameOptionScene.setGameScene(gameScene.getSceneOfGame());
        });
    }

    protected void buttonTwoEventWorks() {
        sceneBuilder.buttonTwo.setOnAction(e -> {
            gameOptionScene.languageBasedWorks(2);
            stage.setScene(gameOptionScene.getLanguageOptionScene());
            gameOptionScene.initializeEventWorks();
            GameScene gameScene = new GameScene(stage, 2);
            gameOptionScene.setGameScene(gameScene.getSceneOfGame());
        });
    }
}
