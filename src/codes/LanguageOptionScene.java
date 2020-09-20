package codes;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class LanguageOptionScene {

    Stage stage;
    Scene languageOptionScene;
    SceneBuilder sceneBuilder;
    GameOptionScene gameOptionScene;
    GameAudio gameAudio;
    ClientServerSelectionScene clientServerSelectionScene;
    GameScene gameScene;


    LanguageOptionScene(Stage stage) {
        this.stage = stage;
        sceneBuilder = new SceneBuilder();
        createLanguageOptionScene();
    }

    protected void executeToAvoidLag() {
        this.gameOptionScene = new GameOptionScene(stage);
        gameAudio = new GameAudio();
    }

    protected void createLanguageOptionScene() {
        sceneBuilder.createMenuVBox(5);
        setLabelText();
        setButtonOneText();
        setButtonTwoText();
        buttonsEventWorks();
        languageOptionScene = sceneBuilder.createScene();
    }


    protected Scene getLanguageOptionScene() {
        return languageOptionScene;
    }
    protected void setLabelText() {
        sceneBuilder.labelOne.setText("ভাষা পছন্দ করুনঃ\nSelect a language:");
    }
    protected void setButtonOneText() {
        sceneBuilder.buttonOne.setText("বাংলা");
    }
    protected void setButtonTwoText() {
        sceneBuilder.buttonTwo.setText("English");
    }

    protected void buttonsEventWorks() {
        sceneBuilder.buttonOne.setOnAction(e -> buttonEventWorks(1));
        sceneBuilder.buttonTwo.setOnAction(e -> buttonEventWorks(2));
    }

    private void buttonEventWorks(int languageOption) {
        gameOptionScene.languageBasedWorks(languageOption);
        stage.setScene(gameOptionScene.getGameOptionScene());
        gameAudio.callButtonClickedAudio();
        gameScene = new GameScene(languageOption);
        clientServerSelectionScene = new ClientServerSelectionScene(languageOption);
        gameOptionScene.initializeButtonEventWorks(gameScene, clientServerSelectionScene);
    }
}
