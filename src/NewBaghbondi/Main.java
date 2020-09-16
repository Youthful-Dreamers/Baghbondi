package NewBaghbondi;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;

public class Main extends Application{


    @Override
    public void start(Stage primaryStage){
        Menu mainMenu = new Menu(primaryStage);
        primaryStage.setScene(mainMenu.createSceneLanguageOption());
        primaryStage.setTitle("BaghBondi");
        introAudio();
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }


    public void introAudio(){
      String path="src/resources/gameIntroMusic.mp3";
      Media media=new Media(new File(path).toURI().toString());
       MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.play();
    }
}
