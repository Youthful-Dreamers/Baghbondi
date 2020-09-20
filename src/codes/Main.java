package codes;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        LanguageOptionScene languageOptionScene = new LanguageOptionScene(primaryStage);
        languageOptionScene.executeToAvoidLag();
        GameAudio gameAudio = new GameAudio();
        //gameAudio.inGameAudio();
        primaryStage.setScene(languageOptionScene.getLanguageOptionScene());
        primaryStage.setTitle("BaghBondi");
        primaryStage.show();
    }
}
