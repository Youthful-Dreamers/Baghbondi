// have to change....just wrote shameless green
package NewBaghbondi;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.nio.file.Paths;

public class GameAudio {

        public void inGameAudio(){
            String path="src/resources/inGameAudio.mp3";
            Media media=new Media(new File(path).toURI().toString());
            MediaPlayer mediaPlayer=new MediaPlayer(media);
                mediaPlayer.setOnEndOfMedia(new Runnable() {
                    @Override
                    public void run() {
                        mediaPlayer.seek(Duration.ZERO);
                    }
                });
                mediaPlayer.setVolume(0.5);
                mediaPlayer.play();
                System.out.println(mediaPlayer.isMute());
        }

}

