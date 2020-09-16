package NewBaghbondi;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.nio.file.Paths;

public class Main extends Application{


    @Override
    public void start(Stage primaryStage){
        Menu mainMenu = new Menu(primaryStage);
        GameAudio gameAudio=new GameAudio();
        primaryStage.setScene(mainMenu.createSceneLanguageOption());
        primaryStage.setTitle("BaghBondi");
        gameAudio.introAudio(0);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
