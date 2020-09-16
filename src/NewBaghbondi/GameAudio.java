// have to change....just wrote shameless green
package NewBaghbondi;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.nio.file.Paths;

public class GameAudio {
    MediaPlayer mediaPlayer;
    public void introAudio(){
        String path="resources/gameIntroMusic.mp3";
//      Media media=new Media(new File(path).toURI().toString());
        Media media=new Media(Paths.get(path).toUri().toString());
        mediaPlayer=new MediaPlayer(media);
        mediaPlayer.play();

    }

}
