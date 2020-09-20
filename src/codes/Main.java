package codes;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GameAudio gameAudio = new GameAudio();
        LanguageOptionScene languageOptionScene = new LanguageOptionScene(primaryStage);
        languageOptionScene.executeToAvoidLag();
        gameAudio.callInGameAudio();
        primaryStage.setScene(languageOptionScene.getLanguageOptionScene());
        primaryStage.setTitle("BaghBondi");
        primaryStage.show();
    }
}
