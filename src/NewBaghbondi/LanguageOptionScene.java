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
        sceneBuilder.createMenuVBox(5);
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
        sceneBuilder.labelOne.setText("ভাষা পছন্দ করুনঃ\nSelect a language:");
    }

    protected void setButtonOneText() {
        sceneBuilder.buttonOne.setText("বাংলা");
    }

    protected void setButtonTwoText() {
        sceneBuilder.buttonTwo.setText("English");
    }

    protected void buttonOneEventWorks() {
        sceneBuilder.buttonOne.setOnAction(e -> buttonEventWorks(1));
    }

    protected void buttonTwoEventWorks() {
        sceneBuilder.buttonTwo.setOnAction(e -> buttonEventWorks(2));
    }

    private void buttonEventWorks(int languageOption){
        gameOptionScene.languageBasedWorks(languageOption);
        stage.setScene(gameOptionScene.getLanguageOptionScene());
        GameScene gameScene = new GameScene();
        gameOptionScene.initializeButtonEventWorks(gameScene);
    }
}
