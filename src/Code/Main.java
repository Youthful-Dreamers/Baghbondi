package code;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{


    @Override
    public void start(Stage primaryStage){
       LanguageOptionScene languageOptionScene=new LanguageOptionScene(primaryStage);
       languageOptionScene.executeToAvoidLag();
       GameAudio gameAudio=new GameAudio();
        //gameAudio.inGameAudio();
        primaryStage.setScene(languageOptionScene.getLanguageOptionScene());
        primaryStage.setTitle("BaghBondi");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
